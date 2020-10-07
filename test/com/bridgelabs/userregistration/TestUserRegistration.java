package com.bridgelabs.userregistration.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bridgelabs.userregistration.UserRegistration;

public class TestUserRegistration {

	@Test
	// valid test
	public void happyMood() {
		assertTrue(UserRegistration.validateFirstName("Nik"));
		assertTrue(UserRegistration.validateLastName("Nikh"));
		assertTrue(UserRegistration.validateEmail("abc@yahoo.com"));
		assertTrue(UserRegistration.validatePhoneNumber("91 0123456789"));
		assertTrue(UserRegistration.validatePassword("wXyz@123"));
	}

	@Test
	// invalid test
	public void sadMood() {
		// invalid firstName
		assertFalse(UserRegistration.validateFirstName("nik"));
		assertFalse(UserRegistration.validateFirstName("Ni"));
		assertFalse(UserRegistration.validateFirstName("Nikh@il"));
		// invalid lastName
		assertFalse(UserRegistration.validateLastName("nikh"));
		assertFalse(UserRegistration.validateLastName("Ni"));
		assertFalse(UserRegistration.validateLastName("Nikh@il"));
		// invalid email
		assertFalse(UserRegistration.validateEmail("abc@.com"));
		// invalid phoneNo
		assertFalse(UserRegistration.validatePhoneNumber("9 0123456789"));
		// invalid password
		assertFalse(UserRegistration.validatePassword("Xyz1@"));
		assertFalse(UserRegistration.validatePassword("wxyz@123"));
		assertFalse(UserRegistration.validatePassword("w#xyz@123"));
		assertFalse(UserRegistration.validatePassword("aBcdefgh@"));
	}
}
