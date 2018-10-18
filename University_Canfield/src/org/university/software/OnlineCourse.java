package org.university.software;

import org.university.people.Student;

public class OnlineCourse extends Course {
	
	public boolean availableTo(Student s) {
		if(s.getCampusUnitsEnrolled() < 6) {
			return true;
		}
		return false;
	}
}
