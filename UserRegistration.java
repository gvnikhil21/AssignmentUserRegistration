package com.bridgelabs.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration { 
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// welcome statement
		System.out.println("Welcome to User Registration Portal!\n");

		UserRegistration userReg = new UserRegistration();

		// validating first name
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		userReg.validateFirstName(firstName);

		// validating last name
		System.out.println("Enter First Name: ");
		String LastName = sc.nextLine();
		userReg.validateLastName(LastName);

		// validating email
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		userReg.validateEmail(email);

		// validating phone number
		System.out.println("Enter Phone Number: ");
		String phoneNo = sc.nextLine();
		userReg.validatePhoneNumber(phoneNo);

		/*
		 * validating password 
		 * minimum 8 characters 
		 * minimum 1 upperCase letter 
		 * minimum 1 numeric digit
		 * exactly one special character
		 */
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		userReg.validatePassword(password);
	}

	public boolean validateFirstName(String firstName) {
		String patternFirstName = "[A-Z][a-zA-z]{2,}";
		String message = "Invalid first name! First name should have atleast three letters and first letter should be capital!";
		try {
			validate(firstName, patternFirstName, message);
			System.out.println("Valid first name!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean validateLastName(String LastName) {
		String patternLastName = "[A-Z][a-zA-z]{2,}";
		String message = "Invalid last name! Last name should have atleast three letters and first letter should be capital!";
		try {
			validate(LastName, patternLastName, message);
			System.out.println("Valid last name!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean validateEmail(String email) {
		String patternEmail = "[\\w+_-]+(?:\\.[\\w+_-]+)*@(?:[\\w]+\\.)+[a-zA-Z]{2,}";
		String message = "Invalid email!";
		try {
			validate(email, patternEmail, message);
			System.out.println("Valid email!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean validatePhoneNumber(String phoneNo) {
		String patternPhoneNo = "[0-9]{2}[\\s][0-9]{10}";
		String message = "Invalid phone number! Must contain country code followed by space and 10 digit number";
		try {
			validate(phoneNo, patternPhoneNo, message);
			System.out.println("Valid phone number!\n");
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean validatePassword(String password) {
		String patternPassword = "(?=\\S{8,})(?=.*[0-9])(?=.*[A-Z])[\\w\\s]*[^\\w\\s][\\w\\s]*";
		String message = "Invalid password! Must contain atleast 8 characters(no whitespaces allowed),one upperCase,one numericDigit,only one special character(excluding underscore)";
		try {
			validate(password, patternPassword, message);
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
