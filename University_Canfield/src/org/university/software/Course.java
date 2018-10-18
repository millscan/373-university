package org.university.software;

import java.util.ArrayList;

import org.university.hardware.*;
import org.university.people.*;

public abstract class Course {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	private String name;
	private int number;
	private Department department;
	private Professor professor;
	protected ArrayList<Student> roster;
	private int credits;
	
	public Course() {
		this.roster = new ArrayList<Student>();
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCourseNumber(int n) {
		this.number = n;
	}
	
	public int getCourseNumber() {
		return this.number;
	}
	
	public void setDepartment(Department d) {
		this.department = d;
	}
	
	public Department getDepartment() {
		return this.department;
	}

	
	public void setProfessor(Professor p) {
		professor = p;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	
	public void addStudentToRoster(Student s) {
		this.roster.add(s);
	}

	public void removeStudent(Student s) {
		this.roster.remove(s);
	}
	
	public ArrayList<Student> getStudentRoster(){
		return roster;
	}
	
	public void setCreditUnits(int cu) {
		this.credits = cu;
	}
	
	public int getCreditUnits() {
		return credits;
	}

	
}
