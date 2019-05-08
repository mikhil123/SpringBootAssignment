package com.example.controller;

import java.util.HashMap;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.MonthCode;
import com.example.service.userService;
import com.example.util.Month;
import com.example.util.Output;
import com.example.util.Users;

@RestController
public class UserController {
	@Autowired
	private userService userService;
	
	@PostMapping("/dataPost")
	@ResponseBody
	public ResponseEntity<?> addPostData(@RequestBody Users input) {

		
		Output out = userService.addInfoDate(input);
		return ResponseEntity.ok(out);
		
	}
	@GetMapping("/getData")
	public ResponseEntity<?> getPostData() {
		
		HashMap<Integer, Users> mer= userService.getInfoData();
		return ResponseEntity.ok(mer);
		
	}
	@PostMapping("/updatePost")
	@ResponseBody
	public ResponseEntity<?> updatePostData(@RequestBody Users input) {

		String out = userService.updateInfoData(input);
		
		return ResponseEntity.ok(out);
		
	}
	@PostMapping("/deleteId")
	@ResponseBody
	public ResponseEntity<?> deletePostData(@RequestBody Users input) {

		Output out = userService.delete(input);
		
		return ResponseEntity.ok(out);
		
	}
	@GetMapping("/getMonth")
	public ResponseEntity<?> getMonthData(@RequestBody Month input) {
		
		HashMap<String,Users> mer= userService.getMonthDate(input);
		return ResponseEntity.ok(mer);
		
	}
}
