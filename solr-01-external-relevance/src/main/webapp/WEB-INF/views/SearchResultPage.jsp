<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp"></jsp:include>
<html>

 
<body>
 	<br>
<div class="container">  
<div class="row">  
<div class="span12">  
	<h2>BarCore searcher - checkmate for finding mates</h2>
	</div>
	<div class = "span2">
	</div>
	<div class="span9">
	<form:form method="POST" commandName="searchForm" modelAttribute="searchForm" action="search">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Restaurant Keywords :</td>
				<td><form:input path="queryText" /></td>
				<td><form:errors path="queryText" cssClass="error" /></td>
				<td align="left" colspan="2"><input type="submit" /></td>
				
			</tr>
			<tr>
				<td align="right" valign="top">Desired gender :</td>
				<td align="left" valign="top">
					<form:radiobutton path="gender" value="male"/>Male<br>
					<form:radiobutton path="gender" value="female"/>Female<br>
				</td>
				<td><form:errors path="gender" cssClass="error" /></td>
				<td align="right" valign="top">Sort Type:</td>
				<td align="left">
					<form:radiobutton path="sortType" value="popularity"/>Popularity<br>
					<form:radiobutton path="sortType" value="courtship"/>Courtship<br>
					<form:radiobutton path="sortType" value="gold_digger"/>Gold Digger<br>
				</td>
			</tr>
			
			<form:hidden path="pageNumber" value="${pageNumber }"/>
			<tr>
			</tr>
		</table>
	</form:form>
	${results }
	
	</div>
	</div>
	</div>
</body>
</html>