<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Add money</h2>
<br>
<form:form action="saveAddBill" modelAttribute="client">

    <form:hidden path="id"/>

    Write count of money: <form:input path="bankAccount"/>
<br>
    <input type="submit" value="Ok"/>

</form:form>



</body>
</html>