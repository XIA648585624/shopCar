<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<% String path = request.getContextPath();pageContext.setAttribute("path", path); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Title -->
     <img src="../image/zgc_px.jpg" align="middle" class="f"/>
     <span>欢迎访问我的购物网站</span>
     <hr/>
	 
   <div class="c2"> 欢迎${loginMsg.name } </div>
   
  <!--  Menu Bar  -->
   <center>
   <div class="d">
     <a href="${path }/view/FindProductPageAction"><img src="../image/index.gif"/></a>
     <a href="UserManageView.jsp"><img src="../image/reg.gif"/></a>
     <a href="ShopCarView.jsp"><img src="../image/cart.gif"/></a>
     <a href=""><img src="../image/order.gif"/></a>
     <a href="${path}/view/ExitAction"><img src="../image/exit.gif"/></a>
   </div> 
  </center>
</body>
</html>