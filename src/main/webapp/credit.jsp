<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/28/19
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Credits</title>

    <link href="${pageContext.request.contextPath}/css/deposit.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>

    <fmt:setBundle basename="message" />

</head>
<body>
<!-- Navigation -->

<jsp:include page="WEB-INF/view/include/header.jsp"/>

<section class="pricing py-5">
    <div class="container">
        <div class="row">
            <!-- Credit card -->
            <div class="col-lg-4">
                <div class="card mb-5 mb-lg-0">
                    <div class="card-body">
                        <h5 class="card-title text-muted text-uppercase text-center">
                            <fmt:message key="credit.credit.card"/>
                        </h5>
                        <h6 class="card-price text-center">
                            <span class="period"><fmt:message key="credit.limit"/></span>

                            <fmt:message key="credit.card.limit"/>


                        </h6>
                        <hr>
                        <ul class="fa-ul">
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.rate"/><fmt:message key="credit.card.percent"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.closure"/><fmt:message key="yes"/>
                            </li>

                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.term"/><fmt:message key="credit.card.term"/>
                            </li>

                        </ul>
                        <a href="${pageContext.request.contextPath}/bank/creditPage" class="btn btn-success btn-block btn-primary text-uppercase">
                            <fmt:message key="credit.button"/>
                        </a>
                    </div>
                </div>
            </div>
            <!-- Hypothec -->
            <div class="col-lg-4">
                <div class="card mb-5 mb-lg-0">
                    <div class="card-body">
                        <h5 class="card-title text-muted text-uppercase text-center">
                            <fmt:message key="credit.hypothec"/>
                        </h5>
                        <h6 class="card-price text-center">
                            <span class="period"><fmt:message key="credit.limit"/></span>

                            <fmt:message key="credit.hypothec.limit"/>


                        </h6>
                        <hr>
                        <ul class="fa-ul">
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.rate"/><fmt:message key="credit.hypothec.percent"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.closure"/><fmt:message key="no"/>
                            </li>

                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.term"/><fmt:message key="credit.hypothec.term"/>
                            </li>

                        </ul>
                        <a href="${pageContext.request.contextPath}/bank/creditPage" class="btn btn-success btn-block btn-primary text-uppercase">
                            <fmt:message key="credit.button"/>
                        </a>
                    </div>
                </div>
            </div>
            <!-- Installments -->
            <div class="col-lg-4">
                <div class="card mb-5 mb-lg-0">
                    <div class="card-body">
                        <h5 class="card-title text-muted text-uppercase text-center">
                            <fmt:message key="credit.installment.plan"/>
                        </h5>
                        <h6 class="card-price text-center">
                            <span class="period"><fmt:message key="credit.limit"/></span>

                            <fmt:message key="credit.installment.limit"/>


                        </h6>
                        <hr>
                        <ul class="fa-ul">
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.rate"/><fmt:message key="credit.installment.percent"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.closure"/><fmt:message key="yes"/>
                            </li>

                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="credit.term"/><fmt:message key="credit.installment.term"/>
                            </li>

                        </ul>
                        <a href="${pageContext.request.contextPath}/bank/creditPage" class="btn btn-success btn-block btn-primary text-uppercase">
                            <fmt:message key="credit.button"/>
                        </a>
                    </div>
                </div>
            </div>


            <button onclick="location.href='${pageContext.request.contextPath}/bank/main'"
                    class="btn btn-ex btn-lg btn-success btn-block text-uppercase " type="submit" >


                <fmt:message key="back.button"/>
            </button>

        </div>

    </div>
</section>
</body>
</html>
