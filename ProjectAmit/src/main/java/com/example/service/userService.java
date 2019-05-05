package com.example.service;

import java.math.BigInteger;
import java.util.HashMap;

import com.example.util.Output;
import com.example.util.Users;

public interface userService {
	public Output addInfoDate(Users ms);
	public HashMap<Integer, Users> getInfoData() ;
	String updateInfoData(Users ms);
	public Output delete(Users ms);
	
}
