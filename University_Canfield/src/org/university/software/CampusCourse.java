package org.university.software;

import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.people.Student;

public class CampusCourse extends Course {

	private Classroom classroom;
	private ArrayList<Integer> schedule;	
	private int maxStudents;
	
	public CampusCourse() {
		this.schedule = new ArrayList<Integer>();
	}
	
	public void setRoomAssigned(Classroom newRoom) {
		if(newRoom.addCourse(this)) {
			classroom = newRoom;
		}
	}
	
	public Classroom getRoomAssigned() {
		return classroom;
	}
	
	
	public void setSchedule(int s) {
		schedule.add(s);
	}
	
	public ArrayList<Integer> getSchedule(){
		return this.schedule;
	}
	
	public boolean availableTo(Student s) {
		if(this.roster.size() == maxStudents) {
			return false;
		}
		return true;
	}
	
	
	public void printSchedule() {
		int dayIndex;
		int slotIndex;
		for(int i = 0; i < 5; i++) {
			for(int slot : this.schedule) {
				dayIndex = slot / 100 - 1;
				slotIndex = slot % 100 - 1;
				if(dayIndex == i) {
					System.out.printf("%s %s %s%n", Week[dayIndex],
							Slot[slotIndex], this.classroom.getRoomNumber()
					);
				}
			}
		}
	}
	
	public void setMaxCourseLimit(int limit) {
		this.maxStudents = limit;
	}
	
	public int getMaxCourseLimit() {
		return this.maxStudents;
	}
}
