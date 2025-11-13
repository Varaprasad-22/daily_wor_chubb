package system;

import java.util.ArrayList;
import java.util.List;

public class College {
		private List<Student> student;
		public College() {
			student=new ArrayList<>();
		}
		public void addStrudent(Student s) {
			for(Student i:student) {
				if(s.getId()==i.getId()) {
					System.out.print("Student already exist");
					return ;
				}
			}
			student.add(s);
			System.out.println("Added Successfully");
		}
		public Student findStudent(int id) throws StudentNotFoundException{
			for(Student i:student) {
				if(i.getId()==id) {
					System.out.println("Studnet Found");
					return i;
				}
			}
			throw new StudentNotFoundException("Inavlid Student");
		}
		  public void showAllStudents() {
		        if (student.isEmpty()) {
		            System.out.println("No students registered yet.");
		            return;
		        }
		        System.out.println("Registered Students:");
		        student.forEach(s -> System.out.println(s.getId() + " - " + s.getName()));
		    }
}
