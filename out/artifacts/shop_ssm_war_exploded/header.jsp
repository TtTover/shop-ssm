<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${empty user}">
			  <li><a href="login.jsp">登录</a></li>
			  <li><a href="register.jsp">注册</a></li>
			</c:if>
			<c:if test="${!empty user}">
			  <li>欢迎<a href="user_info.jsp">${user.username}</a></li>
			  <li><a href="logout">注销</a></li>
			</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="ordersList?currentPage=1">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
				  <c:if test="${empty cid }">
					<li class="active"><a href="getAll?currentPage=1">全部商品<span class="sr-only">(current)</span></a></li>
				  </c:if>
				  <c:if test="${!empty cid }">
					<li><a href="getAll?currentPage=1">全部商品<span class="sr-only">(current)</span></a></li>
				  </c:if>
				<c:forEach items="${categoryList}" var="category">
					<c:if test="${cid==category.cid}">
					   <li class="active"><a href="getByCid?currentPage=1&cid=${category.cid}">${category.cname }</a></li>
				    </c:if>
				    <c:if test="${cid!=category.cid}">
					   <li><a href="getByCid?currentPage=1&cid=${category.cid}">${category.cname }</a></li>
				    </c:if>
				</c:forEach>
				</ul>
				<form action="searchProduct" class="navbar-form navbar-right" role="search">
					<input type="hidden" name="currentPage" value="1"/>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="输入关键字进行搜索" value="${search}" name="search">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
			</div>
		</div>
	</nav>
</div>