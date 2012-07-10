<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
 
<body>
	<h2>BarCore searcher - checkmate for finding mates</h2>
 
	<form:form method="POST" commandName="searchForm" modelAttribute="searchForm" action="search">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Restaurant Keywords :</td>
				<td><form:input path="queryText" /></td>
				<td><form:errors path="queryText" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Desired gender :</td>
				<td>
					<form:radiobutton path="gender" value="male"/>Male<br>
					<form:radiobutton path="gender" value="female"/>Female<br>
					<form:radiobutton path="gender" value="both"/>Both<br>
				</td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Sort Type</td>
				<td>
					<form:radiobutton path="sortType" value="popularity"/>Popularity<br>
					<form:radiobutton path="sortType" value="courtship"/>Courtship<br>
					<form:radiobutton path="sortType" value="gold_digger"/>Gold Digger<br>
				</td>
			</tr>
			
			<form:hidden path="pageNumber" value="${pageNumber }"/>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
 
</body>
</html>