<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<!-- <form name="formCheckDDI" method="POST" action="check.form"> -->
<!-- 	<label for="drug1">Drug 1</label><input id="drug1" name="drug1" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 2</label><input id="drug2" name="drug2" type="text" /><br /> -->
	
<!-- 	<input type="submit" value="Check DDI" /> -->
<!-- </form> -->

<p>${messageControl}</p>

<h2>Potential DDI found</h2>

<ul>
<c:forEach var="object" items="${results}">
	<li>
    	<b>${object.drug1}</b> -- <i>${object.predicate1}</i> -- <b>${object.geneName}</b> -- 
    	<i>${object.predicate2}</i> -- <b>${object.drug2}</b><br/>
    	<a href="${object.urlCheck}">check PubMed</a>
    </li>
</c:forEach>
</ul>

<a href="index.form">Correct entry</a>

<%@ include file="/WEB-INF/template/footer.jsp"%>