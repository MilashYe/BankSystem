
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/16/19
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Statistic</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message" />

</head>
<body>
<!-- Navigation -->
<jsp:include page="../include/adminHeader.jsp"/>
    <div class="col">
        <div class="card row">
            <p class="card-title">Change time</p>
            <table class="table table-hover table-30">
                <tr>
                    <th>Account number</th>
                    <th>Change time</th>
                    <th>Message info</th>

                </tr>
                <c:forEach var="time" items="${times}">
                    <tr>
                        <td>
                            <c:out value="${time.acId}"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${time.changeTime}" dateStyle="full" type="both" />

                        </td>
                        <td>
                            <c:out value="${time.message}"/>
                        </td>

                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
