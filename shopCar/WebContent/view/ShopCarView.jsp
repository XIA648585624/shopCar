<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<% String path = request.getContextPath();pageContext.setAttribute("path", path); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <script src="../js/shopcar.js"></script>
	   <style type="text/css">
         body{ background-image:url("../image/2.jpg");background-repeat:repeat }
		 
		 span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
      .f{ width:150px; height:70px}
	  
	  .d{ text-align:center; word-spacing:20px;width:70%}
      img{ border:none }
	  
      </style>
  </head>
  <body>&nbsp;  
     <jsp:include page="Menu.jsp"></jsp:include>
  
	<!-- AlterCarAction -->
     <form action="${path }/view/AlterCarActionForDelServlet" method="post">
  	 <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
  		<tbody id="tbody">
  			<tr bgcolor="lightblue" align="center">
  			    <td><b>&nbsp;</b></td>
  				<td><b>商品编号</b></td>
  				<td><b>商品名称</b></td>
				<td><b>图片</b></td>
  				<td><b>商品单价</b></td>
  				<td><b>数量</b></td>
  				<td><b>总价</b></td>
  				<td><b>删除</b></td>
  			</tr>
			
  			<c:forEach items="${cars }" var="p">
  				<tr onmouseover="over(this);" onmouseout="out(this);" align="center">
  			  <td><input type="checkbox" name="item1"/><input type="hidden" name="oncarId" value="${p.key}"></td>
  	          <td>${p.key}</td>
  	          <td>${p.value.pname }</td>
		       <td><img src="${p.value.picpath }"/></td>
  	           <td>${p.value.price }</td><td>
  	      	    <input type="button" value="-" onclick="sub(this);"/><input type="text" value="${p.value.pronum }" size="1" maxlength="1" name="pronum"/><input type="button" value="+" onclick="add(this);"/>
  	          </td><td>${p.value.price*p.value.pronum }</td>
  	          <td><input type="button" value="delete" onclick="delRow(this);"/></td>
  	        </tr>
  			</c:forEach>
  	    
  	      <tr align="center">
  	          <td colspan="7">
  	              <input type="button" value="选中所有行" onclick="selectAll();"/>
  		          <input type="button" value="取消选中" onclick="quxiao();"/>
  		          <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
  	          </td>
  	      </tr>
  		</tbody>
  	</table>
  	<center><p><input type="submit" value="提交修改"/></p></center>
  	</form>
  	<center>
  	    <hr/>
  	    <a href="">提交订单</a>
  	</center>
  	<!--  回收站-->
  	<form action="${path }/view/AlterCarForBackAction" method="post" name="temp">
  	 <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
  		<tbody id="tbody2">
  			<tr bgcolor="lightblue" align="center">
  			    <td><b>&nbsp;</b></td>
  				<td><b>商品编号</b></td>
  				<td><b>商品名称</b></td>
				<td><b>图片</b></td>
  				<td><b>商品单价</b></td>
  				<td><b>数量</b></td>
  				<td><b>总价</b></td>
  				<td><b>删除</b></td>
  			</tr>
			
  			<c:forEach items="${oldcars }" var="p">
  				<tr onmouseover="over(this);" onmouseout="out(this);" align="center">
  			  <td><input type="checkbox" name="item2"/><input type="hidden" name="oncarIddel" value="${p.key}"></td>
  	          <td>${p.key}</td>
  	          <td>${p.value.pname }</td>
		       <td><img src="${p.value.picpath }"/></td>
  	           <td>${p.value.price }</td><td>
  	      	    <input type="button" value="-" onclick="sub(this);"/><input type="text" value="${p.value.pronum }" size="1" maxlength="1" name="pronum"/><input type="button" value="+" onclick="add(this);"/>
  	          </td><td>${p.value.price*p.value.pronum }</td>
  	          <td><input type="button" value="delete" onclick="delRows(this);"/></td>
  	        </tr>
  			</c:forEach>
  	    
  	      <tr align="center">
  	          <td colspan="7">
  	              <input type="button" value="选中所有行" onclick="selectAll2();"/>
  		          <input type="button" value="取消选中" onclick="quxiao2();"/>
  		          <input type="button" value="删除选中的行" onclick="deleteSelected2();"/>
  	          </td>
  	      </tr>
  		</tbody>
  	</table>
  	<center><<p><input type="submit" value="提交修改"/></p></center>
  	</form>
  </body>
</html>