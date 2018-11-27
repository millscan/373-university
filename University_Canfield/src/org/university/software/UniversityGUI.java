package org.university.software;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.university.hardware.Department;
import org.university.people.Student;

public class UniversityGUI extends JFrame {
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 100;
	protected University university;
	
	public UniversityGUI(String name, University u) {
		super(name);
		this.university = u;
		this.setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = MenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(MenuButton("Save"));
		fileMenu.add(MenuButton("Load"));
		fileMenu.add(MenuButton("Exit"));
		
		JMenu studentMenu = new JMenu("Students");
		studentMenu.add(MenuButton("Add Course"));
		studentMenu.add(MenuButton("Drop Course"));
		studentMenu.add(MenuButton("Print Schedule"));
		
		JMenu administratorMenu = new JMenu("Administrators");
		administratorMenu.add(MenuButton("Print All Info"));
		
		menuBar.add(fileMenu);
		menuBar.add(studentMenu);
		menuBar.add(administratorMenu);
		
		add(menuBar, BorderLayout.NORTH);
		
		setVisible(true);
	}

   
   JMenuBar MenuBar() {
	   JMenuBar menuBar = new JMenuBar();
	   menuBar.setSize(new Dimension(600, 100));
	   
	   return menuBar;
   }

   
   private JMenuItem MenuButton(String name) {
	   JMenuItem menuButton = new JMenuItem(name);
	   menuButton.addActionListener(new MenuButtonListener(name));
	   return menuButton;
   }
   
   private class MenuButtonListener implements ActionListener{

	   public MenuButtonListener(String name) {
		   this.name = name;
	   }
	   
	   private String name;
	   
	   public void actionPerformed(ActionEvent e) {
		   //GET BUTTON NAME FROM EVENT
		   switch(this.name.toUpperCase()) {
		   case "SAVE":
			   handleSave();
			   break;
		   case "LOAD":
			   handleLoad();
			   break;
		   case "EXIT":
			   handleExit();
			   break;
		   case "ADD COURSE":
			   handleAddCourse();
			   break;
		   case "DROP COURSE":
			   handleDropCourse();
			   break;
		   case "PRINT SCHEDULE":
			   handlePrintSchedule();
			   break;
		   case "PRINT ALL INFO":
			   handlePrintAllInfo();
			   break;
		   }
	   }
	   
	   private void handleSave() {
		  University.saveData(university);
	   }
	   
	   private void handleLoad() {
		   university = University.loadData();
	   }
	   
	   private void handleExit() {
		   System.exit(0);
	   }
	   
