<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/28/19
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>User info</title>

    <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>

    <fmt:setBundle basename="message" />
</head>
<body>
<!-- Navigation -->

<jsp:include page="../include/userHeader.jsp"/>
    <div class="col">
        <div class="card">
            <h1 class="card-title">
                <c:out value="${sessionScope.user.name} ${sessionScope.user.surname}"/>

            </h1>


            <table class="table table-hover">
                <tr>
                    <th><fmt:message key="user.info.account.number"/> </th>
                    <th><fmt:message key="user.info.account.balance"/> </th>
                    <th><fmt:message key="user.info.info"/> </th>
                    <th><fmt:message key="user.info.delete"/> </th>
                </tr>
                <c:forEach var="account" items="${sessionScope.user.accounts}">

                    <tr>
                        <td><c:out value="${account.id}"/></td>
                        <td> <c:out value=" ${account.money/100}"/></td>
                        <td>
                            <button type="button" class="btn btn-success btn-block btn-primary text-uppercase"
                                    onclick="location.href='${pageContext.request.contextPath}/bank/user/accountInfo?acId=${account.id}'" >
                                <fmt:message key="user.info.info"/>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger btn-block btn-primary text-uppercase"
                                    onclick="location.href='${pageContext.request.contextPath}/bank/user/accountDelete?acId=${account.id}'" >
                                <fmt:message key="user.info.delete"/>
                            </button>
                        </td>
                    </tr>

                </c:forEach>
            </table>
            <button onclick="location.href='${pageContext.request.contextPath}/bank/user/openAccount'"
            class="btn btn-lg btn-success btn-block text-uppercase "><fmt:message key="user.info.open.account"/> </button>
        </div>

        <button onclick="location.href='${pageContext.request.contextPath}/bank/user'"
                class="btn-ex btn  btn-lg btn-success btn-block text-uppercase " >
            <fmt:message key="back.button"/>
        </button>
        </div>




</body>
</html>
