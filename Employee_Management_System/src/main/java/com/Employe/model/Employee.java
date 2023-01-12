package com.Employe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMS")
public class Employee {

	// creating a Employee fields and adding geter setter and tostring method with
	// lambok annotation
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Emp_Id;
	private String Emp_FirstName;
	private String Emp_LastName;
	private String Emp_Email;
	private String Emp_Department;
	private double Emp_Salary;
	private int Emp_Age;

}
