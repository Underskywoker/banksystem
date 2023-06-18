<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Client info</h2>
<br>

<form:form action="saveClient" modelAttribute="client">

<form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
<form:hidden path="bankAccount"/>

<input type="submit" value="Ok">


</form:form>


</body>
</html>