package core.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Users")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925747817874742775L;

	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	private long id;
	@Column(name="FirstName", nullable = false)
	private String firstname;
	@Column(name="LastName", nullable = false)
    private String lastname;
	@Column(name="Email", nullable = false)
	private String email;
	@Column(name="Password", nullable = false)
	private String encryptedPassword;
	@Column(name="UserID", nullable = false)
	private String userID;
	@Column(name="Salt", nullable = false)
	private String salt;
	
	public User() {}
	
	public User(long id, String firstname, String lastname, String email, String encryptedPassword,
			String userID, String salt) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.userID = userID;
		this.salt = salt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	
}
