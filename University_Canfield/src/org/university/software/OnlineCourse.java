package org.university.software;

import org.university.people.Student;

public class OnlineCourse extends Course {
	
	public boolean availableTo(Student s) {
		if(s.getCampusUnitsEnrolled() < 6) {
			System.out.printf("Student %s has only %s on-campus credits enrolled. "
					+ "Should have at least 6 credits registered before registering for online courses.%n", 
					s.getName(), s.getCampusUnitsEnrolled());
			
			return false;
		}
		return true;
	}
}
