package controller;

import java.util.HashMap;
import java.util.Map;

import modal.dao.user.AddUser;
import modal.dto.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
	
		@RequestMapping("/add")
		public ResponseEntity<Map<String,Object>> addUser(@RequestBody Users user){
			
			Map<String, Object> map  = new HashMap<String, Object>();
			try {
				if(new AddUser().addUser(user)==true){
					map.put("MESSAGE","ARTICLE HAS BEEN INSERTED.");
					map.put("STATUS", HttpStatus.OK.value());
				}else{
					map.put("MESSAGE","INSERT FAILS.");
					map.put("STATUS", HttpStatus.NOT_FOUND.value());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		}
	
}
