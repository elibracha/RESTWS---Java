package core.api.interfaces;

import core.api.DTO.UserDTO;



public interface UserDAO {
	void openConnection();
	void closeConnection();
	UserDTO getUserByName(String Username);
	UserDTO saveUser(UserDTO user);
}
