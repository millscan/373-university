package org.university.people;

import org.university.hardware.Department;
import org.university.software.*;

public class Staff extends Employee {
	
	private Department department;
	private float payRate;
	private int hoursWorked;
	private float tuitionFee;
	private Course courseTaken;
	
	public float getTuitionFee() {
		if(courseTaken.getClass().toString() == "CampusCourse") {
			return courseTaken.getCreditUnits()*300;
		}
		else {
			return (courseTaken.getCreditUnits() == 3 ? 2000 : 3000 );
		}
	}
	
	public void raise(float raisePercent) {
		payRate = (payRate * (1 + raisePercent));
	}
	
	public void addCampusCourse(CampusCourse cCourse) {
		if(courseTaken != null) {
			removeCourseWithWarning(cCourse);
		}
		courseTaken = cCourse;
	}
	
	public void addOnlineCourse(OnlineCourse oCourse) {
		if(courseTaken != null) {
			removeCourseWithWarning(oCourse);
		}
		courseTaken = oCourse;
	}
	
	private void removeCourseWithWarning(Course newCourse) {
		System.out.printf("%s%s is removed from %s's schedule(Staff can only take one class at a time). %s%s has been added to %s's Schedule", 
				courseTaken.getDepartment().getDepartmentName(), courseTaken.getCourseNumber(), this.name, 
				newCourse.getDepartment().getDepartmentName(), newCourse.getCourseNumber(), this.name);
	}
}
