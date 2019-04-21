<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/16/19
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>User`s accounts</title>
</head>
<body>
<!-- Navigation -->
<jsp:include page="../include/adminHeader.jsp"/>
<div class="col card">
    <table class="table">
        <tr>
            <th><c:out value="id credit"/></th>
            <th><c:out value="id account"/></th>
            <th><c:out value="credit money"/></th>
            <th><c:out value="approved"/></th>
            <th><c:out value="rejected"/> </th>
        </tr>

        <c:forEach var="credit" items="${requestScope.credits}">
            <tr>
                <td><c:out value="${credit.idCred}"/></td>
                    <td><c:out value="${credit.account}"/></td>
                    <td><c:out value="${credit.money}"/> </td>
                    <td>
                        <c:if test="${credit.approved eq true and credit.rejected eq false}">
                            <c:out value="+"/>
                        </c:if>
                        <c:if test="${credit.approved eq false and credit.rejected eq false}">
                            <form name="approvedForm"
                                  action="${pageContext.request.contextPath}/bank/admin/approveCredit"
                                  method="post">
                                <input type="hidden" name="idCredAppr" value="${credit.idCred}" />
                                <button type="submit" class="btn btn-success">approve</button>
                            </form>

                        </c:if>
                    </td>
                    <td>
                        <c:if test="${credit.rejected eq true }">
                            <c:out value="+"/>
                        </c:if>
                        <c:if test="${credit.rejected eq false and credit.approved eq false}">
                            <form name="rejectedForm"
                                  action="${pageContext.request.contextPath}/bank/admin/rejectCredit"
                                  method="post">
                                <input type="hidden" name="idCredRej" value="${credit.idCred}" />
                                <button type="submit" class="btn btn-success">reject</button>
                            </form>
                        </c:if>
                    </td>
            </tr>
        </c:forEach>

    </table>

</div>


</body>
</html>