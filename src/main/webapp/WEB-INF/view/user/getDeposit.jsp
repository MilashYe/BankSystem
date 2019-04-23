
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
                            <fmt:message key="deposit.title"/>
                        </h5>
                        <c:if test="${not empty info}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${info}"/>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                        </c:if>
                        <form class="form-signin" name="getDepositForm" method="post" action="${pageContext.request.contextPath}/bank/user/getDeposit">
                            <div>
                                <label for="depositType"> <fmt:message key="choose.deposit.type"/></label>
                                <select id="depositType" name="depositType">
                                    <option value = "standart"> <fmt:message key="deposit.standart"/></option>
                                    <option value = "junior"> <fmt:message key="deposit.junior"/></option>
                                    <option value = "private"> <fmt:message key="deposit.private"/></option>
                                </select>
                            </div>
                            <div >
                                <label for="money"> <fmt:message key="input.sum"/></label>
                                <input id="money" name="inputMoney" type="number" required>
                            </div>
                            <div>
                                <label for="stTerm"> <fmt:message key="choose.term.standart"/></label>
                                <select id="stTerm" name="standartTerm">
                                    <option value="1"> <fmt:message key="month.1"/></option>
                                    <option value="3"> <fmt:message key="month.3"/></option>
                                    <option value="6"> <fmt:message key="month.6"/></option>
                                    <option value="12"> <fmt:message key="month.12"/></option>
                                </select>
                            </div>
                            <div>
                                <label for="acc"> <fmt:message key="choose.account"/></label>
                                <select id="acc" name="accountNumber">
                                    <c:forEach var="account" items="${sessionScope.user.accounts}">
                                        <option value="${account.id}"> <fmt:message key="account"/> <c:out value="${account.id}"/></option>
                                    </c:forEach>
                                </select>
                            </div>


                            <button class="btn btn-success text-uppercase" type="submit"> <fmt:message key="get.deposit"/></button>


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
