
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

    <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <fmt:message key="credit.title"/>
                    </h5>
                    <c:if test="${not empty info}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${info}"/>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                    </c:if>
                    <form class="form-signin" name="getLoanForm" method="post" action="${pageContext.request.contextPath}/bank/user/getCredit">

                        <div>
                            <label for="credType"><fmt:message key="credit.choose.type"/> </label>
                            <select id="credType" name="creditType">
                                <option value = "credit_card"><fmt:message key="credit.credit.card"/></option>
                                <option value = "hypothec"><fmt:message key="credit.hypothec"/> </option>
                                <option value = "installment_pay"><fmt:message key="credit.installment.plan"/> </option>
                            </select>
                        </div>
                        <div>
                            <label for="money"><fmt:message key="input.sum"/></label>
                            <input id="money" name="inputMoney" type="number" required>
                        </div>
                        <div>
                            <label for="hypoTherm"><fmt:message key="choose.term.hypothec"/> </label>
                            <select id="hypoTherm" name="hypothec_term_close">
                                <option value="60"><fmt:message key="year.5"/></option>
                                <option value="120"><fmt:message key="year.10"/></option>
                                <option value="240"><fmt:message key="year.20"/></option>
                            </select>
                        </div>
                        <div>
                            <label for="payCount">
                                <fmt:message key="choose.count.payments"/>
                            </label>
                            <select id="payCount" name="count_of_payment">
                                <option value="6"><fmt:message key="payment.6"/> </option>
                                <option value="8"><fmt:message key="payment.8"/> </option>
                                <option value="12"><fmt:message key="payment.12"/> </option>
                            </select>
                        </div>
                        <div>
                            <label for="acc">
                                <fmt:message key="choose.account"/>
                            </label>
                            <br/>
                            <select id="acc" name="accountNumber">
                                <c:forEach var="account" items="${sessionScope.user.accounts}">
                                    <option value="${account.id}">
                                        <fmt:message key="account"/> <c:out value="${account.id}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <button class="btn btn-success text-uppercase" type="submit"><fmt:message key="get.loan"/> </button>


                    </form>

                    <button onclick="location.href='${pageContext.request.contextPath}/bank/privateAccount'"
                            class="btn btn-ex btn-lg btn-success btn-block text-uppercase " type="submit" >

                        <fmt:message key="button.comeback"/>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
