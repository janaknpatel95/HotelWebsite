<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>




<%--<div class="container-fluid">--%>
<%--    <h2>Search Results: </h2>--%>


<%--    <table style="width:10">--%>
<%--        <tr>--%>
<%--            <td>ID</td>--%>
<%--            <td>Name</td>--%>
<%--            <td>Orders</td>--%>
<%--        </tr>--%>

    <c:forEach items="${apis}" var="user1">



        <h1>${user1}</h1>h1>




        </c:forEach>

<%--            </td>--%>
<%--        </tr>--%>

<%--    </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>

</body>
</html>
