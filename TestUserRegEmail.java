package com.bridgelabs.userregistration.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.bridgelabs.userregistration.UserRegistration;

@RunWith(Parameterized.class)
public class TestUserRegEmail {
	private String email;
	private boolean result;
	private static UserRegistration userReg;

	public TestUserRegEmail(String email, boolean result) {
		this.email = email;
		this.result = result;
	}

	@BeforeClass
	public static void initialize() {
		userReg = new UserRegistration();
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
				// valid email return true
				{ "abc@yahoo.com", true }, { "abc-100@yahoo.com", true }, { "abc.100@yahoo.com", true },
				{ "abc111@abc.com", true }, { "abc-100@abc.net", true }, { "abc.100@abc.com.au", true },
				{ "abc@1.com", true }, { "abc@gmail.com.com", true }, { "abc+100@gmail.com", true },
				// invalid email return false
				{ "abc", false }, { "abc@.com.my", false }, { "abc123@gmail.a", false }, { "abc123@.com", false },
				{ "abc123@.com.com", false }, { ".abc@abc.com", false }, { "abc()*@gmail.com", false },
				{ "abc@%*.com", false }, { "abc..2002@gmail.com", false }, { "abc.@gmail.com", false },
				{ "abc@abc@gmail.com", false }, { "abc@gmail.com.1a", false }, { "abc@gmail.com.aa.au", false }, });
	}

	@Test
	public void testValidateEmail() {
		assertEquals(result, userReg.validateEmail(email));
	}
}
