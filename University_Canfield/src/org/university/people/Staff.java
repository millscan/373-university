package org.university.people;

import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.*;

public class Staff extends Employee {
	
	private Department department;
	private double payRate;
	private int hoursWorked;
	private int tuitionFee;
	
	public Staff() {
		this.schedule = new ArrayList<Course>(); 	
	}
	
	public int getTuitionFee() {
		
		int campusFee = 0;
		int onlineFee = 0;
		for(Course c : this.schedule) {
			campusFee += c.getCreditUnits() * 300;
		}
		
		return campusFee + onlineFee;
	}
	
	public void raise(double raisePercent) {
		
		payRate = (payRate * (1 + raisePercent/100.00));
	}
	
	public double earns() {
		
		return payRate * hoursWorked;
	}
	
	public void setPayRate(double newPayRate) {
		this.payRate = newPayRate;
	}
	
	public double getPayRate() {
		return this.payRate;
	}
	
	public void setMonthlyHours(int hours) {
		this.hoursWorked = hours;
	}
	
	public int getHoursWorked() {
		return this.hoursWorked;
	}
	
	public String addCourse(Course course) {
		replaceCourseWithWarning(course);
		schedule.add(course);
		course.addStudentToRoster(this);
		return "Successfully added staff to course";
	}
	
	private void replaceCourseWithWarning(Course newCourse) {
		if(this.schedule.size() > 0) {
			System.out.printf("%s%s is removed from %s's schedule(Staff can only take one class at a time). %s%s has been added to %s's Schedule.%n", 
					this.schedule.get(0).getDepartment().getDepartmentName(), this.schedule.get(0).getCourseNumber(), this.name, 
					newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(), this.name);
		}
		
		schedule.clear();
	}
}
