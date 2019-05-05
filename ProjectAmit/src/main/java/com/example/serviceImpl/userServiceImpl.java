package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.constant.ResponseCode;
import com.example.service.userService;
import com.example.util.ValErrores;
import com.example.util.Output;
import com.example.util.Users;
@Service
public class userServiceImpl implements userService {

	public static final  HashMap<Integer, Users> map = new HashMap<>(); 
	public static final  HashMap<String,Integer> emailMap = new HashMap<>();
	public static final  HashMap<Integer,Users> unactiveUser = new HashMap<>();
	
	public static  Integer userId=new Integer(0001);

	@Override
	public Output addInfoDate(Users ms) {
		Output out= new Output();
		ValErrores valErrors = new ValErrores();
		List<Object> outValueArray = new ArrayList<>();
		boolean valueChecking=false;
		
		if(emailMap.containsKey(ms.getEmail()))
		{
			out.setResMsg(ResponseCode.EMIAL_ID_EXIST.getDescription());
			out.setUserId(emailMap.get(ms.getEmail()).toString());
			valErrors.setCode(ResponseCode.EMIAL_ID_EXIST.getCode());
			outValueArray.add(valErrors);
			out.setValErrors(outValueArray);

			return out;
		}else
		{

			while(valueChecking!=true)
			{
				if(map.containsKey(userId))
				{
					userId=new Integer(userId.intValue()+1);
				}else
				{
					valueChecking=true;
					break;
				}
			}
		}
			ms.setId(userId);
			map.put(userId , ms);
			emailMap.put(ms.getEmail(),userId);
		
		out.setResMsg(ResponseCode.NEW_USER_CREATED.getDescription());
		out.setUserId(userId.toString());
		
		valErrors.setCode(ResponseCode.NEW_USER_CREATED.getCode());
		
		outValueArray.add(valErrors);
		out.setValErrors(outValueArray);
		
		return out;
	}
	@Override
	public HashMap<Integer, Users> getInfoData() {
		
		System.err.println("MAP: "+map);
		return map;
	}
	
	
	@Override
	public String updateInfoData(Users ms)
	{
		if(map.containsKey(ms.getId()))
		{
			Integer id=ms.getId();
			map.remove(ms.getId());
				ms.setId(id);
				map.put(id, ms);
				return "user updated";
			
		}else {return "No userid present";}
		
	}
	
	
	@Override
	public Output delete(Users ms) {
		Output out= new Output();
		ValErrores valErrors = new ValErrores();
		List<Object> outValueArray = new ArrayList<>();
		
		if(map.containsKey(ms.getId()))
		{
			Integer id=ms.getId();
			map.remove(ms.getId());
			ms.setId(id);
			unactiveUser.put(id, ms);
			out.setResMsg(ResponseCode.USER_DEACTIVE.getDescription());
			out.setUserId(userId.toString());
			
			valErrors.setCode(ResponseCode.USER_DEACTIVE.getCode());
			outValueArray.add(valErrors);
			out.setValErrors(outValueArray);
				return out;
			
		}
		else {
			out.setResMsg(ResponseCode.USER_DOESNT_EXIST.getDescription());
			out.setUserId(userId.toString());
			valErrors.setCode(ResponseCode.USER_DOESNT_EXIST.getCode());
			outValueArray.add(valErrors);
			out.setValErrors(outValueArray);
			return out;
		}

	}
}

