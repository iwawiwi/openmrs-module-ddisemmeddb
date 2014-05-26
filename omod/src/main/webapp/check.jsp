<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<!-- <form name="formCheckDDI" method="POST" action="check.form"> -->
<!-- 	<label for="drug1">Drug 1</label><input id="drug1" name="drug1" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 2</label><input id="drug2" name="drug2" type="text" /><br /> -->
	
<!-- 	<input type="submit" value="Check DDI" /> -->
<!-- </form> -->

<p>${message}</p>

<h2>Potential DDI found</h2>

<c:forEach var="object" items="${results}">
	<li>
    	${object.s_name}
    </li>
</c:forEach>

<%@ include file="/WEB-INF/template/footer.jsp"%>