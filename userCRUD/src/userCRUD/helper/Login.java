/**
 * This class is used for login 
 * it asks for userID and password and if it matches , you are logged in.
 * it further provides you features like
 * ....change password
 * ....update profile
 * ....delete profile
 * 
 * @author Tamanna Jain
 */
package userCRUD.helper;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import static userCRUD.utilities.ScannerUtil.scan;
import userCRUD.view.Welcome;

public class Login {
	
	//INSTANCE VARIABLES
	int opt;
	private String id;
	private String pass;
	private int index;
	
	//CONSTRUCTOR
	public Login() {
		System.out.println("\n\nenter the userID:");
		id=scan.next();
		System.out.println("enter the password:");
		pass=scan.next();
	}
	
	//METHODS
	public void loginPage() {
		if(logCheck()==true)
			loginSuccess();
		else 
			loginFail();
	}
	
	private void loginSuccess() {
		
		System.out.println("\n\t  WELCOME "+Welcome.regArr[index].user.getName());
		
		options();
	}
	
	private void options() {
		
		start:
		do {
			takeOption();
			switch(opt) {
			case 1: changePass();
					break;
			case 2: update();
					break;
			case 3:	delete();
					break;
			case 4:	break;
			default:System.out.println("**Invalid choice**");
					break start;
			}
			if(opt==3) {
				break;
			}
		}while(opt<4);
	}
	private void takeOption()
	{
		try {
		System.out.println("\n\n******************");
		System.out.println("1. Change Password \n2. Update Profile \n3. Delete Profile \n4. Go Back");
		System.out.println("******************");
		System.out.println("\nPlease select one of the following:");
		opt=scan.nextInt();
		}
		catch(InputMismatchException e) {
			scan.nextLine();
			System.out.println("\n!!! CAUTION !!!\n!!! Please enter a valid numeric choice !!!");
			takeOption();
		}
	}
	private void delete() {
		Welcome.regArr[index]=null;
		Register.counter--;
		for(int i=index;i<Register.counter;i++) {
			Welcome.regArr[i]=Welcome.regArr[i+1];
		}
		System.out.println("\n\t***Profile deleted***");
		
	}
	
	private void changePass() {
		System.out.println("\nenter the new password:");
		pass=scan.next();
		System.out.println("Confirm password:");
		String conPass=scan.next();
		if(pass.equals(conPass)) {
			Welcome.regArr[index].user.setPassword(conPass);
			System.out.println("\n\t***Password changed***");
		}
		else 
			System.out.println("\n\tPassword doesnot match....Try again");
	}
	
	private void update() {
		int option;
		start:
		do {
		System.out.println("\n\n******************");
		System.out.println("1. Name \n2. Phone No. \n3. Email ID \n4. Income \n5. Go Back");
		System.out.println("******************");
		System.out.println("\nPlease select one of the following:");
		option=scan.nextInt();
		scan.nextLine();
		switch(option) {
		case 1: System.out.println("\nenter the new name:");
				String name=scan.nextLine();
				Welcome.regArr[index].user.setName(name);
				System.out.println("\n\t***Name changed***");
				break;
		case 2:	System.out.println("\nenter the new phone no:");
				String phone=scan.next();
				Welcome.regArr[index].user.setPhone(phone);
				System.out.println("\n\t***Phone No. changed***");
				break;
		case 3: System.out.println("\nenter the new Email ID:");
				String email=scan.next();
				Welcome.regArr[index].user.setEmail(email);
				System.out.println("\n\t***Email ID changed***");
				break;
		case 4: System.out.println("\nenter the new income:");
				BigDecimal income=scan.nextBigDecimal();
				Welcome.regArr[index].user.setIncome(income);
				System.out.println("\n\t***Income changed***");
				break;
		case 5: break;
		default:System.out.println("\n**Invalid choice**");
				break start;
		}
	}while(option<5);
		System.out.println("\n\nYour profile -:");
		Welcome.regArr[index].user.printInfo();
	}
	
	private void loginFail() {
		System.out.println("\n\tInvalid userID or Password \n\tIf not registered, then Please register first");
	}
	
	private boolean logCheck() {
		boolean flag=false;
		for(int i=0;i<Register.counter;i++) {
			if(id.equals(Welcome.regArr[i].user.getUserID()) ) {
				if(pass.equals(Welcome.regArr[i].user.getPassword())) {
					flag=true;
					index=i;
					break;
				}
				else 
					flag=false;
			}
			else
				flag=false;
		}
		return flag;
	}
}
