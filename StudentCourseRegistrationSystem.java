import java.util.Scanner;

class Student {
    // Data members
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor to initialize details
    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to calculate the total course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return this.marks >= 50.0;
    }

    // Method to calculate scholarship percentage based on marks
    public double calculateScholarship(double totalFee) {
        if (this.marks >= 85.0) {
            return totalFee * 0.20; // 20% scholarship
        } else if (this.marks >= 70.0 && this.marks <= 84.0) {
            return totalFee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after scholarship deduction
    public double calculateFinalFee() {
        double totalFee = calculateFee();
        double scholarship = calculateScholarship(totalFee);
        return totalFee - scholarship;
    }

    // Method to display all details
    public void displayDetails() {
        double totalFee = calculateFee();
        double scholarship = calculateScholarship(totalFee);
        double finalFee = calculateFinalFee();

        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name   : " + this.studentName);
        System.out.println("Roll Number    : " + this.rollNumber);
        System.out.println("Marks Obtained : " + this.marks);
        System.out.println("Course Name    : " + this.courseName);
        System.out.println("Course Credits : " + this.courseCredits);
        System.out.println("Eligibility    : Eligible");
        System.out.println("Total Fee      : Rs. " + totalFee);
        System.out.println("Scholarship    : Rs. " + scholarship);
        System.out.println("Final Fee      : Rs. " + finalFee);
    }
}

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading student and course details from user input
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

        // Creating Student object using parameterized constructor
        Student student = new Student(name, roll, marks, course, credits);

        // Checking eligibility using separate method (not direct calculation in main)
        processRegistration(student);

        scanner.close();
    }

    // Separate method to handle logic flow and avoid direct calculation in main
    public static void processRegistration(Student student) {
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent is not eligible for course registration (Marks are below 50).");
        }
    }
}
