package studentDatabaseApp;

import java.util.Scanner;

public class Student {

	private String  firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = ""; 
	private int tuitionBalance = 0;
	private static int costOfCourse = 600; 
	private static int id = 1000;
	// Constructor prompts user to enter student's name and year
	
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - freshman \n2 - sophmore \n3 - junior\n4 - senior\nEnter student class level: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();

		
	}
	
	// Generate an ID 
	
	private void setStudentID() {
		//Grade level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	// Enroll in courses 
	
	public void enroll() {
		// Get inside a loop, user hits 0 when they're done enrolling 
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in); 
			String course = in.nextLine();
			
			if(!course.equals("Q")) {
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse; 
			} else {
				break;
				}
		} while (1 != 0);

	}
	
	// View balance 
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay tuition 
	public void payTution() {
		viewBalance();
		System.out.print("Enter your payment amount: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
	}
	
	// Show student status
	public void showInfo() {
		String universityGradeLevel = "unknown";
		
		if(gradeYear == 1) {
			universityGradeLevel = "Freshman";
		} else if (gradeYear == 2) {
			universityGradeLevel = "Sophmore";
		} else if (gradeYear == 3) {
			universityGradeLevel = "Junior";
		} else if (gradeYear == 4) {
			universityGradeLevel = "Senior";
		}
			
		
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println(firstName + " is a " + universityGradeLevel);
		System.out.println("Student ID: " + studentID);
		System.out.println("Course Enrolled: " + courses);
		viewBalance(); 
	
	}
}
