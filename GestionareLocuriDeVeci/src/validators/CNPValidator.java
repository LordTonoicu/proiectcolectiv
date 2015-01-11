package validators;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CNPValidator {
	public CNPValidator() {
		
	}
	
	public String[] valid_first_numbers = {"1", "2", "3", "4", "5", "6", "9"};
	
	public int isValid(String cnp) {
		if(cnp.length() != 13){
			return 1;
		}
		
		if(!hasOnlyNumbers(cnp)){
			return 2;
		}
		
		List <String> list_valid_first_numbers = Arrays.asList(valid_first_numbers);  
		if(!list_valid_first_numbers.contains(String.valueOf(cnp.charAt(0)))) {
			return 3;
		}
		
		if(!isValidYYMMDD(cnp.substring(1, 7))){
			return 4;
		}
		
		if(!passControlTest(cnp)){
			return 5;
		}
		return 6;
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
	
	public boolean passControlTest(String cnp){
		List<Integer> test_keys = new ArrayList<Integer>();
		test_keys.add(2);
		test_keys.add(7);
		test_keys.add(9);
		test_keys.add(1);
		test_keys.add(4);
		test_keys.add(6);
		test_keys.add(3);
		test_keys.add(5);
		test_keys.add(8);
		test_keys.add(2);
		test_keys.add(7);
		test_keys.add(9);
		int controlSum = 0;
		for(int i=0; i<12; i++) {
			controlSum += Integer.parseInt(String.valueOf(cnp.charAt(i))) * test_keys.get(i);
		}
		int rest = controlSum % 11;
		int controlNr = 1;
		if (rest<10){
			controlNr = rest;
		}
		
		if(Integer.parseInt(String.valueOf(cnp.charAt(12))) == controlNr){
			return true;
		}
		return false;
	}
}
