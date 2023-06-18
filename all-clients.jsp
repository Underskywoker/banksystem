<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Clients</h2>
<br><br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Bank Account</th>
        <th>Operations</th>
    </tr>
    <c:forEach var ="client" items="${allClients}">
        <c:url var = "addButton" value="/accountReplenishment">
            <c:param name ="clientId" value="${client.id}"/>

        </c:url>
        <c:url var = "minusButton" value="/withdraw">
            <c:param name ="clientId" value="${client.id}"/>
        </c:url>


        <c:url var = "updateButton" value="/updateClient">
            <c:param name ="clientId" value="${client.id}"/>

        </c:url>
        <c:url var = "deleteButton" value="/deleteClient">
            <c:param name ="clientId" value="${client.id}"/>

        </c:url>

        <tr>
            <td>${client.name}</td>
            <td>${client.surname}</td>
            <td>${client.bankAccount}</td>
            <td>
                <input type="button" value="+"
                       onclick="window.location.href='${addButton}'"/>

                <input type="button" value="-"
                       onclick="window.location.href='${minusButton}'"/>
                <input type="button" value="update"
                        onclick="window.location.href='${updateButton}'">
                <input type="button" value="delete"
                        onclick="window.location.href='${deleteButton}'">
            </td>
        </tr>
    </c:forEach>

</table>
<br>

<input type="button" value="Add"
       onclick="window.location.href = 'addNewClient'"/>


</body>
</html>