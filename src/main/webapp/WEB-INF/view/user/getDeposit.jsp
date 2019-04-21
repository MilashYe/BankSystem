<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/8/19
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Get deposit</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
</head>
<body>
    <jsp:include page="../include/userHeader.jsp"/>
<form name="getDepositForm" method="post" action="${pageContext.request.contextPath}/bank/user/getDeposit">
        <p>choose deposit type</p>

        <label>
            <select name="depositType">
                <option value = "standart">Standart</option>
                <option value = "junior">Junior</option>
                <option value = "private">Private</option>
            </select>
        </label>
        <p>input sum</p>
        <label>
            <input name="inputMoney" type="number">
        </label>

        <p>choose term(for standart)</p>
        <label>
            <select name="standartTerm">
                <option value="1">1 month</option>
                <option value="5">3 monthes</option>
                <option value="8">8 monthes</option>
                <option value="12">12 monthes</option>
            </select>
        </label>

        <br/>
        <label>
            <select name="accountNumber">
                <c:forEach var="account" items="${sessionScope.user.accounts}">
                    <option value="${account.id}">account <c:out value="${account.id}"/></option>
                </c:forEach>
            </select>
        </label>
        <button class="btn btn-success text-uppercase" type="submit">get deposit</button>


    </form>

    <a class="btn btn-success" href="javascript:history.back()">back</a>

</body>
</html>
