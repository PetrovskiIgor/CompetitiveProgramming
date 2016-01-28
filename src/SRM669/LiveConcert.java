package SRM669;



import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Student implements Comparable<Student>{
	
	String firstName;
	String lastName;
	
	double GPA;
	
	
	public Student(String firstName, String lastName, double GPA) { 
		this.firstName = firstName;
		this.lastName = lastName;
		this.GPA = GPA;
		
		
		
	}
	
	
	
	@Override
	public int compareTo(Student other) { 
		
		
		if(Math.abs(other.GPA - this.GPA) < 0.00000001) {
			return 0;
		}
		
		if (this.GPA < other.GPA ) {
			return 1;
		}
		
		return (-1);
	}
	
	
}

public class LiveConcert {
	
	
	
	public static void printStudentsList(List<Student> students) {
		 
		for(int i=0; i<students.size(); i++) { 
			System.out.println(students.get(i).firstName + " " + students.get(i).lastName + " " + students.get(i).GPA);
		}
	}
	
	public static void printStudentsArray(Student [] students) { 
		
		for(int i=0; i<students.length; i++) { 
			System.out.println(students[i].firstName + " " + students[i].lastName + " " + students[i].GPA);
		}
	}
	
	public static void main(String [] args) { 
		
		
		Student student1 = new Student("Igor", "Petrovski", 10.00);
		Student student2 = new Student("Pavle", "Dimovski", 6.543);
		Student student3 = new Student("Gospod", "Bogovski", 8.362);
		Student student4 = new Student("Georgina", "Mirchevska", 9.67);
		Student student5 = new Student("Vace", "Arsovski", 9.9);
				
		Student [] students = new Student[5];
		
		
		List<Student> sts = new ArrayList<Student>();
		
		
		
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;
		
		printStudentsArray(students);
		System.out.println("-----------------");
		Arrays.sort(students);
		
		printStudentsArray(students);
		
		
		
		
		
	}

}
