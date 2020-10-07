package com.bridgelabs.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
	// constants
	private static final String PATTERN_NAME = "[A-Z][a-zA-z]{2,}";
	private static final String PATTERN_EMAIL = "[\\w+_-]+(?:\\.[\\w+_-]+)*@(?:[\\w]+\\.){1,2}[a-zA-Z]{2,}";
	private static final String PATTERN_PHONE = "[0-9]{2}[\\s][0-9]{10}";
	private static final String PATTERN_PASSWORD = "(?=\\S{8,})(?=.*[0-9])(?=.*[A-Z])[\\w]*[^\\w\\s][\\w]*";
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// welcome statement
		System.out.println("Welcome to User Registration Portal!\n");

		// validating first name
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		IValidate firstNameValidation = (fName) -> validateFirstName(fName);
		firstNameValidation.validateUserDetails(firstName);

		// validating last name
		System.out.println("Enter Last Name: ");
		String LastName = sc.nextLine();
		IValidate lastNameValidation = (lName) -> validateLastName(lName);
		lastNameValidation.validateUserDetails(LastName);

		// validating email
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		IValidate emailValidation = (mail) -> validateEmail(mail);
		emailValidation.validateUserDetails(email);

		// validating phone number
		System.out.println("Enter Phone Number: ");
		String phoneNo = sc.nextLine();
		IValidate phoneValidation = (phone) -> validatePhoneNumber(phone);
		phoneValidation.validateUserDetails(phoneNo);

		/*
		 * validating password minimum 8 characters 
		 * minimum 1 upperCase letter 
		 * minimum 1 numeric digit 
		 * exactly one special character
		 */
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		IValidate passwordValidation = (passwrd) -> validatePassword(passwrd);
		passwordValidation.validateUserDetails(password);
	}

	public static boolean validateFirstName(String firstName) {
		String message = "Invalid first name! First name should have atleast three letters and first letter should be capital!";
		try {
			validate(firstName, PATTERN_NAME, message);
			System.out.println("Valid first name!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean validateLastName(String LastName) {
		String message = "Invalid last name! Last name should have atleast three letters and first letter should be capital!";
		try {
			validate(LastName, PATTERN_NAME, message);
			System.out.println("Valid last name!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean validateEmail(String email) {
		String message = "Invalid email!";
		try {
			validate(email, PATTERN_EMAIL, message);
			System.out.println("Valid email!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean validatePhoneNumber(String phoneNo) {
		String message = "Invalid phone number! Must contain country code followed by space and 10 digit number";
		try {
			validate(phoneNo, PATTERN_PHONE, message);
			System.out.println("Valid phone number!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean validatePassword(String password) {
		String message = "Invalid password! Must contain atleast 8 characters(no whitespaces allowed),one upperCase,one numericDigit,only one special character(excluding underscore)";
		try {
			validate(password, PATTERN_PASSWORD, message);
			System.out.println("Valid password!");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void validate(String text, String pattern, String message) throws ValidationException {
		Pattern patternObj = Pattern.compile(pattern);
		Matcher matcherObj = patternObj.matcher(text);
		if (matcherObj.matches() == false)
			throw new ValidationException(message);
	}
}
