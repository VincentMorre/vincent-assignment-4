package com.coderscampus.assignment;

import java.io.*;
import java.util.Arrays;

public class FileService {

	public Student[] fileReader() {
		Student[] students = new Student[101];
		BufferedReader br = null;
		
		try {
			int i = 0;
			String line = null;

			br = new BufferedReader(new FileReader("masterList.csv"));

			while ((line = br.readLine()) != null) {
				String[] rows = line.split(",");
				Student student = new Student(rows[0], rows[1], rows[2], rows[3]);
				students[i] = student;
				i++;
			}
			return students;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public void writeFile() throws IOException {

		FileService fileProcess = new FileService();
		Student[] student = fileProcess.fileReader();
		Arrays.sort(student, new FileCompare());
		BufferedWriter writeCompsci = null;
		BufferedWriter writeApm = null;
		BufferedWriter writeStat = null;

		try {
			writeCompsci = new BufferedWriter(new FileWriter("course1.csv"));
			writeApm = new BufferedWriter(new FileWriter("course2.csv"));
			writeStat = new BufferedWriter(new FileWriter("course3.csv"));

			writeCompsci.write("StudentId, StudentName, Course, Grade \n");
			writeApm.write("StudentId, StudentName, Course, Grade \n");
			writeStat.write("StudentId, StudentName, Course, Grade \n");

			for (Student s : student) {

				String course = s.getCourse();
				String line = s.getStudentId() + "," + s.getStudentName() + "," + s.getCourse() + "," + s.getGrade()
						+ "\n";

				if (course.contains("COMPSCI")) {
					writeCompsci.write(line);
				} else if (course.contains("APMTH")) {
					writeApm.write(line);
				} else if (course.contains("STAT")) {
					writeStat.write(line);
				}
			}
		} finally {

			if (writeCompsci != null) {
				try {
					writeCompsci.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writeApm != null) {
				try {
					writeApm.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writeStat != null) {
				try {
					writeStat.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
	