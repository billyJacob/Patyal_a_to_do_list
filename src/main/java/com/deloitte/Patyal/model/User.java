package com.deloitte.Patyal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is the bean class for the User Entity. It has the attributes
 * related to the User Entity and the constructors for creating an object for
 * that class.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	@Column
	String userName;
	@Column
	String emailAddress;

	@Column
	String password;

}
