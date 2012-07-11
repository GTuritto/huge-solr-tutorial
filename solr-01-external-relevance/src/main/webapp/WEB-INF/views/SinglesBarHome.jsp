<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<html>
<body>
	<h1>Singles bar home</h1>
	<h2>${msg}</h2>
 	<h2><a href="http://localhost:8080/solr-search/app/reindex_bars">Click here to reindex</a></h2>
	<h2><a href="http://localhost:8080/solr-search/ajax-solr/barcore/index.html">Click here for solr-ajax</a></h2>
	<h2><a href="http://localhost:8080/solr-search/app/create">Click here to populate the index and populate solr</a></h2> 
	<h2><a href="http://localhost:8080/solr-search/console">Click here for the database console</a></h2>
	<h2><a href="http://localhost:8080/solr-search/app/search">Click here for the java search page</a></h2>
	
</body>
</html>