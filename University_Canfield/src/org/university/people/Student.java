package org.university.people;

import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.*;

public class Student extends Person {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};

	public Student() {
		this.schedule = new ArrayList<Course>(); 	
		this.onlineCourseList = new ArrayList<OnlineCourse>();
		this.campusCourseList = new ArrayList<CampusCourse>();
	}

	private Department department;
	private int unitsCompleted;
	private int unitsRequired;
	private int unitsEnrolled;
	private int tuitionFee;

	public void setDepartment(Department d) {
		this.department = d;
		if(!d.getStudentList().contains(this)){
			d.addStudent(this);
		}
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	public void addCampusCourse(CampusCourse c) {
		if(detectConflict(c)) {
			return;
		}
				
		if(!c.availableTo(this)) {
			System.out.printf("%s can't add Campus Course %s%s%s because this campus course has enough students.%n", 
					this.name, c.getDepartment().getDepartmentName(), c.getCourseNumber(), c.getName());
			return;
		}
		
		this.schedule.add(c);
		this.campusCourseList.add(c);
		if(!c.getStudentRoster().contains(this)) {
			c.addStudentToRoster(this);
		}
	}
	
	
	public boolean dropCampusCourse(CampusCourse c) {
		
		if(!campusCourseList.contains(c)) {	
			System.out.printf("The course %s%s could not be dropped because %s is not enrolled in %s%s.%n",
					c.getDepartment().getDepartmentName(), c.getCourseNumber(),
					this.name, c.getDepartment().getDepartmentName(), c.getCourseNumber());
			return false;
		}
		
		if(this.getCampusUnitsEnrolled() - c.getCreditUnits() < 6 && this.onlineCourseList.size() > 0) {
			System.out.printf("%s can't drop this CampusCourse, because student doesn't has enough campus course credit to hold online course.%n", 
					this.name);
			return false;
		}
		
		this.schedule.remove(c);
		this.campusCourseList.remove(c);
		if(c.getStudentRoster().contains(this)) {
			c.removeStudent(this);
		}
		
		return true;
	}
	
	public void addOnlineCourse(OnlineCourse oCourse) {
		if(!oCourse.availableTo(this)) {
			System.out.printf("%s can't add online Course %s%s %s. Because this student don't have enough Campus course credit.%n",
					this.name, oCourse.getDepartment().getDepartmentName(), oCourse.getCourseNumber(), oCourse.getName());

			return;
		}
		
		this.onlineCourseList.add(oCourse);
		if(!oCourse.getStudentRoster().contains(this)) {
			oCourse.addStudentToRoster(this);
		}
	}
	
	public boolean dropOnlineCourse(OnlineCourse oCourse) {

		this.onlineCourseList.remove(oCourse);
		if(oCourse.getStudentRoster().contains(this)) {
			oCourse.removeStudent(this);
			return true;
		}
		else {
			System.out.printf("The course %s%s could not be dropped because %s is not enrolled in %s%s.%n",
					oCourse.getDepartment().getDepartmentName(), oCourse.getCourseNumber(),
					this.name, oCourse.getDepartment().getDepartmentName(), oCourse.getCourseNumber());
			return false;
		}
	}

	
	public ArrayList<Course> getCourses(){
		return schedule;
	}
	
	public ArrayList<CampusCourse> getCampusCourses(){
		return campusCourseList;
	}
	
	public ArrayList<OnlineCourse> getOnlineCourses(){
		return onlineCourseList;
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
	
	public int getCampusUnitsEnrolled() {
		int temp = 0;
		for(CampusCourse cc : this.campusCourseList) {
			temp += cc.getCreditUnits();
		}
		return temp;
	}
	
	public int getUnitsEnrolled() {
		int temp = 0;
		for(CampusCourse cc : this.campusCourseList) {
			temp += cc.getCreditUnits();
		}
		for(OnlineCourse oc: this.onlineCourseList) {
			temp+= oc.getCreditUnits();
		}
		
		return temp;
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
	
	public int requiredToGraduate() {
		return unitsRequired - unitsCompleted - this.getUnitsEnrolled();
	}

}
