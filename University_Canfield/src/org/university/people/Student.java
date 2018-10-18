package org.university.people;

import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.Course;

public class Student {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};

	public Student() {
		this.courses = new ArrayList<Course>();
	}
	
	private String name;
	private Department department;
	private ArrayList<Course> courses;
	private int unitsCompleted;
	private int unitsRequired;
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDepartment(Department d) {
		this.department = d;
		if(!d.getStudentList().contains(this)){
			d.addStudent(this);
		}
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	public boolean addCourse(Course c) {
		if(detectConflict(c)) {
			return false;
		}
		this.courses.add(c);
		if(!c.getStudentRoster().contains(this)) {
			c.addStudent(this);
		}
		return true;
	}
	
	public boolean dropCourse(Course c) {
		this.courses.remove(c);
		if(c.getStudentRoster().contains(this)) {
			c.removeStudent(this);
			return true;
		}
		else {
			System.out.printf("The course %s%s could not be dropped because %s is not enrolled in %s%s.%n",
					c.getDepartment().getDepartmentName(), c.getCourseNumber(),
					this.name, c.getDepartment().getDepartmentName(), c.getCourseNumber());
			return false;
		}
	}
	
	public ArrayList<Course> getCourses(){
		return courses;
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
	
	public int requiredToGraduate() {
		return unitsRequired - unitsCompleted;
	}
	
	public boolean detectConflict(Course newCourse) {
		boolean flag = false;
		for(Course course : courses) {
			for(int newSlot : newCourse.getSchedule()) {
				if(course.getSchedule().contains(newSlot)) {
					System.out.printf("%s%s course cannot be added to %s's schedule. %s%s conflicts with %s%s. Conflicting time slot is %s %s%n",
							newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(),
							this.name, newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(),
							course.getDepartment().getDepartmentName(), course.getCourseNumber(),
							Week[newSlot/100 - 1], Slot[newSlot%100 - 1]
							);
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public void printSchedule() {
		int dayIndex;
		int slotIndex;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				for(Course course : courses) {
					for(int slot : course.getSchedule()) {
						dayIndex = slot / 100 - 1;
						slotIndex = slot % 100 - 1;
						if(dayIndex == i && slotIndex == j) {
							System.out.printf("%s %s %s%s %s %n", Week[dayIndex],
									Slot[slotIndex], course.getDepartment().getDepartmentName(),
									course.getCourseNumber(), course.getName());
						}
					}
				}
			}
		}
	}
}
