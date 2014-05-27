<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> --%>

<!-- <form name="formCheckDDI" method="POST" action="check.form"> -->
<!-- 	<label for="drug1">Drug 1</label><input id="drug1" name="drug1" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 2</label><input id="drug2" name="drug2" type="text" /><br /> -->
	
<!-- 	<input type="submit" value="Check DDI" /> -->
<!-- </form> -->

<div id="openmrs_msg">${message}</div>

<b class="boxHeader">Medication List</b>
<div class="box">
	<ul>
		<c:forEach var="object" items="${drugList}">
		<c:if test="${not empty object}">
			<li><b>${object}</b></li>
		</c:if>
		</c:forEach>
	</ul>
</div>
		

<c:choose>
	<c:when test="${fn:length(results) != 0}">
		<b class="boxHeader">Potential DDI found</b>
		<div class="box">
			<ul>
			<c:forEach var="object" items="${results}">
				<li>
			    	<b>${object.drug1}</b> -- <i>${object.predicate1}</i> -- <b>${object.geneName}</b> -- 
			    	<i>${object.predicate2}</i> -- <b>${object.drug2}</b><br/>
			    	<a href="${object.urlCheck}">check PubMed</a>
			    </li>
			</c:forEach>
			</ul>
			
			<a href="add.form?patientId=${patientId}">Correct entry</a>
		</div>
	</c:when>
	<c:otherwise>
			<a href="add.form?patientId=${patientId}">Correct entry</a>
			<a href="index.form">Save Data</a>
		</c:otherwise>
</c:choose>

<%@ include file="/WEB-INF/template/footer.jsp"%>