package com.example.constant;

public enum MonthCode {
January("Jan") ,
February("Feb") , 
March("Mar") ,
April("Apr") ,
May("May") ,
June("Jun") , 
July("Jul") ,
August("Aug") , 
September("Sep") ,
October("Oct") ,
November("Nov") ,
December("Dec");
	
private final String month;

private MonthCode(String month) {
	this.month = month;
}

public String getMonth() {
	return month;
}

}
