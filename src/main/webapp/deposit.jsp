<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/28/19
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Deposits</title>

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
            <!-- Standart -->
            <div class="col-lg-4">
                <div class="card mb-5 mb-lg-0">
                    <div class="card-body">
                        <h5 class="card-title text-muted text-uppercase text-center">
                            <fmt:message key="deposit.standart"/>
                        </h5>
                        <h6 class="card-price text-center">
                            <fmt:message key="deposit.standart.percent.range"/>
                            <span class="period">
                                <fmt:message key="deposit.rate"/>
                            </span>
                        </h6>
                        <hr>
                        <ul class="fa-ul">
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.replenishment"/><fmt:message key="yes"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.payment"/><fmt:message key="monthly"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.closure"/>
                                <fmt:message key="yes"/>/<fmt:message key="consumer.choise"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.term"/><fmt:message key="deposit.standart.term.range"/>
                            </li>

                        </ul>
                        <a href="${pageContext.request.contextPath}/bank/depositPage" class="btn btn-success btn-block btn-primary text-uppercase">
                            <fmt:message key="deposit.button.confirm"/>
                        </a>
                    </div>
                </div>
            </div>
            <!-- Private -->
            <div class="col-lg-4">
                <div class="card mb-5 mb-lg-0">
                    <div class="card-body">
                        <h5 class="card-title text-muted text-uppercase text-center">
                            <fmt:message key="deposit.private"/>
                        </h5>
                        <h6 class="card-price text-center">
                            <fmt:message key="deposit.private.percent"/>
                            <span class="period">
                                <fmt:message key="deposit.rate"/>
                            </span>
                        </h6>
                        <hr>
                        <ul class="fa-ul">
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.replenishment"/><fmt:message key="yes"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.payment"/><fmt:message key="monthly"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.closure"/>
                                <fmt:message key="yes"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.term"/><fmt:message key="deposit.private.term"/>
                            </li>

                        </ul>

                        <a href="${pageContext.request.contextPath}/bank/depositPage" class="btn btn-success btn-block btn-primary text-uppercase">
                            <fmt:message key="deposit.button.confirm"/>
                        </a>
                    </div>
                </div>
            </div>
            <!-- Junior -->
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-muted text-uppercase text-center">
                            <fmt:message key="deposit.junior"/>
                        </h5>
                        <h6 class="card-price text-center">
                            <fmt:message key="deposit.junior.rate.percent"/>
                            <span class="period">
                                <fmt:message key="deposit.rate"/>
                            </span>
                        </h6>
                        <hr>
                        <ul class="fa-ul">
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.replenishment"/><fmt:message key="yes"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.payment"/><fmt:message key="yearly"/>/<fmt:message
                                        key="capitalization"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.closure"/>
                                <fmt:message key="yes"/>
                            </li>
                            <li><span class="fa-li"><i class="fas fa-check"></i></span>
                                <fmt:message key="deposit.term"/><fmt:message key="deposit.junior.term.range"/>
                            </li>

                        </ul>
                        <a href="${pageContext.request.contextPath}/bank/depositPage" class="btn btn-success btn-block btn-primary text-uppercase">
                            <fmt:message key="deposit.button.confirm"/>
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
