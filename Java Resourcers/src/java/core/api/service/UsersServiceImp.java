package core.api.service;

import core.api.DTO.UserDTO;
import core.api.interfaces.UsersService;
import core.api.utilities.UsersUtilities;

public class UsersServiceImp implements UsersService{

    private UsersUtilities userUtil = new UsersUtilities();

    @Override
    public UserDTO createUser(UserDTO user) {

        UserDTO returnValue = new UserDTO();
        userUtil.validateRequiredFields(user);

        return returnValue;
    }
}
