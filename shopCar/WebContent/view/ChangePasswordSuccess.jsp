<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
      body{ background-image:url("../image/2.jpg");background-repeat:repeat }
    </style>
  </head>
  <body>&nbsp;  
   <center>
     <img src="../image/success.gif"/>
     <h1> 密码修改成功,您的新密码为${changeMsg }</h1>
     <h1><a href="QueryProductView.jsp">返回首页</a>&nbsp;&nbsp;
     </h1>
   </center>
 </body>
</html>