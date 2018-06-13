<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="/style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script src="/js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="/js/commonAll.js"></script>
<script type="text/javascript" src="/js/system/permission.js"></script>
<title>PSS-账户管理</title>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="searchForm" action="/permission/query.do" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_bottom">
							<input type="button" value="加载权限" class="ui_input_btn01 btn_load" data-url="/permission/reload.do"/>
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" /></th>
							<th>编号</th>
							<th>权限表达式</th>
							<th>权限名称</th>
							<th></th>
						</tr>
						<tbody>
							<c:forEach var="entity" items="${result.data}">
								<tr>
									<td><input type="checkbox" name="IDCheck" class="acb" autocomplete="off"/></td>
									<td>${entity.id}</td>
									<td style="text-align: left;padding-left: 20px;">${entity.expression}</td>
									<td>${entity.name}</td>
									<td>
										<a href="javascript:" class="btn_delete" data-url="/permission/delete.do">删除</a>
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 分页操作 -->
				<%@ include file="/WEB-INF/views/common/common_page.jsp" %>
			</div>
		</div>
	</form>
</body>
</html>
    
