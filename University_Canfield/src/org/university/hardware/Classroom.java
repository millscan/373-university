package org.university.hardware;

import org.university.software.Course;

import java.util.ArrayList;

public class Classroom {
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	private String roomNumber;
	private ArrayList<Course> schedule;
	
	public Classroom() {
		schedule = new ArrayList<Course>();
	}	
	
	public void setRoomNumber(String newNumber) {
		roomNumber = newNumber;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}	
	
	public boolean addCourse(Course newCourse) {
		
		//First, do conflict detection
		if(detectConflict(newCourse)) {
			return false;
		}
		
		//if no conflict, add course to schedule
		schedule.add(newCourse);

		//return true if successful, else return false
		return true;
	}
	
	public boolean removeCourse(Course oldCourse) {
		//return true if course was in schedule, else return false
		return schedule.remove(oldCourse);
	}
	
	public ArrayList<Course> getSchedule(){
		return schedule;
	}
	
	public boolean detectConflict(Course newCourse) {
		for(Course course : schedule) {
			for(int newSlot : newCourse.getSchedule()) {
				if(course.getSchedule().contains(newSlot)) {
					System.out.printf("%s%s conflicts with %s%s. Conflicting time slot %s %s. %s%s course cannot be added to %s's schedule.%n",
							newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(), course.getDepartment().getDepartmentName(),
							course.getCourseNumber(), Week[newSlot / 100 -1], Slot[newSlot % 100 - 1], newCourse.getDepartment().getDepartmentName(),
							newCourse.getCourseNumber(), this.roomNumber);
					return true;
				}
			}
		}
		return false;
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
