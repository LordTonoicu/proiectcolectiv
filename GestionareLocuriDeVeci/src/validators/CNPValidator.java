package validators;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CNPValidator {
	public CNPValidator() {
		
	}
	
	public boolean isValid(String cnp) {
		if(cnp.length() != 13){
			return false;
		}
		
		if(!hasOnlyNumbers(cnp)){
			return false;
		}
		//TODO: eroare
		/*if(!['1', '2', '3', '4', '5', '6', '9'].contains(cnp.charAt(0))) {
			return false;
		}*/
		
		if(!isValid(cnp.substring(1, 7))){
			return false;
		}
		//TODO: passControlTest e plin de erori.
		/*if(!passControlTest(cnp)){
			return false;
		}*/
		return true;
	}
	
	public boolean hasOnlyNumbers(String cnp) {
		String regula = "^[0-9]*$";
		Pattern pattern = Pattern.compile(regula);
		Matcher matcher = pattern.matcher(cnp);
		return matcher.matches();
	}
	
	public boolean isValidYYMMDD(String dateToValidate){
		SimpleDateFormat sdf = new SimpleDateFormat("yymmdd");
		sdf.setLenient(false);
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
 
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	/* TODO: fix this.
	public boolean passControlTest(String cnp){
		int[] test_key = [2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9];
		int controlSum = 0;
		for(int i=0; i<=12; i++) {
			sum += Integer.parseInt(cnp.charAt(i)) * test_key[i];
		}
		int rest = controlSum % 11;
		int controlNr = 1;
		if (rest<10){
			controlNr = rest;
		}
		
		if(Integer.parseInt(cnp.charAt(12)) == controlNr){
			return true;
		}
		return false;
	}*/
}
