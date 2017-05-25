package com.designhub.fitnessplus.util;

public class ValidationUtils 
{
	public static boolean isEmpty(String param)
	{
		boolean isEmpty = false;
		if(param=="" || param.trim().length()<=0)
		{
			isEmpty = true;	
		}
		return isEmpty;
	}
	public static boolean equalcmd(String param) {
		boolean iseql=false;
		if(param.equals("-- Select Any One --"))
		{
			iseql=true;
		}
		return iseql;
	}
	
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

	
}
