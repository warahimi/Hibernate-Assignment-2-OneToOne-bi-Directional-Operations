package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Entity.Instructor;
import com.Entity.InstructorDetail;

public class Read {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session theSession = factory.getCurrentSession();
		
		try {
			System.out.println("Do want read data from Instructor Table ? or Instructor_Detail Table?");
			System.out.println("1. Instructor Table.\n2. Instructor_Detail Table.\nEnter your choice: ");
			int choice = input.nextInt();
			if(choice == 1)
			{	
				System.out.print("Enter the Instructor ID: ");
				int instructorID = input.nextInt();
				theSession.beginTransaction();
				Instructor reterievedInstructor = theSession.get(Instructor.class, instructorID);
				System.out.println("\nReading Data from Instructor Table:\n");
				System.out.println(reterievedInstructor);
				theSession.getTransaction().commit();
			}
			else if(choice == 2)
			{
				System.out.print("Enter the InstructorDetail ID: ");
				int instructorDetailID = input.nextInt();
				theSession.beginTransaction();
				InstructorDetail reterievedDetailInstructor = theSession.get(InstructorDetail.class, instructorDetailID);
				System.out.println("\nReading Data from InstructorDetail Table:\n");
				System.out.println(reterievedDetailInstructor);
				theSession.getTransaction().commit();
			}
				
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
