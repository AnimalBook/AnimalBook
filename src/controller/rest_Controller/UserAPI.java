package controller.rest_Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import modal.dao.user.AddUser;
import modal.dto.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
	
		@RequestMapping(value="/add", method= RequestMethod.POST )
		public ResponseEntity<Map<String,Object>> addUser(@RequestBody Users user){
			System.out.println("cont");
			Map<String, Object> map  = new HashMap<String, Object>();
			try {
				if(new AddUser().addUser(user)==true){
					map.put("MESSAGE","USER HAS BEEN INSERTED.");
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
		
		@RequestMapping(value="/upload", method= RequestMethod.POST )
		public ResponseEntity<Map<String,Object>> uploadImage( @RequestParam("pic") MultipartFile file, HttpServletRequest request){
			Map<String, Object> map  = new HashMap<String, Object>();
			System.out.println(file.getOriginalFilename());
			if(!file.isEmpty()){
				try{
					
					String originalFilename = file.getOriginalFilename(); 
					
		            String extension = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		            
		            String filename =UUID.randomUUID()+"."+extension;
		            
		            System.out.println("Filename : " + filename);
		            
					byte[] bytes = file.getBytes();

					// creating the directory to store file
					String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/");
					System.out.println(savePath);
					
					File path = new File(savePath);
					
					if(!path.exists()){
						path.mkdir();
					}
					
					// copy the file on server
					File serverFile = new File(savePath + File.separator + filename );
					
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
					
					System.out.println(serverFile.getAbsolutePath());
					
					System.out.println("You are successfully uploaded file " + filename);
					
					map.put("MESSAGE","UPLOAD IMAGE SUCCESS");
					map.put("STATUS", HttpStatus.OK.value());
					map.put("IMAGE", request.getContextPath() + "/resources/images/" + filename);
					
					System.out.println(request.getContextPath());
					
					return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
					
				}catch(Exception e){
					System.out.println("You are failed to upload  => " + e.getMessage());
				}
			}else{
				System.err.println("File not found");
			}
			return null;
		}
		
	
}
