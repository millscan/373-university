package org.university.software;

import java.util.ArrayList;

import org.university.hardware.*;
import org.university.people.Student;

public class University {

	public ArrayList<Department> departmentList;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		this.departmentList = new ArrayList<Department>();
		this.classroomList = new ArrayList<Classroom>();
	}
	
	public void printDepartmentList() {
		for(Department d : departmentList) {
			System.out.println(d.getDepartmentName());
		}
	}
	
	public void printStudentList() {
		for(Department d: departmentList) {
			for(Student s: d.getStudentList()) {
				System.out.println(s.getName());
			}
		}
	}
	
	public void printCourseList() {
		for(Department d: departmentList) {
			for(Course c : d.getCourseList()) {
				System.out.println(c.getName());
			}
		}
	}
}