	   private void handleAddCourse() {
		   JFrame addCourseFrame = new JFrame("Add Course");
		   addCourseFrame.setLocationRelativeTo(null);
		   addCourseFrame.setSize(300, 150);
		   addCourseFrame.setUndecorated(true);
		   
		   JPanel topBar = new JPanel();
		   topBar.setSize(400, 20);
		   JLabel header = new JLabel("Add Course");
		   topBar.add(header);
		   
		   JPanel inputPanel = new JPanel();
		   inputPanel.setLayout(new GridLayout(0, 1, 5, 5));
		   
		   JPanel namePanel = new JPanel();
		   namePanel.setLayout(new GridLayout(1, 0));
		   JLabel nameLabel = new JLabel("Student Name: ", JLabel.CENTER);
		   JTextField nameField = new JTextField(15);
		   namePanel.add(nameLabel);
		   namePanel.add(nameField);
		   
		   JPanel departmentPanel = new JPanel();
		   departmentPanel.setLayout(new GridLayout(1, 0));
		   JLabel departmentLabel = new JLabel("Department: ", JLabel.CENTER);
		   JTextField departmentField = new JTextField(15);
		   departmentPanel.add(departmentLabel);
		   departmentPanel.add(departmentField);
		   
		   JPanel coursePanel = new JPanel();
		   coursePanel.setLayout(new GridLayout(1, 0));
		   JLabel courseLabel = new JLabel("Course #:", JLabel.CENTER);
		   JTextField courseField = new JTextField(15);
		   coursePanel.add(courseLabel);
		   coursePanel.add(courseField);
		   
		   JPanel buttonPanel = new JPanel();
		   buttonPanel.setLayout(new GridLayout(1, 0, 10, 10));
		   JButton okButton = new JButton("OK");
		   okButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //MAKE SURE INFO IS GUCCI AND CREATE PERSON
				   Department d = university.getDepartmentWithName(departmentField.getText());
				   if(d == null) {
					   JOptionPane.showMessageDialog(null, "Department " + departmentField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
					   addCourseFrame.dispose();
				   }
				   else {
					   Student s = d.getStudentFromName(nameField.getText());
					   if(s == null) {
						   JOptionPane.showMessageDialog(null, "Student " + nameField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
						   addCourseFrame.dispose(); 
					   }
					   else {
						   Course c = d.getCourseFromName(courseField.getText());
						   if(c == null) {
							   JOptionPane.showMessageDialog(null, "Course " + courseField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
							   addCourseFrame.dispose(); 
						   }
						   else {
							   String statusMessage = s.addCourse(c);
							   JOptionPane.showMessageDialog(null,statusMessage, null, JOptionPane.PLAIN_MESSAGE);
							   addCourseFrame.dispose();
						   }
					   }
				   }
			   }
		   });
		   
		   JButton cancelButton = new JButton("Cancel");
		   cancelButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //CLOSE THIS WINDOW
				   System.out.println("CANCEL PRESSED");
				   addCourseFrame.dispose();
			   }
		   });
		   buttonPanel.add(okButton);
		   buttonPanel.add(cancelButton);
		   
		   inputPanel.add(namePanel);
		   inputPanel.add(departmentPanel);
		   inputPanel.add(coursePanel);
		   inputPanel.add(buttonPanel);
		   
		   addCourseFrame.add(topBar, BorderLayout.NORTH);
		   addCourseFrame.add(inputPanel, BorderLayout.CENTER);
		   addCourseFrame.setVisible(true);
	   }
	   
	   private void handleDropCourse() {
		   JFrame addCourseFrame = new JFrame("Drop Course");
		   addCourseFrame.setLocationRelativeTo(null);
		   addCourseFrame.setSize(300, 200);
		   addCourseFrame.setUndecorated(true);
		   
		   JPanel topBar = new JPanel();
		   topBar.setSize(400, 20);
		   JLabel header = new JLabel("Add Course");
		   topBar.add(header);
		   
		   JPanel inputPanel = new JPanel();
		   inputPanel.setLayout(new GridLayout(0, 1, 5, 5));
		   
		   JPanel namePanel = new JPanel();
		   namePanel.setLayout(new GridLayout(1, 0));
		   JLabel nameLabel = new JLabel("Student Name: ", JLabel.CENTER);
		   JTextField nameField = new JTextField(15);
		   namePanel.add(nameLabel);
		   namePanel.add(nameField);
		   
		   JPanel departmentPanel = new JPanel();
		   departmentPanel.setLayout(new GridLayout(1, 0));
		   JLabel departmentLabel = new JLabel("Department: ", JLabel.CENTER);
		   JTextField departmentField = new JTextField(15);
		   departmentPanel.add(departmentLabel);
		   departmentPanel.add(departmentField);
		   
		   JPanel coursePanel = new JPanel();
		   coursePanel.setLayout(new GridLayout(1, 0));
		   JLabel courseLabel = new JLabel("Course #:", JLabel.CENTER);
		   JTextField courseField = new JTextField(15);
		   coursePanel.add(courseLabel);
		   coursePanel.add(courseField);
		   
		   JPanel buttonPanel = new JPanel();
		   buttonPanel.setLayout(new GridLayout(1, 0, 10, 10));
		   JButton okButton = new JButton("OK");
		   okButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //MAKE SURE INFO IS GUCCI AND CREATE PERSON
				   Department d = university.getDepartmentWithName(departmentField.getText());
				   if(d == null) {
					   JOptionPane.showMessageDialog(null, "Department " + departmentField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
					   addCourseFrame.dispose();
				   }
				   else {
					   Student s = d.getStudentFromName(nameField.getText());
					   if(s == null) {
						   JOptionPane.showMessageDialog(null, "Student " + nameField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
						   addCourseFrame.dispose(); 
					   }
					   else {
						   Course c = d.getCourseFromName(courseField.getText());
						   if(c == null) {
							   JOptionPane.showMessageDialog(null, "Course " + courseField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
							   addCourseFrame.dispose(); 
						   }
						   else {
							   if(s.dropCourse(c)) {
								  JOptionPane.showMessageDialog(null,String.format("Student %s has been dropped from %s%s", 
										  nameField.getText(), departmentField.getText(), courseField.getText()), "Success", JOptionPane.PLAIN_MESSAGE);
							   }
							   else {
								   JOptionPane.showMessageDialog(null,String.format("The course %s%s could not be dropped because %s is not enrolled in %s%s.%n",
											c.getDepartment().getDepartmentName(), c.getCourseNumber(),
											s.getName(), c.getDepartment().getDepartmentName(), c.getCourseNumber()), "Error", JOptionPane.ERROR_MESSAGE);
							   }
						   }
					   }
				   }
			   }
		   });
		   
		   JButton cancelButton = new JButton("Cancel");
		   cancelButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //CLOSE THIS WINDOW
				   System.out.println("CANCEL PRESSED");
				   addCourseFrame.dispose();
			   }
		   });
		   buttonPanel.add(okButton);
		   buttonPanel.add(cancelButton);
		   
		   inputPanel.add(namePanel);
		   inputPanel.add(departmentPanel);
		   inputPanel.add(coursePanel);
		   inputPanel.add(buttonPanel);
		   
		   addCourseFrame.add(topBar, BorderLayout.NORTH);
		   addCourseFrame.add(inputPanel, BorderLayout.CENTER);
		   addCourseFrame.setVisible(true);
	   }
	   
	   private void handlePrintSchedule() {
		   JFrame printScheduleFrame = new JFrame("Print Student Schedule");
		   printScheduleFrame.setLocationRelativeTo(null);
		   printScheduleFrame.setSize(300, 100);
		   printScheduleFrame.setUndecorated(true);
		   
		   JPanel topBar = new JPanel();
		   topBar.setSize(400, 20);
		   JLabel header = new JLabel("Print Student Schedule");
		   topBar.add(header);
		   
		   JPanel inputPanel = new JPanel();
		   inputPanel.setLayout(new GridLayout(0, 1, 5, 5));
		   
		   JPanel namePanel = new JPanel();
		   namePanel.setLayout(new GridLayout(1, 0));
		   JLabel nameLabel = new JLabel("Student Name: ", JLabel.CENTER);
		   JTextField nameField = new JTextField(15);
		   namePanel.add(nameLabel);
		   namePanel.add(nameField);
		   
		   JPanel buttonPanel = new JPanel();
		   buttonPanel.setLayout(new GridLayout(1, 0, 10, 10));
		   JButton okButton = new JButton("OK");
		   okButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   Student s = university.getStudentWithName(nameField.getText());
				   if(s == null) {
					   JOptionPane.showMessageDialog(null, "Student " + nameField.getText() + " doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
					   printScheduleFrame.dispose(); 
				   }
				   else {
					   JFrame studentScheduleFrame = new JFrame();
					   studentScheduleFrame.setSize(400, 300);
					   studentScheduleFrame.setLocationRelativeTo(null);
					   studentScheduleFrame.setUndecorated(true);
					   
					   JLabel titleLabel = new JLabel("Student " + s.getName() + "'s Schedule");
					   titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
					   
					   JTextArea scheduleLabel = new JTextArea(s.getScheduleString());
					   scheduleLabel.setEditable(false);
					   scheduleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
					   
					   JScrollPane scroll = new JScrollPane (scheduleLabel, 
							   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					   scroll.setBorder(new EmptyBorder(10, 10, 10, 10));
					   
					   
					   JButton scheduleOkButton = new JButton("OK");
					   scheduleOkButton.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent e){
							   studentScheduleFrame.dispose();
						   }
					   });
					   
					   studentScheduleFrame.add(titleLabel, BorderLayout.NORTH);
					   studentScheduleFrame.add(scroll, BorderLayout.CENTER);
					   studentScheduleFrame.add(scheduleOkButton, BorderLayout.SOUTH);
					   studentScheduleFrame.setVisible(true);
					   printScheduleFrame.dispose();					   
				   }
			   }
		   });
		   
		   JButton cancelButton = new JButton("Cancel");
		   cancelButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //CLOSE THIS WINDOW
				   System.out.println("CANCEL PRESSED");
				   printScheduleFrame.dispose();
			   }
		   });
		   buttonPanel.add(okButton);
		   buttonPanel.add(cancelButton);
		   
		   inputPanel.add(namePanel);
		   inputPanel.add(buttonPanel);
		   
		   printScheduleFrame.add(topBar, BorderLayout.NORTH);
		   printScheduleFrame.add(inputPanel, BorderLayout.CENTER);
		   printScheduleFrame.setVisible(true);
	   }
	   
	   private void handlePrintAllInfo() {
	
		   JFrame printAllFrame = new JFrame();
		   printAllFrame.setSize(500, 600);
		   printAllFrame.setLocationRelativeTo(null);
		   printAllFrame.setUndecorated(true);
		   
		   JLabel titleLabel = new JLabel("University Info");
		   titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		   
		   JTextArea scheduleLabel = new JTextArea(university.stringify());
		   scheduleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		   scheduleLabel.setEditable(false);
		   
		   JScrollPane scroll = new JScrollPane (scheduleLabel, 
				   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		   scroll.setBorder(new EmptyBorder(10, 10, 10, 10));
		   
		   JButton scheduleOkButton = new JButton("OK");
		   scheduleOkButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e){
				   printAllFrame.dispose();
			   }
		   });
		   
		   printAllFrame.add(titleLabel, BorderLayout.NORTH);
		   printAllFrame.add(scroll, BorderLayout.CENTER);
		   printAllFrame.add(scheduleOkButton, BorderLayout.SOUTH);
		   printAllFrame.setVisible(true);	   

	   }
   }
  
}
