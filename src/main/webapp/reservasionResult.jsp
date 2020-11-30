<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>


<div class="container-fluid">
    <h2>Search Results: </h2>


    <table id="userTable" class="display" cellspacing="0" width="100%">
    <th>Name</th>
    <th>Last Name</th>
    <th>Emaail</th>
    <th>phone</th>
        <th>Start Date</th>
        <th>End Date</th>
<%--    <a href ="ApiSearch.jsp">Please go back to login page to login </a>--%>
    <c:forEach items="${users}" var="user1">

        <tr>
            <td>${user1.getFirst_name()}</td>
            <td>${user1.getLast_name()}</td>
            <td>${user1.getEmail()}</td>
            <td>${user1.getPhone()}</td>


        <c:forEach items="${user1.reservations}" var="reservasion">
            <td>${reservasion.getStart_date()}</td>
           <td>${reservasion.getEnd_date()}</td>
        </c:forEach>


        </tr>

    </c:forEach>
    </table>
</div>

</body>
</html>
