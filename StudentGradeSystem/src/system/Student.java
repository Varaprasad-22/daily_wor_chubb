package system;
import java.io.IOException;
import java.nio.InvalidMarkException;
import java.util.*;
public class Student extends Person {
	private Map<String,Integer> marks=new HashMap<>();
	public Student(int id, String name) {
        super(id, name);
    }
	
	public  void addGrades(String subject,int grade) throws InvalidMarks {
		if(grade<0||grade>100)
			throw new  InvalidMarks("Not a valid Option Marks");
		
		marks.put(subject,grade);
		
			System.out.println("Added Sucessfully");
		
	}
	
	public double calculateAverage() throws NoGradesException{
		if (marks.isEmpty()) {
            throw new NoGradesException("No grades found for " );
        }
		long avg = 0;
		for(Map.Entry<String,Integer> i:marks.entrySet()) {
			avg+=i.getValue();
		}
		return (double) (avg/marks.size());
	}
	 public void showGrades() {
	        if (marks.isEmpty()) {
	            System.out.println("No grades recorded for " );
	            return;
	        }
	        System.out.println("Grades for ");
	        marks.forEach((subject, score) ->
	            System.out.println(" - " + subject + ": " + score)
	        );
	    }
}
