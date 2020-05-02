package com.CRUD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Entity.Instructor;
import com.Entity.InstructorDetail;

public class Create {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		
		try {
			String choice = "y";
			while(choice.equalsIgnoreCase("y"))
			{
				Session theSession = factory.getCurrentSession();
				System.out.println("Enter the Instructor Table information!");
				System.out.println("---------------------------------------\n");
				System.out.print("First Name: ");
				String firstName = br.readLine();
				System.out.print("Last Name: ");
				String lastName = br.readLine();
				System.out.print("Email: ");
				String email = br.readLine();
				System.out.println("\nEnter the Instructor_Detail Table information!");
				System.out.println("---------------------------------------\n");
				System.out.print("Youtube Channel: ");
				String youtubeChannle = br.readLine();
				System.out.print("Hobby: ");
				String hobby = br.readLine();
				
				Instructor theInstructor = new Instructor(firstName, lastName, email);
				InstructorDetail theInstructorDetail = new InstructorDetail(youtubeChannle, hobby);
				
				theInstructor.setInstructorDetail(theInstructorDetail);
				
				
				theSession.beginTransaction();
				theSession.save(theInstructor);
				theSession.getTransaction().commit();
				
				
				System.out.println("\nInformation Enter to Database.\nDo you want to enter more? (y/n)");
				choice = br.readLine();
				
				if (choice.equalsIgnoreCase("n"))
				{
					theSession.close();
				}
				
				
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
