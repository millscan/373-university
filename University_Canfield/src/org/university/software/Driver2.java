package org.university.software;

import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Person;
import org.university.people.Staff;
import org.university.people.Professor;
import org.university.people.Student;


public class Driver2 
{

	public static void main(String[] args) 
	{

		boolean flag = false;
		int reqCredits = 0;
		double earns = 0;

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

		/* Set Course */

		CampusCourse c1 = new CampusCourse();
		CampusCourse c2 = new CampusCourse();
		CampusCourse c3 = new CampusCourse();
		CampusCourse c4 = new CampusCourse();
		CampusCourse c5 = new CampusCourse();
		CampusCourse c6 = new CampusCourse();
		CampusCourse c7 = new CampusCourse();
		CampusCourse c8 = new CampusCourse();

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

		/* Set attributes */

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

		/* Add course to students */

		s1.addCampusCourse(c4);
		s1.addCampusCourse(c1);
		s1.addCampusCourse(c2);

		s2.addCampusCourse(c2);
		s2.addCampusCourse(c3);

		s3.addCampusCourse(c1);
		s3.addCampusCourse(c2);
		s3.addCampusCourse(c3);
		s3.addCampusCourse(c4);

		s4.addCampusCourse(c1);
		s4.addCampusCourse(c6);

		/* Test staff pay increase */

		System.out.println("Testing Pay increases  ....");

		/* Rate is $ per hour */

		sf1.setPayRate(20.5);

		/* Hours are reported as per pay period */

		sf1.setMonthlyHours(160);
		earns = sf1.earns();
		System.out.printf("Staff Employee: " + sf1.getName() + " earns $" + String.format("%.2f", earns) + " this pay period\n");

		/* Raise is given as %. For example 10% */

		sf1.raise(10);
		System.out.println("After 10% Raise ....");
		earns = sf1.earns();
		System.out.printf("Staff Employee: " + sf1.getName() + " earns $" + String.format("%.2f", earns) + " this pay period\n");

		/* Test Professor pay increase */

		/* Salary is $ per year */

		p1.setSalary(120000);
		earns = p1.earns();

		System.out.println("\nProfessor: " + p1.getName() + " earns $" + String.format("%.2f", earns) + " this pay period");

		/* Raise is given as %. For example 10% */

		p1.raise(8);
		System.out.println("After 8% Raise ....");
		earns = p1.earns();
		System.out.println("Professor: " + p1.getName() + " earns $" + String.format("%.2f", earns) + " this pay period");

		/*
		 * Direct test for collisionDetection() inherited method from Person
		 * class
		 */

		System.out.println("\nTesting collisionDetection method in Person class ...");
		p3.addCampusCourse(c6);
		flag = p3.detectConflict(c8);
		System.out.println("Is there a conflict between " + c6.getName() + " and " + c8.getName() + " ? : " + flag);

		/* Test remaining credits for graduation */

		System.out.println("\nLahiru's credit remaining for graduation ...");

		/* Arg : # of credit for degree(integer) */

		s1.setRequiredCredits(128);

		/* Arg : # of credit taken so far (integer) */

		s1.setCompletedUnits(60);
		reqCredits = s1.requiredToGraduate();
		System.out.println("Student " + s1.getName() + " needs " + reqCredits + " units to graduate");

		
		
		/* Print class roster for CS 387 */
		//M Print online course roster too

		System.out.println("\nThe roster for course " + univ.departmentList.get(1).getCampusCourseList().get(0).getDepartment().getDepartmentName() + univ.departmentList.get(1).getCampusCourseList().get(0).getCourseNumber() + ":");
		ArrayList<Person> sr1 = univ.departmentList.get(1).getCampusCourseList().get(0).getStudentRoster();
		for (Person st : sr1) {
			System.out.println(st.getName() + " ");
		}
		
		/* Print class roster for CS 372 */

		System.out.println("\nThe roster for course " + univ.departmentList.get(1).getCampusCourseList().get(1).getDepartment().getDepartmentName() + univ.departmentList.get(1).getCampusCourseList().get(1).getCourseNumber() + ":");
		ArrayList<Person> sr2 = univ.departmentList.get(1).getCampusCourseList().get(1).getStudentRoster();
		for (Person st : sr2) {
			System.out.println(st.getName() + " ");
		}
		
		/* Print student list from university */
		
		System.out.println("\nThe list of students in the university:");
		//univ.departmentList.get(0).printStudentList();
		//univ.departmentList.get(1).printStudentList();
		univ.printStudentList();
		
		/* Print professor list from university */
		
		System.out.println("\nThe list of professors in the university:");
		//univ.departmentList.get(0).printProfessorList();
		//univ.departmentList.get(1).printProfessorList();
		univ.printProfessorList();
		
		/* Print staff list from university */
		
		System.out.println("\nThe list of staff in the university:");
		//univ.departmentList.get(0).printStaffList();
		//univ.departmentList.get(1).printStaffList();
		univ.printStaffList();
		
		/* Print course list from university */
		
		System.out.println("\nThe list of courses in the university:");
		//M Print online list of courses
		//univ.departmentList.get(0).printCourseList();
		//univ.departmentList.get(1).printCourseList();
		univ.printCourseList();
		
		/* Print student list of CS department */
		
		System.out.println("\nThe student list for department " + univ.departmentList.get(1).getDepartmentName() + ":");
		univ.departmentList.get(1).printStudentList();

		/* Print professor list of ECE department */

		System.out.println("\nThe professor list for department " + univ.departmentList.get(0).getDepartmentName() + ":");
		univ.departmentList.get(0).printProfessorList();

		/* Print course list of ECE department */
		//M Print Online course list too

		System.out.println("\nThe course list for department " + univ.departmentList.get(0).getDepartmentName() + ":");
		univ.departmentList.get(0).printCourseList();
	}
}
