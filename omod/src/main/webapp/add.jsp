<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

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
	</form>
</div>

<%-- <p>${message}</p> --%>

<%-- <form action="#" th:action="@{/module/ddisemmeddb/check}" th:object="${drugs} meth"od="post"> --%>
	
<!-- </form> -->

<%@ include file="/WEB-INF/template/footer.jsp"%>
