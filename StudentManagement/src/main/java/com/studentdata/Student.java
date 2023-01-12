package com.studentdata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_management_System")
public class Student {

	// this is a pojo class here we are createing a student table columns
	@Id
	private int Student_Id;
	private String Student_Name;
	private int Student_Age;
	private String Student_Course;

}
