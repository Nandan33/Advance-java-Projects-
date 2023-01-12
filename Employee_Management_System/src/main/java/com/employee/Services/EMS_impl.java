package com.employee.Services;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Employe.model.Connection;
import com.Employe.model.Employee;

public class EMS_impl implements EmployeDAO {

	// Create operation
	public void createEmp_details() {
		// creating session object and using Configaration present in
		// Connection.getSession()
		try (Session session = Connection.getSession();) {
			Transaction tr = session.beginTransaction();

			Scanner sc = new Scanner(System.in);
			int Age;
			double Salary;
			String FN, LN, Dept, Email;
			// for taking input from user
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Enter Employee First Name : ");
			FN = sc.next();
			System.out.println("Enter Employee Last Name : ");
			LN = sc.next();
			System.out.println("Enter Employee Age : ");
			Age = sc.nextInt();
			System.out.println("Enter Employee Email : ");
			Email = sc.next();
			System.out.println("Enter Employee Department : ");
			Dept = sc.next();
			System.out.println("Enter Employee salary : ");
			Salary = sc.nextDouble();

			// To set/save Employee details
			Employee em = new Employee();
			em.setEmp_FirstName(FN);
			em.setEmp_LastName(LN);
			em.setEmp_Age(Age);
			em.setEmp_Email(Email);
			em.setEmp_Department(Dept);
			em.setEmp_Salary(Salary);
			session.save(em);
			tr.commit();
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
			System.out.println(
					"             ....................... || Sucessfully Added Employe Data || ...............................                      ");
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			session.close();
		} catch (InputMismatchException e) {
			System.out.println("Entered wrong datatype Enter Integer to save data   " + e.getMessage());
		}
	}

	// Read operation
	public void readEmp_details() {
		// Try catch block is used to handle the exceptions for example nullpointer and
		// inoutmismatch exception
		// Connection.getSession() this method contains all configarations and
		// sessionfactory
		try (Session session = Connection.getSession();) {
			// taking input from user
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Confirm Password To Continue : ");
			String pass = sc.next();

			// Asking password to execute fetching data from database
			if (pass.equals("admin@123")) {
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(" Search Employee ID : ");
				int id;
				id = sc.nextInt();
				Employee em = session.get(Employee.class, id);

				System.out.println("Employee Id                   : " + em.getEmp_Id());
				System.out.println("Employee First Name   : " + em.getEmp_FirstName());
				System.out.println("Employee Last Name    : " + em.getEmp_LastName());
				System.out.println("Employee Age                 : " + em.getEmp_Age());
				System.out.println("Employee Email             : " + em.getEmp_Email());
				System.out.println("Employee Department  : " + em.getEmp_Department());
				System.out.println("Employee Salary            : " + em.getEmp_Salary());

				session.close();
			} else {
				System.out.println("Wrong Password");
			}
			// handling exception and print custom mesg
		} catch (NullPointerException np) {
			System.out.println("Null pointer exception You Entered Id that is Not Present In DataBase.......");
		}
	}

	// Update operation
	public void updateEmp_details() {

		try (Session session = Connection.getSession();) {
			Transaction tr = session.beginTransaction();
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("To Update Enter Employe ID : ");
			int id = sc.nextInt();
			Employee em = session.get(Employee.class, id);
			System.out.println("Select the Field You have to update : ");
			System.out.println("1.First Name \n 2.Last Name \n 3.Age  \n 4.Email \n 5.Department \n 6.Salary  ");
			int input = sc.nextInt();

			// using switch case to give options for user to choose which feild they want to
			// update
			switch (input) {
			case 1:
				System.out.println("Enter new First name : ");
				String newfn = sc.next();
				em.setEmp_FirstName(newfn);
				break;
			case 2:
				System.out.println("Enter new Last name : ");
				String newln = sc.next();
				em.setEmp_LastName(newln);
				break;
			case 3:
				System.out.println("Enter new Age : ");
				int newage = sc.nextInt();
				em.setEmp_Age(newage);
				break;
			case 4:
				System.out.println("Enter new Department : ");
				String newdept = sc.next();
				em.setEmp_Department(newdept);
				break;
			case 5:
				System.out.println("Enter new Email : ");
				String newEmail = sc.next();
				em.setEmp_Email(newEmail);
				break;
			case 6:
				System.out.println("Enter new salary : ");
				double newsalary = sc.nextDouble();
				em.setEmp_Salary(newsalary);
				break;

			default:
				System.out.println("!!!.....invalid input.......!!!");
				break;
			}
			session.save(em);
			tr.commit();
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"                    ........................ || Data Updated sucessfully || ........................                         ");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			session.close();
		} catch (InputMismatchException i) {
			System.out.println(" you Entered wromg Datatype  " + i.getMessage());
		}
	}

	// Delete Operation
	public void deleteEmp_details() {
		try (Session session = Connection.getSession();) {
			Transaction tr = session.beginTransaction();
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Delete Employee data where Id : ");
			int id = sc.nextInt();
			Employee d = session.get(Employee.class, id);
			session.delete(d);
//			session.save(d);
			tr.commit();
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(".......................Data Deleted Sucessfully.............................");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" ");
		} catch (NullPointerException n) {
			System.out.println("Data is not present in table try other data " + n.getMessage());
		} catch (IllegalArgumentException a) {
			System.out.println(" Data Does Not Exist... " + a.getMessage());
		}
	}

}
