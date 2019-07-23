/**
 * This is the utility class.
 * this is used to format the way in which strings are displayed.
 * 
 * it contains methods like titleCase, which displays the string in titleCase format.
 * and hideString which replaces each character in the string with a *.
 * 
 *@author Tamanna Jain
 */
package userCRUD.utilities;

public class StringUtil {
	
	private StringUtil() {}
	
	public static String titleCase(String s) {
		String retStr="";
		if(s!=null && s.trim().length()>0) {
				String strArr[]=s.split(" ");
				for(String word:strArr ) {
					retStr+=String.valueOf(word.charAt(0)).toUpperCase()+word.substring(1).toLowerCase()+" ";
				}
		}
		
		return retStr;
	}
	
	public static String hideString(String s) {
		String retStr="";
		for(int i=0;i<s.length();i++)
			retStr+="*";
		return retStr;
	}
}
