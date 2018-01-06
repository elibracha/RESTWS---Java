package core.api.DTO;

import java.io.Serializable;

/**
 * User data transfer object.
 * this object hold all the data that the layers will pass between each other.
 * @author - Eli Bracha
 */
public class UserDTO implements Serializable{

    /*
        data for each user to be created in the database.
     */

    /**
	 * 
	 */
	private static final long serialVersionUID = -2953066612610815121L;

    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String salt;
    private String encryptedPassword;
    private String userID;
    private long databaseID;

    public UserDTO() {}

    public UserDTO(String firstname, String lastname, String password, String email,
                   String salt, String encryptedPassword, String userID, long databaseID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.salt = salt;
        this.encryptedPassword = encryptedPassword;
        this.userID = userID;
        this.databaseID = databaseID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public long getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(long databaseID) {
        this.databaseID = databaseID;
    }
}
