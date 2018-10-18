package org.university.software;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Professor;
import org.university.people.Student;
import org.university.people.Staff;


public class Driver1 
{

	public static void main(String[] args) 
	{

		/* Initialize University */

		University univ = new University();

		/*
		 * Create University of department, classrooms, professors,
		 * students, staff.
		 */

		/* Set Department */

		Department dept1 = new Department();
		Department dept2 = new Department();

		/* Set Student */

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();

		/* Set Campus Course */

		CampusCourse c1 = new CampusCourse() ;
		CampusCourse c2 = new CampusCourse() ;
		CampusCourse c3 = new CampusCourse() ;
		CampusCourse c4 = new CampusCourse() ;
		CampusCourse c5 = new CampusCourse() ;
		CampusCourse c6 = new CampusCourse() ;
		CampusCourse c7 = new CampusCourse() ;
		CampusCourse c8 = new CampusCourse() ;
		
		/* Set Online Courses */
		OnlineCourse oc1 = new OnlineCourse();
		OnlineCourse oc2 = new OnlineCourse();
		OnlineCourse oc3 = new OnlineCourse();
		OnlineCourse oc4 = new OnlineCourse();

		/* Set Room */

		Classroom cr1 = new Classroom();
		Classroom cr2 = new Classroom();
		Classroom cr3 = new Classroom();
		Classroom cr4 = new Classroom();

		/* Set Professor */

		Professor p1 = new Professor();
		Professor p2 = new Professor();
		Professor p3 = new Professor();
		Professor p4 = new Professor();
		Professor p5 = new Professor();

		/* Set Staff */

		Staff sf1 = new Staff();

		/* Set Attributes */

		dept1.setDepartmentName("ECE");
		dept2.setDepartmentName("CS");

		s1.setName("Lahiru");
		dept1.addStudent(s1);
		s2.setName("Daz");
		dept1.addStudent(s2);
		s3.setName("Ben");
		dept2.addStudent(s3);
		s4.setName("Jerry");
		dept2.addStudent(s4);

		c1.setCourseNumber(387);
		c1.setName("Enterprise Web Applications");
		c1.setCreditUnits(3);
		c1.setMaxCourseLimit(3);
		dept2.addCampusCourse(c1);

		c2.setCourseNumber(372);
		c2.setName("Comparative Programming Languages");
		c2.setCreditUnits(4);
		c2.setMaxCourseLimit(3);
		dept2.addCampusCourse(c2);

		c3.setCourseNumber(345);
		c3.setName("Discrete Structures");
		c3.setCreditUnits(4);
		c3.setMaxCourseLimit(3);
		dept2.addCampusCourse(c3);

		c4.setCourseNumber(426);
		c4.setName("Computer Networks");
		c4.setCreditUnits(4);
		c4.setMaxCourseLimit(3);
		dept2.addCampusCourse(c4);

		c5.setCourseNumber(275);
		c5.setName("Computer Programming II");
		c5.setCreditUnits(3);
		c5.setMaxCourseLimit(3);
		dept1.addCampusCourse(c5);

		c6.setCourseNumber(320);
		c6.setName("Circuits Analysis");
		c6.setCreditUnits(3);
		c6.setMaxCourseLimit(3);
		dept1.addCampusCourse(c6);

		c7.setCourseNumber(373);
		c7.setName("Object Oriented Software Design");
		c7.setCreditUnits(3);
		c7.setMaxCourseLimit(3);
		dept1.addCampusCourse(c7);

		c8.setCourseNumber(107);
		c8.setName("Experimental Course");
		c8.setCreditUnits(3);
		c8.setMaxCourseLimit(3);
		dept1.addCampusCourse(c8);
		
		/* Set Online course name, number and department*/
		oc1.setCourseNumber(610);
		oc1.setName("Online_Course_1");
		oc1.setCreditUnits(3);
		dept1.addOnlineCourse(oc1);
		
		oc2.setCourseNumber(620);
		oc2.setName("Online_Course_2");
		oc2.setCreditUnits(3);
		dept1.addOnlineCourse(oc2);
		
		oc3.setCourseNumber(630);
		oc3.setName("Online_Course_3");
		oc3.setCreditUnits(3);
		dept2.addOnlineCourse(oc3);
		
		
		oc4.setCourseNumber(640);
		oc4.setName("Online_Course_4");
		oc4.setCreditUnits(4);
		dept2.addOnlineCourse(oc4);
		
		/////

		cr1.setRoomNumber("Harvill 101");
		cr2.setRoomNumber("Harvill 203");
		cr3.setRoomNumber("Gould Simpson 102");
		cr4.setRoomNumber("Gould Simpson 105");

		p1.setName("Regan");
		dept1.addProfessor(p1);
		p2.setName("RosenBlit");
		dept1.addProfessor(p2);
		p3.setName("Tharp");
		dept1.addProfessor(p3);
		p4.setName("Kececioglu");
		dept2.addProfessor(p4);
		p5.setName("Homer");
		dept2.addProfessor(p5);

		sf1.setName("Carol");
		dept2.addStaff(sf1);

		univ.departmentList.add(dept1);
		univ.departmentList.add(dept2);

		univ.classroomList.add(cr1);
		univ.classroomList.add(cr2);
		univ.classroomList.add(cr3);
		univ.classroomList.add(cr4);

		/* Initialization ending */

		/* Test1 beginning */

		c1.setSchedule(201);
		c1.setSchedule(401);
		c2.setSchedule(202);
		c2.setSchedule(402);
		c3.setSchedule(303);
		c3.setSchedule(503);
		c4.setSchedule(102);
		c4.setSchedule(302);
		c5.setSchedule(303);
		c5.setSchedule(503);
		c6.setSchedule(102);
		c6.setSchedule(302);
		c7.setSchedule(201);
		c7.setSchedule(401);
		c8.setSchedule(102);


		/* Sign up professors */

		/* Sign up Prof. Tharp for class ECE320 */

		p3.addCampusCourse(c6);

		/* Sign up Prof. Kececioglu for class CS387 */

		p4.addCampusCourse(c1);

		/* Sign up Prof. Kececioglu for class CS372 */

		p4.addCampusCourse(c2);

		/* Sign up Prof. Homer for class CS345 */

		p5.addCampusCourse(c3);

		/* Sign up Prof. Homer for class CS426 */

		p5.addCampusCourse(c4);
		
		/* Set professors for the online courses */
		p1.addOnlineCourse(oc1);
		p2.addOnlineCourse(oc2);
		p4.addOnlineCourse(oc3);
		p5.addOnlineCourse(oc4);
		
		///

		/* Set classrooms for campus courses */

		c1.setRoomAssigned(cr2);
		c2.setRoomAssigned(cr4);
		c3.setRoomAssigned(cr3);
		c4.setRoomAssigned(cr3);
		c6.setRoomAssigned(cr1);

		/* Add course to students */

		s1.addCampusCourse(c4);
		s1.addCampusCourse(c1);

		s2.addCampusCourse(c2);
		s2.addCampusCourse(c3);
		s2.addCampusCourse(c8);

		s3.addCampusCourse(c1);
		s3.addCampusCourse(c2);
		s3.addCampusCourse(c3);
		s3.addCampusCourse(c4);


		s4.addCampusCourse(c1);
		s4.addCampusCourse(c2);
		s4.addCampusCourse(c6);
		
		/* Adding online courses to students */

		s1.addOnlineCourse(oc1);
		s2.addOnlineCourse(oc2);
		s3.addOnlineCourse(oc3);
		s4.addOnlineCourse(oc4);
		////
		System.out.println("Testing addCampusCourse method when Campus Course has enough students  ...");
		s2.addCampusCourse(c1);
		
		System.out.println("\nTesting availableTo method in CampusCourse when Campus Course has enough students  ...");
		System.out.println("Does this Campus Course available for more student to add? True or false:");
		System.out.println(c1.availableTo(s2));
		
		System.out.println("\nTesting Professor Conflicts  ...");
		p3.addCampusCourse(c1);
		p4.addCampusCourse(c3);
		
		//Checking online course conflict between professors
		p3.addOnlineCourse(oc1);

		System.out.println("\nTesting dropCampusCourse method in Student class ...");
		s1.dropCampusCourse(c7);
		s1.addCampusCourse(c5);
		s1.dropCampusCourse(c5);
		s2.dropCampusCourse(c8);
		System.out.println("\nTesting dropCampusCourse method if campus course won't have at least 6 credts to stay enroll in online courses in Student class ...");
		s1.dropCampusCourse(c1);
		
		System.out.println("\nTesting addOnlineCourse method in Student class ...");
		s1.dropOnlineCourse(oc1);
		s1.dropCampusCourse(c1);
		s1.addOnlineCourse(oc2);
		
		System.out.println("\nTesting dropOnlineCourse method in Student class ...");
		s1.addCampusCourse(c1);
		s1.addOnlineCourse(oc1);
		s1.addOnlineCourse(oc2);
		s1.dropOnlineCourse(oc2);
		
		s1.dropOnlineCourse(oc3);
		s3.dropOnlineCourse(oc1);

		/* Test conflicts of student schedule */
		System.out.println("\nConflicts:");

		/* Test conflicts of classroom schedule */
		System.out.println("\nTest conflicts of classroom schedule:");
		c8.setRoomAssigned(cr1);

		
		/* Test conflicts of professor schedule */
		System.out.println("\nTest conflicts of professor schedule:");
		p3.addCampusCourse(c8);
		p5.addCampusCourse(c5);

		/* Try to add ECE320 to student Lahiru */
		System.out.println("\ntest Conflicts when add course to student:");
		s1.addCampusCourse(c6);

		/* Try to add ECE373 to student Lahiru */

		s1.addCampusCourse(c7);

		s2.addCampusCourse(c5);

		/* Add course to staff */
		System.out.println("\ntest Conflicts when add course to staff:");
		sf1.addCampusCourse(c1);

		/* Test adding more than 1 course */

		sf1.addCampusCourse(c2);
		
		sf1.addOnlineCourse(oc3);
		sf1.addOnlineCourse(oc4);

		
		/* Schedules */

		System.out.println("\nThe schedule for Prof. " + univ.departmentList.get(0).getProfessorList().get(2).getName() + ":");
		univ.departmentList.get(0).getProfessorList().get(2).printSchedule();

		System.out.println("\nThe schedule for Prof. " + univ.departmentList.get(1).getProfessorList().get(0).getName() + ":");
		univ.departmentList.get(1).getProfessorList().get(0).printSchedule();

		System.out.println("\nThe schedule for Prof. " + univ.departmentList.get(1).getProfessorList().get(1).getName() + ":");
		univ.departmentList.get(1).getProfessorList().get(1).printSchedule();

		/* Print schedule of classroom 1 */

		System.out.println("\nThe schedule for " + univ.classroomList.get(0).getRoomNumber() + ":");
		univ.classroomList.get(0).printSchedule();

		/* Print schedule of classroom 2 */

		System.out.println("\nThe schedule for " + univ.classroomList.get(1).getRoomNumber() + ":");
		univ.classroomList.get(1).printSchedule();

		/* Print schedule of classroom 3 */

		System.out.println("\nThe schedule for " + univ.classroomList.get(2).getRoomNumber() + ":");
		univ.classroomList.get(2).printSchedule();

		/* Print schedule of classroom 4 */

		System.out.println("\nThe schedule for " + univ.classroomList.get(3).getRoomNumber() + ":");
		univ.classroomList.get(3).printSchedule();

		/* Student schedules */

		System.out.println("\nThe schedule for Student " + univ.departmentList.get(0).getStudentList().get(0).getName() + ":");
		univ.departmentList.get(0).getStudentList().get(0).printSchedule();
		
		
		System.out.println("\nThe schedule for Student " + univ.departmentList.get(1).getStudentList().get(0).getName() + ":");
		univ.departmentList.get(1).getStudentList().get(0).printSchedule();

		
		System.out.println("\nThe schedule for Student " + univ.departmentList.get(1).getStudentList().get(1).getName() + ":");
		univ.departmentList.get(1).getStudentList().get(1).printSchedule();

		
		/* Staff schedules */

		System.out.println("\nThe schedule for Employee " + univ.departmentList.get(1).getStaffList().get(0).getName() + ":");
		univ.departmentList.get(1).getStaffList().get(0).printSchedule();
		
		/* Calculate tuition fees */
		
		System.out.println("\nTuition Fee for student " + univ.departmentList.get(0).getStudentList().get(0).getName() + " is " + 
				String.format("%d", univ.departmentList.get(0).getStudentList().get(0).getTuitionFee()) );

		System.out.println("Tuition Fee for student " + univ.departmentList.get(1).getStudentList().get(0).getName() + " is " + 
				String.format("%d", univ.departmentList.get(1).getStudentList().get(0).getTuitionFee()) );
		
		System.out.println("Tuition Fee for student " + univ.departmentList.get(1).getStudentList().get(1).getName() + " is " + 
				String.format("%d", univ.departmentList.get(1).getStudentList().get(1).getTuitionFee()) );
		
		System.out.println("Tuition Fee for Employee  " + univ.departmentList.get(1).getStaffList().get(0).getName() + " is " + 
				String.format("%d", univ.departmentList.get(1).getStaffList().get(0).getTuitionFee()));
		
		/* Print schedule of course 1 */

		System.out.println("\nThe schedule for course " + univ.departmentList.get(1).getCampusCourseList().get(0).getName() + ":");
		univ.departmentList.get(1).getCampusCourseList().get(0).printSchedule();
		
		/* Print Course List for Department ECE*/
		System.out.println("\nThe course list for department " + univ.departmentList.get(0).getDepartmentName() + ":");
		univ.departmentList.get(0).printCourseList();
		
		/*Print Course list of university*/
		System.out.println("\nThe list of courses in the university:");
		univ.printCourseList();
		
		

	}
}