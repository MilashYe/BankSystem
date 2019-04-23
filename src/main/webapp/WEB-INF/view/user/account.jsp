<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/28/19
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Account</title>

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
        <div class="card row">
            <p class="card-title ">
                <fmt:message key="account.info.accountnumber"/> <fmt:formatNumber type = "number" value = "${account.id}"/>
            </p>
            <p>
                <fmt:message key="money"/> <fmt:formatNumber value="${account.money/100}" />
            </p>

        </div>
        <div class="card row">
            <%--Users--%>
            <p class="card-title"><fmt:message key="account.info.users"/> </p>
            <table class="table table-hover table-custom">
                <tr>
                    <th><fmt:message key="account.info.user.login"/> </th>
                    <th><fmt:message key="account.info.user.role"/> </th>
                    <th><fmt:message key="account.info.user.name"/> </th>
                    <th><fmt:message key="account.info.user.surname"/> </th>
                </tr>
                <c:forEach var="user" items="${account.users}">
                    <tr>
                        <td><c:out value="${user.login}"/></td>
                        <td> <c:out value=" ${user.role}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td> <c:out value=" ${user.surname}"/></td>
                    </tr>

                </c:forEach>
            </table>
        </div>

        <div class="card row">
            <%--Credits--%>
            <p class="card-title"><fmt:message key="account.info.credits"/> </p>
            <table class="table table-hover table-custom">
                <tr>
                    <th><fmt:message key="account.info.credit.number"/> </th>
                    <th><fmt:message key="account.info.credit.type"/> </th>
                    <th><fmt:message key="account.info.credit.closeterm"/> </th>
                    <th><fmt:message key="account.info.credit.money"/> </th>
                    <th><fmt:message key="button.account.info.credit.delete"/> </th>
                </tr>
                <c:forEach var="credit" items="${account.credits}">
                    <tr>
                        <td><fmt:formatNumber type="number" maxIntegerDigits="16" value="${credit.idCred}"/> </td>
                        <td> <c:out value=" ${credit.type}"/></td>
                        <td><c:out value="${credit.termToClose}"/></td>
                        <td><c:out value="${credit.money/100}"/></td>
                        <td>
                            <button type="button" class="btn btn-danger btn-block btn-primary text-uppercase" onclick="location.href='${pageContext.request.contextPath}/bank/user/deleteCredit?credId=${credit.idCred}&acId=${account.id}'" >
                                <fmt:message key="button.account.info.credit.delete"/>
                            </button>
                        </td>


                    </tr>

                </c:forEach>

            </table>
        </div>
        <div class="card row">
            <%--Deposits--%>
            <p class="card-title"><fmt:message key="account.info.deposits"/> </p>
            <table class="table table-hover table-custom">
                <tr>
                    <th><fmt:message key="account.info.deposit.number"/> </th>
                    <th><fmt:message key="account.info.deposit.type"/></th>
                    <th><fmt:message key="account.info.deposit.percent"/></th>
                    <th><fmt:message key="account.info.deposit.money"/></th>
                    <th><fmt:message key="account.info.deposit.money.received"/></th>
                    <th><fmt:message key="account.info.deposit.delete"/></th>
                </tr>
                <c:forEach var="deposit" items="${account.deposits}">
                    <tr>
                        <td><c:out value="${deposit.idDep}"/></td>
                        <td> <c:out value=" ${deposit.type}"/></td>
                        <td><c:out value="${deposit.percent}"/></td>
                        <td> <c:out value=" ${deposit.money/100}"/></td>
                        <td> <c:out value=" ${deposit.receivedMoney/100}"/></td>
                        <td><button type="button" class="btn btn-danger btn-block btn-primary text-uppercase" onclick="location.href='${pageContext.request.contextPath}/bank/user/deleteDeposit?depId=${deposit.idDep}&acId=${account.id}'" >
                            <fmt:message key="button.account.info.credit.delete"/> </button> </td>

                    </tr>

                </c:forEach>
            </table>
        </div>


    </div>
    <button onclick="location.href='${pageContext.request.contextPath}/bank/user/userInfo'"
            class="btn-ex btn  btn-lg btn-success btn-block text-uppercase " >
        Back
    </button>

</body>
</html>
