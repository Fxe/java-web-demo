package me.fxe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
@Entity
public class User {
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="user_name", unique=true, nullable=false, length=254)
	private String userName;
	
	@Column(name="password", unique=false, nullable=false, length=254)
	private String password;
	
	@Column(name="first_name", unique=false, length=254)
	private String firstName;
	
	@Column(name="last_name", unique=false, length=254)
	private String lastName;
	
	public Long getId() { return id;}
	public void setId(Long id) { this.id = id;}
	
	public String getUserName() { return userName;}
	public void setUserName(String userName) { this.userName = userName;}
	
	public String getPassword() { return password;}
	public void setPassword(String password) { this.password = password;}
	
	public String getFirstName() { return firstName;}
	public void setFirstName(String firstName) { this.firstName = firstName;}
	
	public String getLastName() { return lastName;}
	public void setLastName(String lastName) { this.lastName = lastName;}
	
	@Override
	public String toString() {
		return String.format("User[%d]", id);
	}
}
