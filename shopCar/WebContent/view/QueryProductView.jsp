<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,henu.rjxy.xmh.bean.Product" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<% String path = request.getContextPath();pageContext.setAttribute("path", path); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
      .c1{ text-align:right ;margin-right:50px }
      .c2{ text-align:right ;margin-right:50px ; color:blue; font-size:150% }
      body{ background-image:url("../image/2.jpg");background-repeat:repeat }
	  
	  span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
      .f{ width:150px; height:70px}
	  
	  
	  .d{ text-align:center; word-spacing:20px;width:70%}
      img{ border:none }
	  
	  
	  .b{ background-color:yellow;
          background-image:url("../image/button12.gif") ;
          width:60px;height:30px; border:none
         }
	  
    </style>
  </head>
  <body>&nbsp;  
    
  <jsp:include page="Menu.jsp"></jsp:include>
  
   <!--  按条件搜索表单 -->
   <center>
  <form action="${path }/view/QueryJudgeServlet" method="post">
   ProductName:<input type="text" name="productName"/>&nbsp;
   Price:<select name="opt">
                 <option value="1">小于</option>
                <option value="2">大于</option>
         </select>
         <input type="text" name="price" size="6" /> &nbsp;&nbsp;
    <input type="submit"   value="" class="b"/>
  </form>
  </center>
   
   <table border="1" bordercolor="blue" cellspacing=0 align="center" width="70%">
     <tr align="center" bgcolor="lightblue">
       <td><b>Id</b></td>
        <td><b>Name</b></td>
		<td><b>图片</b></td>
         <td><b>Price</b></td>
        <td><b><img src="../image/car_new.gif"/></b></td>
     </tr>
     	
        <c:forEach items="${sessionScope.pros}" var="p">
        <form action="${path }/view/AddCarActionServlet" method="get">
        <tr align="center" bgcolor="lightblue">
       	<td><b>${p.id }</b></td>
        <td><b>${p.productname }</b></td>
        <td><b><img src="${path }${p.picpath}"/></b></td>
		<td><b>${p.price }</b></td>
          <td><b><a href="${path }/view/AddCarActionServlet?carId=${p.id}&carPname=${p.productname}&carPath=${path }${p.picpath}&carPrice=${p.price }">
          <img src="../image/car_new.gif"/></a></b></td>
     	</tr>
   	 	</form>
        </c:forEach>
   
   </table>
   <p>&nbsp;</p>
   
   <!-- 分页 --> 
   <center>
     <a href="">上一页</a>
    &nbsp;
    这是第 <font color="red">2</font> 页
    &nbsp;
   
    <a href="">下一页</a>
    &nbsp;
    
</center>
   
  </body>
</html>