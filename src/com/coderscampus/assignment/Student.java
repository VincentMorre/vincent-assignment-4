package com.coderscampus.assignment;

public class Student {

	private String studentId;
	private String studentName;
	private String course;
	private String grade;

	public Student(String studentId, String studentName, String course, String grade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.course = course;
		this.grade = grade;

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}