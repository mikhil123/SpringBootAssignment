package com.example.constant;

public enum ResponseCode {
	DATABASE(00, "A database error has occured."),
	USER_DOESNT_EXIST(01, "This user doesn't already exists."),
	NEW_USER_CREATED(02,"New user has been created"),
	EMIAL_ID_EXIST(03,"Email id already exists"),
	USER_DEACTIVE(04,"This user has been deactive")
	;

	  private final int code;
	  private final String description;

	  private ResponseCode(int code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public String getDescription() {
	     return description;
	  }

	  public int getCode() {
	     return code;
	  }


}
