/**
 * This class contains the personal information of users.
 * it can have maximum of 50 users
 * 
 * @author Tamanna Jain
 */
package userCRUD.dao;

import java.math.BigDecimal;
import static userCRUD.utilities.ScannerUtil.scan;
import userCRUD.utilities.*;

public class UserInfo {
	
	//INSTANCE VARIABLES
	
	private String userID,password,name,phone,email,dob;
	private BigDecimal income;
	
	//METHODS
	public void enterUserID() {
		System.out.println("\n\nenter the userID:");
		userID=scan.next();
	}
	
	public void printInfo() {
		System.out.println("\n........................");
		System.out.println("UserID: "+userID+"\nPassword: "+StringUtil.hideString(password)+"\nName: "+name+
				"\nPhone: "+phone+"\nEmail ID: "+email+"\nIncome: "+
				Formatting.currencyFormat(income)+"\nDOB: "+Formatting.dateFormat(dob));
		System.out.println("........................");
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = StringUtil.titleCase(name);
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getUserID() {
		return userID;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getDob() {
		return dob;
	}
	public BigDecimal getIncome() {
		return income;
	}
	
}
