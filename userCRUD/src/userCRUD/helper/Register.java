/**
 * This class is used for registration.
 * it checks userID entered by the user, 
 * if it is already present then it asks user to try something else.
 * 
 * @author Tamanna Jain
 */
package userCRUD.helper;

import static userCRUD.utilities.ScannerUtil.scan;
import userCRUD.dao.UserInfo;
import userCRUD.view.Welcome;

public class Register {
	
	//INSTANCE VARIABLES
	static public int counter=0;
	UserInfo user;
	
	//METHODS
	public void regPage() {
		user= new UserInfo();
		user.enterUserID();
		if(counter==0) {
			callEnterMethods();
			regSuccess();
		}
		else {
			if(checkID()==true) {
				callEnterMethods();
				regSuccess();
			}
			else {
				System.out.println("\n\tUserID already present...try something else");
				regPage();
			}
		}
		counter++;
	}
	private void regSuccess() {
		
		System.out.println("\n\tCONGRATULATIONS! \n\tRegisteration successful");
		System.out.println("\n\nYour Profile -:");
		user.printInfo();
	}
	private boolean checkID() {
		int c=0;
		for(int i=0;i<counter;i++) {
			if(!(user.getUserID().equals(Welcome.regArr[i].user.getUserID())) )
				c++;
		}
		if(c==counter)
			return true;
		else
			return false;
	}
	private void callEnterMethods() {
		System.out.println("enter the password:");
		user.setPassword(scan.next());
		scan.nextLine();
		System.out.println("enter the name:");
		user.setName(scan.nextLine());
		System.out.println("enter the phone number:");
		user.setPhone(scan.next());
		System.out.println("enter the email ID:");
		user.setEmail(scan.next());
		System.out.println("enter the DOB (dd/mm/yyyy) :");
		user.setDob(scan.next());
		System.out.println("enter the income:");
		user.setIncome(scan.nextBigDecimal());
	}
}
