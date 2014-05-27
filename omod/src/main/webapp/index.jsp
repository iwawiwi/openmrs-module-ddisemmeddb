<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<!-- <c:url var="url" value="check.form" /> -->
<%-- <form name="formCheckDDI" method="POST" action="${url}"> --%>
<!-- 	<label for="drug1">Drug 1</label><input id="drug1" name="drug1" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 2</label><input id="drug2" name="drug2" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 3</label><input id="drug3" name="drug3" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 4</label><input id="drug4" name="drug4" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 5</label><input id="drug5" name="drug5" type="text" /><br /> -->
<!-- 	<label for="drug2">Drug 6</label><input id="drug6" name="drug6" type="text" /><br /> -->
	
<!-- 	<input type="submit" value="Check DDI" /> -->
<!-- </form> -->

<b class="boxHeader">Patient List</b>

<div class="box">
	<table cellpadding="5" cellspacing="0">
		<thead>
			<tr>
				<th>Patient ID</th>
				<th>Patient Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="object" items="${patients}">
			<tr>
				<td valign="top">${object.id}</td>
				<td valign="top">${object.personName}</td>
				<td valign="top"><a href="add.form?patientId=${object.id}">Add Medication List</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
<!-- 	<input type="submit" value="Check Interactions" /> -->
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>