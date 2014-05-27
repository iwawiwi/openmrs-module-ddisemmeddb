<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<!-- <b class="boxHeader"><spring:message code="module.patientinfo" /></b> -->
<!-- <div class="box"> -->
<!-- 	<table> -->
	
<!-- 	</table> -->
<!-- </div> -->

<div id="patientHeader" class="boxHeader">
<div id="patientHeaderPatientName">${patient.personName}</div>
<div id="patientHeaderPreferredIdentifier">		
<!-- 	<span class="patientHeaderPatientIdentifier"><span id="patientHeaderPatientIdentifierType"><spring:message code="ddisemmeddb.patientId"/>: -->
	<span class="patientHeaderPatientIdentifier"><span id="patientHeaderPatientIdentifierType">Patient ID:
	</span>${patient.patientId}</span>
</div>
<table id="patientHeaderGeneralInfo">
	<tbody>
	<tr class="patientHeaderGeneralInfoRow">
		<td id="patientHeaderPatientGender">
			<img src="/openmrs/images/male.gif" alt="Pria" id="maleGenderIcon">
		</td>
		<td id="patientHeaderPatientAge">Age: ${patient.age} 
			  <span id="patientHeaderPatientBirthdate">(${patient.birthdate})</span>
		</td>
	</tr>
	</tbody>
	</table>
</div>
<br />
<b class="boxHeader">Input Medication List</b>

<div class="box">
	<c:url var="url" value="check.form" />
	<form name="formCheckDDI" method="POST" action="${url}">
<%-- 		<input type="hidden" name="patientId" value="${patientId}" /> --%>
		<table cellpadding="5" cellspacing="0">
			<tbody>
				<tr>
					<td valign="top"><label for="drug1">Drug 1</label></td>
					<td valign="top"><input id="drug1" name="drug1" type="text" /></td>
				</tr>
				<tr>
					<td valign="top"><label for="drug2">Drug 2</label></td>
					<td valign="top"><input id="drug2" name="drug2" type="text" /></td>
				</tr>
				<tr>
					<td valign="top"><label for="drug3">Drug 3</label></td>
					<td valign="top"><input id="drug3" name="drug3" type="text" /></td>
				</tr>
				<tr>
					<td valign="top"><label for="drug4">Drug 4</label></td>
					<td valign="top"><input id="drug4" name="drug4" type="text" /></td>
				</tr>
				<tr>
					<td valign="top"><label for="drug5">Drug 5</label></td>
					<td valign="top"><input id="drug5" name="drug5" type="text" /></td>
				</tr>
				<tr>
					<td valign="top"><label for="drug6">Drug 6</label></td>
					<td valign="top"><input id="drug6" name="drug6" type="text" /></td>
				</tr>
			</tbody>
		</table>
		
		<input type="submit" value="Check Interactions" />
		<br />
		<a href="index.form">Back to patient list</a>
	</form>
</div>

<%-- <p>${message}</p> --%>

<%-- <form action="#" th:action="@{/module/ddisemmeddb/check}" th:object="${drugs} meth"od="post"> --%>
	
<!-- </form> -->

<%@ include file="/WEB-INF/template/footer.jsp"%>
