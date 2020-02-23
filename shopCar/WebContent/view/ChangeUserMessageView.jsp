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
   
   
 <form  method="post" action="${path }/view/AlterUserInforServlet">
  <table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
    <tr>
      <td valign="middle" colspan="2" align="center" height="25" bgcolor="lightblue">
        <font color="#ffffff"><b>修改用户信息</b></font></td>
    </tr>

    
    <tr>
      <td width="40%" class="tablebody1"><b>用户名</b>：</td>
      <td width="60%" class="tablebody1">
        <input type="text" name="username" maxlength="16" size="32" value="${loginMsg.username }" 
              style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"  readonly>
      </td>
    </tr>
    <tr>
      <td width="40%" class="tablebody1"><b>密码</b>:</td>
      <td width="60%" class="tablebody1">
	<input type="text" name="password"  size="32" value="${loginMsg.password }"
	          style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000" readonly></td>
    </tr>
     <tr>
	<td class="tablebody1"><b>真实姓名</b>：</td>
        <td class="tablebody1">
          <input type="text" name="name" maxlength="32" size="64" placeholder="${loginMsg.name }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
    </tr>
    <tr>
	<td class="tablebody1"><b>联系地址</b>：</td>
        <td class="tablebody1">
          <input type="text" name="address" maxlength="32" size="64" placeholder="${loginMsg.address }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
    </tr>
    <tr>
	<td class="tablebody1"><b>邮编</b>：</td>
        <td class="tablebody1">
          <input type="text" name="zip" maxlength="8" size="32" placeholder="${loginMsg.zip }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
        </td>
    </tr>
    <tr>
	<td class="tablebody2" valign="middle" colspan="2" align="center">
          <input type="submit" value="修改"></td>
    </tr>
  </table>
</form>
   &nbsp;<br/>
   </body>
   </html>