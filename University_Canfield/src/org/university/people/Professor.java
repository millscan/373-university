package org.university.people;

import org.university.software.Course;
import org.university.hardware.Department;

import java.util.ArrayList;

public class Professor {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		
	private String name;
	private Department department;
	private ArrayList<Course> schedule;
	
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
	
	public boolean detectConflict(Course newCourse) {
		boolean flag = false;
		for(Course course : schedule) {
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
				for(Course course : schedule) {
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
