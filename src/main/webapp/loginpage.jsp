<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="loginpage.css">
</head>
<body>
<form action="ln" method="post">
<table class="center">
<tr>
<td>
<input type="text" name="un" placeholder="username" id=input>
</td>
</tr>

<tr>
<td>
<input type="password" name="ps" placeholder="password" id=input>
</td>
</tr>

<tr>
<td>

<a href="regpage.html">
<input type="button" value="Register" id=inputt>
</a>

<input type="submit" value="SignIn" id=inputt>

</td>
</tr>

</table>
</form>
</body>
</html>