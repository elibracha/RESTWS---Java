package core.api.utilities;

import core.api.DTO.UserDTO;
import core.api.exceptions.ErrorMessages;
import core.api.exceptions.MissingRequiredFieldsException;

public class UsersUtilities {

    private final byte MIN_PASSWORD_LENGTH = 6;

    public void validateRequiredFields (UserDTO userDTO) throws MissingRequiredFieldsException{
        if(userDTO.getFirstname() == null || userDTO.getFirstname().isEmpty() ||
                userDTO.getEmail() == null ||  userDTO.getEmail().isEmpty() ||
                userDTO.getLastname() == null || userDTO.getLastname().isEmpty() ||
                userDTO.getPassword() == null || userDTO.getPassword().isEmpty() ||
                userDTO.getPassword().length() < MIN_PASSWORD_LENGTH){
            throw new MissingRequiredFieldsException(
                    ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }
    }
}
