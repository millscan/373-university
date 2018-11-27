package org.university.software;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.university.hardware.*;
import org.university.people.Professor;
import org.university.people.Staff;
import org.university.people.Student;

public class University implements Serializable {

	public ArrayList<Department> departmentList;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		this.departmentList = new ArrayList<Department>();
		this.classroomList = new ArrayList<Classroom>();
	}
	
	public Department getDepartmentWithName(String name) {
		for(Department d: departmentList) {
			if(d.getDepartmentName().trim().equals(name.trim())) {
				return d;
			}
		}
		return null;
	}
	
	public Student getStudentWithName(String name){
		Student student = null;
		for(Department d: departmentList) {
			student = d.getStudentFromName(name);
			if(student != null) {
				return student;
			}
		}
		return student;
	}
	
	public String getClassroomListString() {
		StringBuilder s = new StringBuilder();
		for(Classroom c: classroomList) {
			s.append(c.getRoomNumber()+"\n");
		}
		return s.toString();
	}
	
	public void printClassroomList() {
		System.out.print(getClassroomListString());
	}
	
	public String getDepartmentListString() {
		StringBuilder s = new StringBuilder();
		for(Department d : departmentList) {
			s.append(d.getDepartmentName() + "\n");
		}
		return s.toString();
	}
	
	
	public void printDepartmentList() {
		System.out.println(getDepartmentListString());
	}
	
	public String getProfessorListString() {
		StringBuilder s = new StringBuilder();
		for(Department d: departmentList) {
			s.append(d.getProfessorListString());
		}
		return s.toString();
	}
	
	public void printProfessorList() {
		System.out.println(getProfessorListString());
	}
	
	public String getStaffListString() {
		StringBuilder s = new StringBuilder();
		for(Department d: departmentList) {
			s.append(d.getStaffListString());
		}
		return s.toString();
	}
	
	public void printStaffList() {
		System.out.println(getStaffListString());
	}
	
	public String getStudentListString() {
		StringBuilder str = new StringBuilder();
		
		for(Department d: departmentList) {
			for(Student s: d.getStudentList()) {
				str.append(s.getName() + "\n");
			}
		}
		return str.toString();
	}
	
	public void printStudentList() {
		System.out.println(getStudentListString());
	}
	
	public void printCourseList() {
		for(Department d: departmentList) {
			d.printCourseList();
		}
		
	}
	
	public void printAll() {
		System.out.print(this.stringify());
	}
	
	public String stringify() {
		StringBuilder stringified = new StringBuilder("\n");
		stringified.append("List of departments:\n");
		stringified.append(getDepartmentListString());
		stringified.append("\n");
		
		stringified.append("Classroom list:\n");
		stringified.append(getClassroomListString());
		stringified.append("\n");
		
		for(Department d: departmentList) {
			stringified.append("The professor list for department " + d.getDepartmentName() + ":\n");
			stringified.append(d.getProfessorListString());
			stringified.append("\n");
		}

		for(Department d: departmentList) {
			stringified.append("The course list for department " + d.getDepartmentName() + ":\n");
			stringified.append(d.getCourseListString());
			stringified.append("\n");
		}
		
		for(Classroom c: classroomList) {
			stringified.append("The schedule for classroom " + c.getRoomNumber() + ":\n");
			stringified.append(c.getScheduleString());
			stringified.append("\n");
		}
		
		for(Department d: departmentList) {
			
			stringified.append(String.format("Department " + d.getDepartmentName() + "\n\n"));
			
			stringified.append(String.format("Printing Professor Schedules:\n\n"));
			for(Professor p: d.getProfessorList()) {
				stringified.append(String.format("The schedule for Prof. " + p.getName() + ":\n"));
				stringified.append(p.getScheduleString());
				stringified.append("\n");
			}
			
			stringified.append(String.format("Printing student schedules:\n\n"));
			for(Student s: d.getStudentList()) {
				stringified.append(String.format("The schedule for Student " + s.getName() + ":\n"));
				stringified.append(s.getScheduleString());
				stringified.append("\n");
			}
			
			stringified.append(String.format("Printing Staff schedules:\n\n"));
			for(Staff staff: d.getStaffList()) {
				stringified.append(String.format("The schedule for Employee  " + staff.getName() + ":\n"));
				stringified.append(staff.getScheduleString());
				stringified.append("\n\n");
				stringified.append(String.format("Staff: %s earns %s this month\n\n", staff.getName(), staff.earns()));
			}
			
			stringified.append(String.format("The rosters for courses offered by " + d.getDepartmentName() + ":\n\n"));
			for(Course course: d.getCourseList()) {
				stringified.append("The roster for course  " + d.getDepartmentName() + course.getCourseNumber() + "\n");
				stringified.append(course.getRosterString());
				stringified.append("\n");
			}
		}
		
		return stringified.toString();
	}
	
	public static void saveData(University u) {
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream("UniversityData"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(u); 
              
            out.close(); 
            file.close(); 
        }  
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
	}
	
	public static University loadData() {
		University university = null;
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream("UniversityData"); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            university = (University)in.readObject(); 
              
            in.close(); 
            file.close(); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		return university;
	}
}
