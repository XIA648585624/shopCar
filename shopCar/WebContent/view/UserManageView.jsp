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
	  
      .tableBorder1{width:97%;border: 1px; background-color: #AFB2C4;}
      td.TableBody2{background-color: #E4F3FF;line-height : normal ;}
    </style>
  </head>
  <body>&nbsp; 
  
    <jsp:include page="Menu.jsp"></jsp:include>
  
  <!-- 正文 -->
  <table width="100%"  height="300" align="center" cellpadding="3" cellspacing="1" class="tableborder1" >
  <tr>
    <td width="100%" height="25" align="center" valign="middle" bgcolor="lightblue">
      <font color="#ffffff"><b>用户管理</b></font></td>
    </tr>
    <tr>

    <td class="tablebody2" valign="middle" align="center">
      <table width="163" border="0" align="center">
        <tr>
          <td height="30" align="center"><a href="CreateUserView.jsp">用户注册</a></td>
        </tr>
        <tr>
          <td height="30" align="center"><a href="LoginView.jsp">用户登录</a></td>
        </tr>
        <tr>
          <td height="30" align="center"><a href="ChangePasswordView.jsp">修改密码</a></td>
        </tr>
         <tr>
          <td height="30" align="center"><a href="ChangeUserMessageView.jsp">修改个人信息</a></td>
        </tr>
      </table>

    </td>
    </tr>
  </table>
  </body>
</html>
