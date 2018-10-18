package org.university.hardware;

import java.util.ArrayList;

import org.university.people.*;
import org.university.software.Course;


public class Department {

	private String name;
	private ArrayList<Course> courses;
	private ArrayList<Professor> professors;
	private ArrayList<Student> students;
	
	public Department() {
		this.courses = new ArrayList<Course>();
		this.professors = new ArrayList<Professor>();
		this.students = new ArrayList<Student>();
	}

	public void setDepartmentName(String n) {
		this.name = n;
	}
	
	public String getDepartmentName() {
		return this.name;
	}
	
	public void addStudent(Student s) {
		students.add(s);
		if(s.getDepartment() != this) {
			s.setDepartment(this);
		}
	}
	
	public void removeStudent(Student s) {
		students.remove(s);
		if(s.getDepartment() == this) {
			s.setDepartment(null);
		}
	}

	public ArrayList<Student> getStudentList(){
		return students;
	}
	
	public void addProfessor(Professor p) {
		professors.add(p);
		if(p.getDepartment() != this) {
			p.setDepartment(this);
		}
	}
	
	public boolean removeProfessor(Professor p) {
		if(p.getDepartment() == this) {
			p.setDepartment(null);
		}
		
		return professors.remove(p);
	}
	
	public ArrayList<Professor> getProfessorList(){
		return professors;
	}
	
	public void addCourse(Course c) {
		courses.add(c);
		if(c.getDepartment() != this) {
			c.setDepartment(this);
		}
	}
	
	public void removeCourse(Course c) {
		courses.remove(c);
		if(c.getDepartment() == this) {
			c.setDepartment(null);
		}
	}
	
	public ArrayList<Course> getCourseList(){
		return courses;
	}
	
	public void printStudentList() {
		for(Student s: students) {
			System.out.println(s.getName());
		}
	}
	
	public void printProfessorList() {
		for(Professor p: professors) {
			System.out.println(p.getName());
		}
	}
	
	public void printCourseList() {
		for(Course c: courses) {
			System.out.println(this.getDepartmentName() + c.getCourseNumber());
		}
	}
}
