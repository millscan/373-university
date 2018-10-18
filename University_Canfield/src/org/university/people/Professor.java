package org.university.people;

import org.university.software.Course;
import org.university.hardware.Department;

import java.util.ArrayList;

public class Professor extends Employee {
	
		
	private Department department;

	public Professor() {
		schedule = new ArrayList<Course>();
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
	
	public boolean addCourse(Course newCourse) {
		if(detectConflict(newCourse)) {
			return false;
		}
		
		if(newCourse.getProfessor() != null) {
			System.out.printf("The professor cannot be assigned to this course because professor %s is already assigned to the course %s.%n",
					newCourse.getProfessor().getName(), newCourse.getName());
			return false;
		}
		
		schedule.add(newCourse);
		newCourse.setProfessor(this);
		return true;
	}
	
	public boolean removeCourse(Course oldCourse) {
		oldCourse.setProfessor(null);
		return schedule.remove(oldCourse);
	}
	
	public ArrayList<Course> getSchedule(){
		return schedule;
	}

}
