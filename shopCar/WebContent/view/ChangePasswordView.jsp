<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<% String path = request.getContextPath();pageContext.setAttribute("path", path); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
      body{ background-image:url("../image/2.jpg");background-repeat:repeat }
	  
	  span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
      .f{ width:150px; height:70px}
	    
	  .d{ text-align:center; word-spacing:20px;width:70%}
      img{ border:none }
	  
      td.TableBody1{background-color: #FFFFFF;line-height : normal ;}
      td.TableBody2{background-color: #E4F3FF;line-height : normal ;}
      .tableBorder1{width:97%;border: 1px; background-color: #AFB2C4;}
    </style>
  </head>
  <body>&nbsp;  
   
 <!-- Title -->
     <img src="../image/zgc_px.jpg" align="middle" class="f"/>
     <span>欢迎访问我的购物网站</span>
     <hr/>
   
   <!--  Menu Bar  -->
   <center>
   <div class="d">
     <a href="QueryProductView.jsp"><img src="../image/index.gif"/></a>
     <a href="UserManageView.jsp"><img src="../image/reg.gif"/></a>
     <a href="ShopCarView.jsp"><img src="../image/cart.gif"/></a>
     <a href=""><img src="../image/order.gif"/></a>
     <a href="LoginView.jsp"><img src="../image/exit.gif"/></a>
   </div> 
  </center>
   
   
   <form  method="post" action="${path }/view/AlterPasswordServlet">
<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
  
  <tr bgcolor="lightblue">
    <td height=25 colspan=2 align="center" valign="middle" ><font color="#ffffff"><b>输入您的原有密码,新密码</b></font></td>
  </tr>
  <input type="hidden" name="username" value="${loginMsg.username }" />
  <tr>
    <td valign="middle" class="tablebody1">请输入您的旧密码</td>
    <td valign="middle" class="tablebody1"><input name="oldPass" type="text"/></td>
     <c:if test="${loginOldPassError ne null }">
        <font color="#FF0000">*</font><label style="color: red;">${loginOldPassError}</label>
     </c:if>
  </tr>
  <tr>
    <td valign="middle" class="tablebody1">请输入您的新密码</td>
    <td valign="middle" class="tablebody1"><input name="newPass1" type="password"> &nbsp; </td>
  </tr>
    <tr>
    <td valign="middle" class="tablebody1">请再次输入您的新密码</td>
    <td valign="middle" class="tablebody1"><input name="newPass2" type="password"> &nbsp; </td>
  	 <c:if test="${loginPassError ne null }">
        <font color="#FF0000">*</font><label style="color: red;">${loginPassError}</label>
     </c:if>
  </tr>
  <tr>
    <td class="tablebody2" valign="middle" colspan=2 align=center><input type="submit" value="修改"></td>
  </tr>
</table>
</form>
   &nbsp;<br/>
   </body>
   </html>