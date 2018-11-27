package org.university.software;

import java.io.Serializable;
import java.util.ArrayList;

import org.university.hardware.*;
import org.university.people.*;

public class Course implements Serializable {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	private String name;
	private int number;
	private Department department;
	private Professor professor;
	protected ArrayList<Person> roster;
	private int credits;
	private Classroom classroom;
	private ArrayList<Integer> schedule;	
	private int maxStudents;
	
	public Course() {
		this.roster = new ArrayList<Person>();
		this.schedule = new ArrayList<Integer>();
		maxStudents = 10;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCourseNumber(int n) {
		this.number = n;
	}
	
	public int getCourseNumber() {
		return this.number;
	}
	
	public void setDepartment(Department d) {
		this.department = d;
	}
	
	public Department getDepartment() {
		return this.department;
	}

	
	public void setProfessor(Professor p) {
		professor = p;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	
	public void addStudentToRoster(Person s) {
		this.roster.add(s);
	}

	public void removeStudent(Person s) {
		this.roster.remove(s);
	}
	
	public ArrayList<Person> getStudentRoster(){
		return roster;
	}
	
	public void setCreditUnits(int cu) {
		this.credits = cu;
	}
	
	public int getCreditUnits() {
		return credits;
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
		if(this.roster.size() >= maxStudents) {
			return false;
		}
		return true;
	}
	
	public String getRosterString() {
		StringBuilder s = new StringBuilder();
		for(Person p: this.roster) {
			s.append(p.getName() + "\n");
		}
		return s.toString();
	}
	
	public void printRoster() {
		System.out.println(getRosterString());
	}
	
	public String getScheduleString(){
		StringBuilder s = new StringBuilder();
		int dayIndex;
		int slotIndex;
		for(int i = 0; i < 5; i++) {
			for(int slot : this.schedule) {
				dayIndex = slot / 100 - 1;
				slotIndex = slot % 100 - 1;
				if(dayIndex == i) {
					s.append(String.format("%s %s %s%n", Week[dayIndex],
							Slot[slotIndex], this.classroom.getRoomNumber()
					));
				}
			}
		}
		return s.toString();
	}
	
	public void printSchedule() {
		System.out.println(getScheduleString());
	}
	
	public void setMaxCourseLimit(int limit) {
		this.maxStudents = limit;
	}
	
	public int getMaxCourseLimit() {
		return this.maxStudents;
	}

	
}
