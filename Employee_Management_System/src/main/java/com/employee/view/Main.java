package com.employee.view;

import java.util.Scanner;

import com.employee.Services.EMS_impl;

public class Main {

	public static void main(String[] args) {

		// creating object to acess employee features that we createcd in EmployeDAO
		EMS_impl e = new EMS_impl();

		char Ch;

		// Scanner class to take input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"..........................................................................................................................................................................................................................");
		System.out.println(
				"..................................<<<<<<<<<<<<<<<<<< || Employeee Management System ||>>>>>>>>>>>>>>>>>>>>>>>>......................................");
		System.out.println(
				"...........................................................................................................................................................................................................................");

		System.out.println("| Log-In To Continue |");
		System.out.println(" ");

		System.out.println("Enter User Name : ");
		String username = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();

		// using conditianal statement to verify username and password
		if (username.equals("Admin") && password.equals("admin@123")) {
			System.out.println(" ");
			System.out.println("<<<<<<<<<<<<<<< LOG-IN COMPLETE WELCOME TO EMS >>>>>>>>>>>>>>>>");
			System.out.println(" ");

			// once you enter the loop it will execute switch satatement and call functions
			// in Employe DAo interface
			do {
				System.out.println(" ");
				System.out.println(
						"Select Operation \n 1 . Create Employee Data \n 2 . Read Employee Data \n 3 . Update Employee Data \n 4 . Delete Employee Data \n 5 . Exit  ");
				int op = sc.nextInt();

				switch (op) {
				case 1:
					e.createEmp_details();
					break;
				case 2:
					e.readEmp_details();
					break;
				case 3:
					e.updateEmp_details();
					break;
				case 4:
					e.deleteEmp_details();
					break;
				case 5:
					System.out.println("..........ThankYou.............");
					System.exit(op);
					break;

				default:
					System.out.println("!!!..............invalid operation....................!!!");
					break;
				}

				System.out.println(" ");
				System.out.println("Do you want to continue press ' y ' / press ' n ' to Log-out");

				Ch = sc.next().charAt(0);
				// if you press y it run loop again if you press anything other than y it will
				// print logout
			} while (Ch == 'y' || Ch == 'y');
		} else {
			System.out.println("!!!................invalid user Id or Password....................!!!!");
		}
		System.out.println("<<<<<<<<<  LOGOUT COMPLETE  >>>>>>>>>>>>");
	}
}
