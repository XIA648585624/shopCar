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
  
    <jsp:include page="Menu.jsp"></jsp:include>
  
   
 <form  method="post" action="${path }/view/CreateUserActionServlet">
  <table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
    <tr>
      <td valign="middle" colspan="2" align="center" height="25"  bgcolor="lightblue">
        <font color="#ffffff"><b>新用户注册</b></font></td>
    </tr>

    
    <tr>
      <td width="40%" class="tablebody1"><b>用户名</b>：<br>
        注册用户名长度限制为0－16字节</td>
      <td width="60%" class="tablebody1">
        <input type="text" name="username" maxlength="16" size="32" value="" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
        <c:if test="${loginUserError ne null }">
        <font color="#FF0000">*</font><label style="color: red;">${loginUserError}</label>
        </c:if>
       
      </td>
    </tr>
    <tr>
      <td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
	请输入密码，区分大小写。<br>请不要使用任何类似 \'*\'、\' \' 或 HTML 字符'</td>
      <td width="60%" class="tablebody1">
	<input type="password" name="pass1" maxlength="8" size="32" value="" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
	<font color="#FF0000">*</font></td>
    </tr>
     <tr>
      <td width="40%" class="tablebody1"><b>请再次输入密码</b>：</td>
      <td width="60%" class="tablebody1">
	<input type="password" name="pass2" maxlength="8" size="32" value="" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
	 <c:if test="${loginPassError ne null }">
        <font color="#FF0000">*</font><label style="color: red;">${loginPassError}</label>
        </c:if>
        </td>
    </tr>
     <tr>
	<td class="tablebody1"><b>真实姓名</b>：</td>
        <td class="tablebody1">
          <input type="text" name="name" maxlength="32" size="64" value="" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
    </tr>
    <tr>
	<td class="tablebody1"><b>联系地址1</b>：</td>
        <td class="tablebody1">
          <input type="text" name="address" maxlength="32" size="64" value="" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
    </tr>
    <tr>
	<td class="tablebody1"><b>邮编</b>：</td>
        <td class="tablebody1">
          <input type="text" name="zip" maxlength="8" size="32" value="" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
        </td>
    </tr>
    <tr>
	<td class="tablebody2" valign="middle" colspan="2" align="center">
          <input type="submit" value="注 册">&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="清 除"></td>
    </tr>
  </table>
</form>
   &nbsp;<br/>
   </body>
   </html>