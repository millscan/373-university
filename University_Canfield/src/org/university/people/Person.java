package org.university.people;

import java.io.Serializable;
import java.util.ArrayList;

import org.university.software.*;

public abstract class Person implements Serializable {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	protected String name;
	protected ArrayList<Course> schedule;

	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Course detectConflict(Course newCourse) {
		for(Course course : schedule) {
			for(int newSlot : newCourse.getSchedule()) {
				if(course.getSchedule().contains(newSlot)) {
					System.out.printf("%s%s course cannot be added to %s's schedule. %s%s conflicts with %s%s. Conflicting time slot is %s %s%n",
							newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(),
							this.name, newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(),
							course.getDepartment().getDepartmentName(), course.getCourseNumber(),
							Week[newSlot/100 - 1], Slot[newSlot%100 - 1]
							);
					return course;
				}
			}
		}
		return null;
	}
	
	public String getScheduleString() {
		StringBuilder scheduleString = new StringBuilder();
		int dayIndex;
		int slotIndex;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				for(Course course : schedule) {
					for(int slot : course.getSchedule()) {
						dayIndex = slot / 100 - 1;
						slotIndex = slot % 100 - 1;
						if(dayIndex == i && slotIndex == j) {
							scheduleString.append(String.format("%s %s %s%s %s %n", Week[dayIndex],
									Slot[slotIndex], course.getDepartment().getDepartmentName(),
									course.getCourseNumber(), course.getName()));
						}
					}
				}
			}
		}
		return scheduleString.toString();
	}
	public void printSchedule() {
		System.out.print(getScheduleString());
	}
	
	
	public abstract String addCourse(Course course);
}
