<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
		<div>

		<div>
			<div class="container col-sm-4" style="width: 100%">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">

						
						<div class="panel-heading">
							<h4 class="panel-title">Upload Images</h4>
						</div>
		
			<form method="post" enctype="multipart/form-data" action="multipleSave">
				Upload File 1: <input type="file" name="file" class="form-control"> <br/>
				Upload File 2: <input type="file" name="file" class="form-control"> <br/>
				Upload File 3: <input type="file" name="file" class="form-control"> <br/>
				Upload File 4: <input type="file" name="file" class="form-control"> <br/>
				<br /><br /><input type="submit" value="Upload"> 
			</form>
			</div>
			</div>
			</div>
			</div>
			</div>
</body>
</html>