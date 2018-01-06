package core.api.service;

import core.api.DAO.UserDBDAO;
import core.api.DTO.UserDTO;
import core.api.exceptions.ErrorMessages;
import core.api.exceptions.UserServiceException;
import core.api.interfaces.UserDAO;
import core.api.interfaces.UsersService;
import core.api.utilities.UsersUtilities;

public class UsersServiceImp implements UsersService{

    private UsersUtilities userUtil = new UsersUtilities();

    @Override
    public UserDTO createUser(UserDTO user) {

        UserDTO returnValue = new UserDTO();
        
        userUtil.validateRequiredFields(user);
        
        UserDTO UserFromDatabase = getUserByName(user.getEmail());
        if(UserFromDatabase !=null)
        	throw new UserServiceException(ErrorMessages.USER_ALREADY_EXIST.getErrorMessage());
 
        
        String userId = userUtil.generateUserId();
        user.setUserID(userId);
        
        String salt = userUtil.getSalt();
        String securePassword = userUtil.generateSecurePassword(user.getPassword(), salt);
        
        user.setSalt(salt);
        user.setEncryptedPassword(securePassword);
        
        returnValue = this.saveUser(user);
        return returnValue;
    }
    
    private UserDTO getUserByName(String userEmail){
    	UserDTO userdto = null;
    	
    	if(userEmail == null || userEmail.isEmpty()) {
    		return null;
    	}
    	
    	UserDAO userDao = new UserDBDAO();
    	
    	try {
    		 userDao.openConnection();
    	     userdto = userDao.getUserByName(userEmail);
    	}finally {
    		userDao.closeConnection();
		}
       return userdto;
       
    }
    
    private UserDTO saveUser(UserDTO user) {
    	
    	UserDTO returnValue = null;
    	
    	UserDAO userDao = new UserDBDAO();
    	
    	try {
    		userDao.openConnection();
    		returnValue = userDao.saveUser(user);
	   	}finally {
	   		userDao.closeConnection();
		}
    	
	     return returnValue;

    }
}
