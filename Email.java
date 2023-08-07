package emailapp;

import java.util.Scanner;

public class Email {

	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailbxcapcity = 476;
	private int defualtpasswordLength = 10;
	private String alternatemail;
	private String companySuffix = "rockwellautomation.com";
	
//	Constructor to receive the first & last name
	public Email(String firstname, String lastname) {
		
		this.firstname = firstname; // this keyword can be used to refer current class variable/method(implicitly)/constructor and someother use
		this.lastname = lastname;
//		System.out.println("EMAIL CREATED: " + this.firstname + " " + this.lastname);
		
//		Call a method asking for the departmnt - return the department
		this.department = setDepartment();
//		System.out.println("Department: " + this.department);
		
//		Call a method that returns a random password
		this.password = randomPassword(defualtpasswordLength);
		System.out.println("Your Password is: " + this.password);
		
//		Combine elements to generate email
		email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase()  + "." + companySuffix;
//		System.out.println("Your Email is: " + email);
		
	} 
	
//	Ask for a department
	private String setDepartment() {
		System.out.println("New worker: " + firstname +".\n\nDepartment Codes:\n1 for Sales \n2 for Development \n3 for Accounting \n0 for None \n\nEnter the Department code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1) { return "Sales"; }
		else if (deptChoice == 2) { return "Dev";}
		else if (deptChoice == 3) { return "Acc";}
		else { return ""; }
			

	}
	
//	Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		
//		Math.random() > This method can generate random password at the length of 10 using the above passwordSet 
		
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		return new String (password);
		
	}
	
//	Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailbxcapcity = capacity;
		
	}
	
//	Set the alternate mail
	public void setAlternateEmail(String altMail) {
		this.alternatemail = altMail;
		
	}
//	Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailbxcapcity; }
	public String getAlternateMail() { return alternatemail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return  "DISPLAY NAME: " + firstname +" "+lastname +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: "+ mailbxcapcity + "GB";
	}


}
