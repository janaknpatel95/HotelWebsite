<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>


<div class="container-fluid">
    <h2>Search Results: </h2>


    <table style="width:100%">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Orders</td>
        </tr>

    <c:forEach items="${users}" var="user1">

        <tr>
            <td>${user1.getId()}</td>
            <td>${user1.getFirst_name()}</td>

        <td>
        <c:forEach items="${user.orders}" var="order">
            ${order.id} ${order.description}
        </c:forEach>

            </td>
        </tr>

    </c:forEach>
    </table>
</div>

</body>
</html>
