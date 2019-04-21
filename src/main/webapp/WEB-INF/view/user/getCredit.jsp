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
    <title>Get credit</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

</head>
<body>
<jsp:include page="../include/userHeader.jsp"/>
<form name="getLoanForm" method="post" action="${pageContext.request.contextPath}/bank/user/getCredit">
    <p>choose credit type</p>

    <select name="creditType">
        <option value = "credit_card">Credit card</option>
        <option value = "hypothec">Hypothec</option>
        <option value = "installment_pay">Installment pay</option>
    </select>
    <p>input sum</p>
    <input name="inputMoney" type="number">

    <p>choose term(for hypothec)</p>
    <select name="hypothec_term_close">
        <option value="60">5 years</option>
        <option value="120">10 years</option>
        <option value="240">20 years</option>
    </select>
    <p>
        choose count of payment(for instalment pay)
    </p>
    <select name="count_of_payment">
        <option value="6">6 payments</option>
        <option value="8">8 payments</option>
        <option value="12">12 payments</option>
    </select>
    <p>
        choose account
    </p>
    <br/>
    <select name="accountNumber">
        <c:forEach var="account" items="${sessionScope.user.accounts}">
            <option value="${account.id}">account <c:out value="${account.id}"/></option>
        </c:forEach>
    </select>
    <button class="btn btn-success text-uppercase" type="submit">get loan</button>


</form>

<a class="btn btn-success" href="javascript:history.back()">back</a>

</body>
</html>
