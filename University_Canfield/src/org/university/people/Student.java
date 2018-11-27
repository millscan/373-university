package org.university.people;

import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.*;

public class Student extends Person {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};

	public Student() {
		this.schedule = new ArrayList<Course>(); 	
	}

	private Department department;
	private int unitsCompleted;
	private int unitsRequired;

	public void setDepartment(Department d) {
		this.department = d;
		if(!d.getStudentList().contains(this)){
			d.addStudent(this);
		}
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	public String addCourse(Course c) {
		if(detectConflict(c) != null) {
			return String.format("%s%s course cannot be added to %s's schedule. %s%s conflicts with %s%s",
					c.getDepartment().getDepartmentName(), c.getCourseNumber(), this.name, detectConflict(c).getDepartment().getDepartmentName(), detectConflict(c).getCourseNumber(),
					c.getDepartment().getDepartmentName(), c.getCourseNumber());
		}
				
		if(!c.availableTo(this)) {
			System.out.printf("%s can't add course %s%s%s because this course has enough students.%n", 
					this.name, c.getDepartment().getDepartmentName(), c.getCourseNumber(), c.getName());
			return String.format("%s can't add course %s%s%s because this course has enough students.%n", 
					this.name, c.getDepartment().getDepartmentName(), c.getCourseNumber(), c.getName());
		}
		
		this.schedule.add(c);
		if(!c.getStudentRoster().contains(this)) {
			c.addStudentToRoster(this);
		}
		return String.format("Student %s has been enrolled in %s%s", name, c.getDepartment().getDepartmentName(), c.getName());
	}
	
	
	public boolean dropCourse(Course c) {
		
		if(!schedule.contains(c)) {	
			System.out.printf("The course %s%s could not be dropped because %s is not enrolled in %s%s.%n",
					c.getDepartment().getDepartmentName(), c.getCourseNumber(),
					this.name, c.getDepartment().getDepartmentName(), c.getCourseNumber());
			return false;
		}
		
		this.schedule.remove(c);
		if(c.getStudentRoster().contains(this)) {
			c.removeStudent(this);
		}
		
		return true;
	}
	
	
	public ArrayList<Course> getCourses(){
		return schedule;
	}

	
	public void setCompletedUnits(int newUnits) {
		unitsCompleted = newUnits;
	}
	
	public int getCompletedUnits() {
		return unitsCompleted;
	}
	
	public void setRequiredCredits(int newUnits){
		unitsRequired = newUnits;
	}
	
	public int getRequiredCredits() {
		return unitsRequired;
	}
	
	public int getUnitsEnrolled() {
		int temp = 0;
		for(Course c : this.schedule) {
			temp += c.getCreditUnits();
		}
		
		return temp;
	}
	
	public int getTuitionFee() {
		int campusFee = 0;
		for(Course c : this.schedule) {
			campusFee += c.getCreditUnits() * 300;
		}
		
		return campusFee;
	}
	
	public int requiredToGraduate() {
		return unitsRequired - unitsCompleted - this.getUnitsEnrolled();
	}

}
