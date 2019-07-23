/**
 * this is the utility class.
 * it is used to display the currency and date in a formatted style,
 * according to the locale.
 * 
 * @author Tamanna Jain
 */
package userCRUD.utilities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatting {

	private Formatting(){}
	
	public static String currencyFormat(BigDecimal bd) {
		Locale locale=new Locale("hi","IN");
		NumberFormat nf=NumberFormat.getCurrencyInstance(locale);
		return nf.format(bd.doubleValue());
	}

	public static String dateFormat(String s) {
//		String retStr="";
//		if(s!=null && s.trim().length()>0) {
//				String strArr[]=s.split("/");
//				for(String word:strArr ) {
//					retStr+=word+"-";
//			}
//		}
//		return retStr.substring(0, retStr.length()-1);
		return s.replace('/', '-');
	}
}
