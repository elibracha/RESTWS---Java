package core.api.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represent the user model that being sent back for confirmation .
 * The user as three attributes.
 *
 * @author - Eli Bracha
 */
@XmlRootElement
public class CreateResponseModel {
    /*
        user state and model
     */
    private String userID;
    private String firstname;
    private String lastname;
    private String email;
    private String href;

    /**
     * @param firstname - user's first name
     * @param lastname  - user's last name
     * @param email-    user's email for the system
     */
    public CreateResponseModel(String firstname, String lastname, String email,String userID,
                               String href ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public CreateResponseModel() {}

    /**
     * @return the first name of the user
     */
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the last name of the user
     */
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the Email of the user
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the href of the user
     */
    public String getHref() { return href; }

    public void setHref(String href) { this.href = href; }

    /**
     * @return the user public id
     */
    public String getUserID() { return userID; }

    public void setUserID(String userID) { this.userID = userID; }
}




