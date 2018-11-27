package org.university.hardware;

import java.io.Serializable;
import java.util.ArrayList;

import org.university.people.*;
import org.university.software.*;


public class Department implements Serializable {

	private String name;
	private ArrayList<Course> courses;
	private ArrayList<Professor> professors;
	private ArrayList<Staff> staffList;
	private ArrayList<Student> students;
	
	public Department() {
		this.courses = new ArrayList<Course>();
		this.professors = new ArrayList<Professor>();
		this.staffList = new ArrayList<Staff>();
		this.students = new ArrayList<Student>();
	}
	
	public Student getStudentFromName(String name) {
		for(Student s : students) {
			if(s.getName().trim().equals(name.trim())) {
				return s;
			}
		}
		return null;
	}
	
	public Course getCourseFromName(String name) {
		for(Course c: courses) {
			if (c.getCourseNumber() == Integer.parseInt(name)) {
				return c;
			}
		}
		return null;
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
	
	public void addStaff(Staff s) {
		staffList.add(s);
	}
	
	public void removeStaff(Staff s) {
		staffList.remove(s);
	}
	
	public ArrayList<Staff> getStaffList() {
		return staffList;
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

	public String getStudentListString(){
		StringBuilder studentListString = new StringBuilder();
		for(Student s: students) {
			studentListString.append(s.getName()+"\n");
		}
		return studentListString.toString();
	}

	public void printStudentList() {
		System.out.print(getStudentListString());
	}
	
	public String getProfessorListString() {
		StringBuilder professorListString = new StringBuilder();
		for(Professor p: professors) {
			professorListString.append(p.getName()+ "\n");
		}
		return professorListString.toString();
	}
	
	public void printProfessorList() {
		System.out.print(getProfessorListString());
	}
	
	public String getStaffListString() {
		StringBuilder staffListString = new StringBuilder();
		for(Staff s: staffList) {
			staffListString.append(s.getName() + "\n");
		}
		
		return staffListString.toString();
	}
	
	public void printStaffList() {
		System.out.print(getStaffListString());
	}
	
	public String getCourseListString() {
		StringBuilder courseListString = new StringBuilder();
		for(Course c : courses) {
			courseListString.append(String.format("%s%s%n", c.getDepartment().getDepartmentName(), c.getCourseNumber()));
		}
		return courseListString.toString();
	}
	
	public void printCourseList() {
		System.out.print(getCourseListString());
		System.out.println();
	}
	
}
