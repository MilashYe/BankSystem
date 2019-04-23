<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

</head>
<body>
    <jsp:include page="../include/userHeader.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">
                            <fmt:message key="user.transfer.title"/>
                        </h5>
                        <form class="form-signin" name="transferForm" action="${pageContext.request.contextPath}/bank/user/doTransfer" method="post">


                            <c:if test="${not empty requestScope.info}">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${requestScope.info}"/>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                            </c:if>

                            <table>
                                <tr>
                                    <td>
                                        <label for="acc1"><fmt:message key="user.account.from"/> </label>
                                        <select name="account1" id="acc1">
                                            <c:forEach var="account" items="${sessionScope.user.accounts}">
                                                <option value="${account.id}">
                                                    <fmt:message key="account"/> <c:out value="${account.id}"/> </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="acc2"><fmt:message key="user.account.to"/> </label>
                                        <select name="account2" id="acc2">
                                            <c:forEach var="account" items="${sessionScope.user.accounts}">
                                                <option value="${account.id}">
                                                    <fmt:message key="account"/> <c:out value="${account.id}"/>
                                                </option>
                                            </c:forEach>
                                        </select>

                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                        <label for="money"><fmt:message key="input.sum"/> </label>
                                        <input id="money" name="money" type="number" required>
                                    </td>

                                </tr>


                            </table>
                            <button class="btn btn-success text-uppercase" type="submit">
                                <fmt:message key="button.transfer"/> </button>
                        </form>


                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
