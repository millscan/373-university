package org.university.hardware;

import java.util.ArrayList;

import org.university.people.*;
import org.university.software.*;


public class Department {

	private String name;
	private ArrayList<CampusCourse> campusCourses;
	private ArrayList<OnlineCourse> onlineCourses;
	private ArrayList<Professor> professors;
	private ArrayList<Staff> staffList;
	private ArrayList<Student> students;
	
	public Department() {
		this.campusCourses = new ArrayList<CampusCourse>();
		this.onlineCourses = new ArrayList<OnlineCourse>();
		this.professors = new ArrayList<Professor>();
		this.staffList = new ArrayList<Staff>();
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
	
	public void addCampusCourse(CampusCourse c) {
		campusCourses.add(c);
		if(c.getDepartment() != this) {
			c.setDepartment(this);
		}
	}
	
	
	public void removeCampusCourse(CampusCourse c) {
		campusCourses.remove(c);
		if(c.getDepartment() == this) {
			c.setDepartment(null);
		}
	}
	
	
	public ArrayList<CampusCourse> getCampusCourseList(){
		return campusCourses;
	}
	
	
	public void addOnlineCourse(OnlineCourse c) {
		onlineCourses.add(c);
		if(c.getDepartment() != this) {
			c.setDepartment(this);
		}
	}

	public ArrayList<OnlineCourse> getOnlineCourseList(){
		return onlineCourses;
	}
	
	public void removeOnlineCourse(OnlineCourse c) {
		onlineCourses.remove(c);
		if(c.getDepartment() == this) {
			c.setDepartment(null);
		}
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
	
	public void printStaffList() {
		for(Staff s: staffList) {
			System.out.println(s.getName());
		}
	}
	
	public void printCourseList() {
		for(CampusCourse c : campusCourses) {
			System.out.printf("%s%s %s%n", c.getDepartment().getDepartmentName(), c.getCourseNumber(), c.getName());
		}
		for(OnlineCourse c : onlineCourses) {
			System.out.printf("%s%s %s%n", c.getDepartment().getDepartmentName(), c.getCourseNumber(), c.getName());
		}
	}
	
}
