package org.university.people;

import org.university.software.*;
import org.university.hardware.Department;

import java.util.ArrayList;

public class Professor extends Employee {
	
	private Department department;
	private double salary;

	public Professor() {
		this.schedule = new ArrayList<Course>(); 	
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDepartment(Department newDepartment) {
		department = newDepartment;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setSalary(double newSalary) {
		this.salary = newSalary;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public String addCourse(Course newCourse) {
		if(this.detectConflict(newCourse) == null) {
			return "DETECT CONFLICT";
		}
		
		if(newCourse.getProfessor() != null) {
			System.out.printf("The professor %s cannot be assigned to this course because professor %s is already assigned to the course %s.%n",
					this.name, newCourse.getProfessor().getName(), newCourse.getName());
			return "ALREADY ASSIGNED";
		}
		newCourse.setProfessor(this);
		schedule.add(newCourse);
		return null;
	}
	
	public void raise(double r) {
		this.salary = this.salary*(1.00 + r/100.00);
	}
	
	public double earns() {
		return salary/26.00;
	}
	
	public void removeCourse(Course oldCourse) {
		oldCourse.setProfessor(null);
		schedule.remove(oldCourse);
	}
	
	public ArrayList<Course> getSchedule(){
		return schedule;
	}

}
