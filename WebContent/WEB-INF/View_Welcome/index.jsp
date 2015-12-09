<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/resources/assets/css/index.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Project name</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Home</a>
                        </li>
                        <li>
                            <a href="#about">About</a>
                        </li>
                        <li>
                            <a href="#contact">Contact</a>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 style="display: block;">Post</h3> 
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"> 
                    <p class="p1"><span class="s1">Documentation for "POST"</span></p> 
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table"> 
                        <tbody> 
                            <tr style="display: table-row;"> 
                                <td>URL :&nbsp;/api/user/hrd_r001
                                    <br>
                                </td>                                 
                            </tr>                             
                            <tr style="display: table-row;"> 
                                <td>Service name :&nbsp;Retrieve all user
                                    <br>
                                </td>                                 
                            </tr>                             
                            <tr style="display: table-row;"> 
                                <td>Method :&nbsp;POST
                                    <br>
                                </td>                                 
                            </tr>                             
                        </tbody>
                    </table>                     
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <textarea class="form-control" rows="13" id="addapi-user"></textarea>                     
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button type="button" class="btn btn-default" onclick="useradd_api()">Submit</button>                                          
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <textarea class="form-control" rows="13" id="Displayapi-user"></textarea>                                          
                    
                </div>
            </div>
            <footer style="Height : 30px;">
			       
   			 </footer>
        </div>
        <!-- /.container -->
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/resources/assets/js/ie10-viewport-bug-workaround.js"></script>
        
        
        <!--api script ajax-->
        <script type="text/javascript">
	$(document).ready(function(){		
		
				var defultJsonLoad={
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
				//format var defultJsonLoad to json format for add to textarea that have id addapi-user
				//do like this because if add this variable to textarea it just indicate only object 
				$("#addapi-user").text(JSON.stringify(defultJsonLoad, null, 4));
				//$("#Displayapi-user").text(JSON.stringify(i,null, 4));
				
				
	});
	function useradd_api(){
		//get from textarea format to JSON , because get from textarea not json format
		var i =$.parseJSON($("#addapi-user").val());
		
		 $.ajax({
			url:'http://localhost:8080/AnimalBook/api/user/add',
			type:'post',
			contentType:"Application/json",
			data: JSON.stringify(i),
			success:function(data){
				alert(data.MESSAGE);
			},
			error:function(data){
				alert("unsuccess");
			}	
		});
	}
	
</script>
        
        <!--end api script ajax-->
        
        
    </body>
</html>
