package core.api.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * this class represent the user model. The user as four attributes.
 * @author - Eli Bracha
 */
@XmlRootElement
public class CreateUserModel {
    /*
        user state and model
     */
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    /**
     *
     * @param firstname - user's first name
     * @param lastname - user's last name
     * @param password - user's password name
     * @param email- user's email for the system
     */
    public CreateUserModel(String firstname, String lastname, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public CreateUserModel() {}

    /**
     *
     * @return the first name of the user
     */
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return the last name of the user
     */
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return the Email of the user
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
