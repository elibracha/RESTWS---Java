package core.api.utilities;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import core.api.DTO.UserDTO;
import core.api.exceptions.ErrorMessages;
import core.api.exceptions.MissingRequiredFieldsException;

public class UsersUtilities {

    private final byte MIN_PASSWORD_LENGTH = 6;
    private final Random RANDOM = new Random(); 
    private final String ALPHABET = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int ITERATIONS = 10000;
    private final int KEY_LENGTH = 256;
    
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
    
    public String generateUUID() {
    	String returnvalue = UUID.randomUUID().toString().replace("-", "");
    	return returnvalue;
    }
    
    public String generateRandomString(int length) {
    	StringBuilder returnValue = new StringBuilder(length);
    	for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
    	return new String(returnValue);
    }
    
    public String generateUserId() {
    	return generateRandomString(ALPHABET.length());
    }
    
    public String getSalt() {
    	return generateRandomString(ALPHABET.length());
    }
    public String generateSecurePassword(String password, String salt) {
    	String returnValue = null;
    	
    	byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
    	
    	returnValue = Base64.getEncoder().encodeToString(securePassword);
    	
    	return returnValue;
    }
    
    public byte[] hash(char[] password, byte[] salt) {
    	PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
    	Arrays.fill(password, Character.MIN_VALUE);
    	

    		SecretKeyFactory skf;
			try {
				skf = SecretKeyFactory.getInstance(ALPHABET);
				return skf.generateSecret(spec).getEncoded();
			
			} catch (NoSuchAlgorithmException e) {
				throw new AssertionError("Error while parsing Pasword");
			}catch (InvalidKeySpecException e) {
				throw new AssertionError("Error while parsing Pasword");
			}finally {
				spec.clearPassword();
			}

    		
    }
}
