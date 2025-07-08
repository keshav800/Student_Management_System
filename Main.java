import java.util.ArrayList;
import java.util.Scanner;

abstract class person {
    protected String name;
    protected int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void displayDetails();
}

class Student extends person {
    private int rollno;
    private String course;
    private double marks;
    static int studentcount = 0;

    public Student(String name, int age, int rollno, String course, double marks) {
        super(name, age);
        this.rollno = rollno;
        this.course = course;
        this.marks = marks;
        studentcount++;
    }

    public int getrollno() {
        return rollno;
    }

    public String getcourse() {
        return course;
    }

    public double getmarks() {
        return marks;
    }

    void displayDetails() {
        System.out.println("Student: " + name + ", Age: " + age);
        System.out.println("Roll No: " + rollno + ", Course: " + course + ", Marks: " + marks);
    }
}

class teacher extends person {
    private String Subject;

    public teacher(String name, int age, String Subject) {
        super(name, age);
        this.Subject = Subject;
    }

    void displayDetails() {
        System.out.println("Teacher: " + name + ", Age: " + age + ", Subject: " + Subject);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<teacher> teachers = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Teacher");
            System.out.println("4. View All Teachers");
            System.out.println("5. Show Total Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine()); // safer

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String sname = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter roll no: ");
                    int roll = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter marks: ");
                    double marks = Double.parseDouble(sc.nextLine());

                    students.add(new Student(sname, age, roll, course, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println(" No student record found.");
                    } else {
                        for (Student s : students) {
                            s.displayDetails();
                            System.out.println("-----------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter teacher name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int tage = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter subject: ");
                    String subject = sc.nextLine();
                    teachers.add(new teacher(name, tage, subject));
                    System.out.println("Teacher added successfully!");
                    break;

                case 4:
                    if (teachers.isEmpty()) {
                        System.out.println(" No teacher record found.");
                    } else {
                        for (teacher t : teachers) {
                            t.displayDetails();
                            System.out.println("-----------");
                        }
                    }
                    break;

                case 5:
                    System.out.println(" Total Students: " + Student.studentcount);
                    break;

                case 6:
                    System.out.println(" Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
