package com.bridgelabs.userregistration.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bridgelabs.userregistration.UserRegistration;

public class TestUserRegistration {
	UserRegistration userReg = new UserRegistration();

	@Test
	public void happyMood() {
		assertTrue(userReg.validateFirstName("Nik"));
		assertTrue(userReg.validateLastName("Nikh"));
		assertTrue(userReg.validateEmail("abc@yahoo.com"));
		assertTrue(userReg.validatePhoneNumber("91 0123456789"));
		assertTrue(userReg.validatePassword("wXyz@123"));
	}

	@Test
	public void sadMood() {
		// invalid firstName
		assertFalse(userReg.validateFirstName("nik"));
		assertFalse(userReg.validateFirstName("Ni"));
		assertFalse(userReg.validateFirstName("Nikh@il"));
		// invalid lastName
		assertFalse(userReg.validateLastName("nikh"));
		assertFalse(userReg.validateLastName("Ni"));
		assertFalse(userReg.validateLastName("Nikh@il"));
		// invalid email
		assertFalse(userReg.validateEmail("abc@.com"));
		// invalid phoneNo
		assertFalse(userReg.validatePhoneNumber("9 0123456789"));
		// invalid password
		assertFalse(userReg.validatePassword("Xyz1@"));
		assertFalse(userReg.validatePassword("wxyz@123"));
		assertFalse(userReg.validatePassword("w#xyz@123"));
		assertFalse(userReg.validatePassword("aBcdefgh@"));
	}
}
