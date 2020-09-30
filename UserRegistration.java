package com.bridgelabs.userregistration;

import java.util.*;
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
	}

	public void validateFirstName(String firstName) {
		String patternFirstName = "[A-Z][a-zA-z]{2,}";
		String message = "Invalid first name! First letter should be capital and first name should have atleast three letters!";
		try {
			validate(firstName, patternFirstName, message);
			System.out.println("Valid first name!");
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}

	public static void validate(String text, String pattern, String message) throws ValidationException {
		Pattern patternObj = Pattern.compile(pattern);
		Matcher matcherObj = patternObj.matcher(text);
		if (matcherObj.matches() == false)
			throw new ValidationException(message);
	}
}
