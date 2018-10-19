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
		this.onlineCourseList = new ArrayList<OnlineCourse>();
		this.campusCourseList = new ArrayList<CampusCourse>();
	}
	
	public int getTuitionFee() {
		
		int campusFee = 0;
		int onlineFee = 0;
		for(CampusCourse c : this.campusCourseList) {
			campusFee += c.getCreditUnits() * 300;
		}
		for(OnlineCourse o : this.onlineCourseList) {
			onlineFee += o.getCreditUnits() == 3 ? 2000 : 3000;
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
	
	public void addCampusCourse(CampusCourse cCourse) {
		replaceCourseWithWarning(cCourse);
		campusCourseList.add(cCourse);
	}
	
	public void addOnlineCourse(OnlineCourse oCourse) {
		replaceCourseWithWarning(oCourse);
		onlineCourseList.add(oCourse);
	}
	
	private void replaceCourseWithWarning(Course newCourse) {
		if(this.campusCourseList.size() > 0) {
			System.out.printf("%s%s is removed from %s's schedule(Staff can only take one class at a time). %s%s has been added to %s's Schedule.%n", 
					this.campusCourseList.get(0).getDepartment().getDepartmentName(), this.campusCourseList.get(0).getCourseNumber(), this.name, 
					newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(), this.name);
		}
		if(this.onlineCourseList.size() > 0) {
			System.out.printf("%s%s is removed from %s's schedule(Staff can only take one class at a time). %s%s has been added to %s's Schedule.%n", 
					this.onlineCourseList.get(0).getDepartment().getDepartmentName(), this.onlineCourseList.get(0).getCourseNumber(), this.name, 
					newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(), this.name);
		}
		
		campusCourseList.clear();
		onlineCourseList.clear();
	}
}
