<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/14/19
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Bank transfer</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
    <jsp:include page="../include/userHeader.jsp"/>
    <form name="transferForm" action="${pageContext.request.contextPath}/bank/user/doTransfer" method="post">
        <table>
            <tr>
                <th>from account</th>
                <th>to account</th>
            </tr>
            <tr>
                <td>
                    <select name="account1">
                        <c:forEach var="account" items="${sessionScope.user.accounts}">
                            <option value="${account.id}"><c:out value="account ${account.id}"/> </option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="account2">
                        <c:forEach var="account" items="${sessionScope.user.accounts}">
                            <option value="${account.id}"><c:out value="account ${account.id}"/> </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <p>
            <label>
                <input name="money" type="number" required>
            </label>
        </p>
        <button class="btn btn-success text-uppercase" type="submit">do transfer</button>

    </form>

</body>
</html>
