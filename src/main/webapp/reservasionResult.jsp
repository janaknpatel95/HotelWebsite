<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>


<style type="text/css">
    table.table td a.add {
        color: #27C46B;
    }
    table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #E34724;
    }
    table.table td i {
        font-size: 19px;
    }
</style>
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
        <th>Action</th>
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
            <td><a class='add' title="Add" data-toggle="tooltip" href="editUser.jsp"><i class="material-icons" >&#xe146;</i></a>
                <a class="edit" title="Edit" data-toggle="tooltip" href="editUser?id=${user1.getId()}"><i class="material-icons" >&#xE254;</i></a>
                <a class="delete" title="Delete" data-toggle="tooltip" href="deleteUser?id=${user1.getId()}"><i class="material-icons" >&#xE872;</i></a></td>
        </c:forEach>


        </tr>

    </c:forEach>
    </table>
</div>

</body>
</html>
