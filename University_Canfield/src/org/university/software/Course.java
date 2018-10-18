package org.university.software;

import java.util.ArrayList;

import org.university.hardware.*;
import org.university.people.*;

public class Course {
	
	String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	private String name;
	private int number;
	private Department department;
	private Classroom classroom;
	private Professor professor;
	private ArrayList<Student> roster;
	private ArrayList<Integer> schedule;
	
	public Course() {
		this.roster = new ArrayList<Student>();
		this.schedule = new ArrayList<Integer>();
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
	
	public void setRoomAssigned(Classroom newRoom) {
		if(newRoom.addCourse(this)) {
			classroom = newRoom;
		}
	}
	
	public Classroom getRoomAssigned() {
		return classroom;
	}
	
	public void setProfessor(Professor p) {
		professor = p;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setSchedule(int s) {
		schedule.add(s);
	}
	
	public ArrayList<Integer> getSchedule(){
		return this.schedule;
	}
	
	public void addStudent(Student s) {
		this.roster.add(s);
		if(!s.getCourses().contains(this)) {
			s.addCourse(this);
		}
	}
	
	public void removeStudent(Student s) {
		this.roster.remove(s);
		if(s.getCourses().contains(this)) {
			s.dropCourse(this);
		}
	}
	
	public ArrayList<Student> getStudentRoster(){
		return roster;
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
	
}
