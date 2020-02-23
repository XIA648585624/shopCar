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
     <h1> 已成功将${addSccarName }商品添加至购物车</h1>
     <h1><a href="FindPage.jsp">继续购物</a>&nbsp;&nbsp;
         <a href="ShopCarView.jsp">去购物车结算</a>
     </h1>
   </center>
 </body>
</html>