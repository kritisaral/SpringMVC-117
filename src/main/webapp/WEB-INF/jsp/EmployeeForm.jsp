<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Employee</h1>
<form:form method="post" action="saveEmp">
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<td>Id :</td>
			<td><form:input type="text" path="id" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input type="text" path="name" /></td>
		</tr>
		<tr>
			<td>Age :</td>
			<td><form:input type="text" path="age" /></td>
		</tr>
		<tr>
			<td>Department :</td>
			<td><form:input type="text" path="dept" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input class="btn btn-primary btn-sm" type="submit"
				value="Submit" /></td>
		</tr>
	</table>
</form:form>
