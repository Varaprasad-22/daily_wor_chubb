package system;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        College clg=new College();

        while (true) {
            System.out.println("\n STUDENT GRADE TRACKER ");
            System.out.println("1.Add Student");
            System.out.println("2.Add Grade");
            System.out.println("3.View Grades");
            System.out.println("4.Calculate Average");
            System.out.println("5.View All Students");
            System.out.println("6.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 : {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        clg.addStrudent(new Student(id, name));
                        break;}
                    case 2 : {
                    	
                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();sc.nextLine(); 
						Student s = clg.findStudent(id);
                        System.out.print("There are 3 Sujects Enter in order");
                        String sub[]= {"Math","Phy","Chem"};
                        System.out.print("Enter Grade (0–100): ");
                        for(int i=0;i<3;i++) {
//                        String subject = sc.nextLine();
                        System.out.print("Enter Grade for  "+sub[i]);
                        int grade = sc.nextInt();
                        s.addGrades(sub[i], grade);}
                        break;}
                    case 3 : {
                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();sc.nextLine();
                        Student s = clg.findStudent(id);
                        s.showGrades();
                        break;}
                    case 4 : {
                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();
                        Student s = clg.findStudent(id);
                        double avg = s.calculateAverage();
                        System.out.println("Average Grade: " + avg);
                        break;}
                    case 5 : clg.showAllStudents();break;
                    case 6 : 
                        System.out.println("Exiting...");
                        return;
                    
                    default: System.out.println("Invalid choice!");
                }
            } catch (InvalidMarks| NoGradesException | StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}