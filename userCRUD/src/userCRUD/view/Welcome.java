/**
 * this is the class which displays the first page of the application.
 * 
 * based on your choice, it eithers
 * ...opens the login page
 * ...opens the register page
 * or exit the application.
 * 
 * @author Tamanna Jain
 */
package userCRUD.view;

import java.util.InputMismatchException;
import userCRUD.helper.*;
import static userCRUD.utilities.ScannerUtil.scan;


public class Welcome {
	
	//INSTANCE VARIABLES
	public static Register[] regArr=new Register[50];
	int choice;

	//METHODS
	private void greetings() {
		System.out.println("WELCOME!");
	}
	void firstPage() {
		greetings();
		
		
		start:
		do {
			takeChoice();
			switch(choice) {
			case 1:Login log=new Login();
					log.loginPage();
					break;
			case 2:regArr[Register.counter]=new Register();
					regArr[Register.counter].regPage();
					break;
			case 3:System.exit(0);
			default: System.out.println("**Invalid choice**");
					break start;
			}
		}while(choice<=3);
		
	}
	void takeChoice() {
		try {
			System.out.println("\n\n******************");
			System.out.println("1. Login \n2. Register \n3. Exit");
			System.out.println("******************");
			System.out.println("\nPlease select one of the following:");
			choice=scan.nextInt();
			}
			catch(InputMismatchException e){
				scan.nextLine();
				System.out.println("\n!!! CAUTION !!!\n!!! Please enter a valid numeric choice !!!");
				takeChoice();
			}
	}
}
