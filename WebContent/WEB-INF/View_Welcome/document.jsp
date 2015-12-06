<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>API</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){

				var JSONObject={
						"user_id":"102",
						"username":"test",
						"password":"123",
						"first_name":"sok",
						"last_name":"lundy",
						"gender":"M",
						"dob":"2012-09-09",
						"type":"test",
						"status":"live"
				};
				
				$.ajax({
					url:'http://localhost:8080/AnimalBook/api/user/add',
					type:'post',
					contentType:"Application/json",
					data: JSON.stringify(JSONObject),
					success:function(data){
						alert(data)
					},
					error:function(data){
						alert("unsuccess");
					}
				});
	});
	
</script>
</head>
<body>
	
</body>
</html>