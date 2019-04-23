<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/28/19
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Admin main</title>

    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>

    <fmt:setBundle basename="message" />
</head>
<body>
<!-- Navigation -->

<jsp:include page="../include/adminHeader.jsp"/>

<div class="container">

    <!-- Page Heading -->
    <h1 class="my-4"><fmt:message key="admin.admin"/> <c:out value=" ${sessionScope.user.login}"/>
        <small><fmt:message key="user.main.page"/> </small>
    </h1>

    <!-- Project One -->
    <div class="row">
        <div class="col-md-7">
            <a href="#">
                <img class="img-fluid rounded mb-3 mb-md-0" src="${pageContext.request.contextPath}/image/connectUser.jpg" alt="">
            </a>
        </div>
        <div class="col-md-5">
            <h3><fmt:message key="admin.main.connect.user"/> </h3>
            <p><fmt:message key="admin.main.connect.text"/> </p>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/bank/admin/addUsers"><fmt:message
                    key="admin.main.connect.button"/>
            </a>
        </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Two -->
    <div class="row">
        <div class="col-md-7">
            <a href="#">
                <img class="img-fluid rounded mb-3 mb-md-0" src="${pageContext.request.contextPath}/image/loanApprove.jpg" alt="">
            </a>
        </div>
        <div class="col-md-5">
            <h3><fmt:message key="admin.main.approve"/> </h3>
            <p><fmt:message key="admin.main.approve.text"/> </p>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/bank/admin/approveCreditPage"><fmt:message
                    key="admin.main.approve.button"/> </a>
        </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Three -->
    <div class="row">
        <div class="col-md-7">
            <a href="#">
                <img class="img-fluid rounded mb-3 mb-md-0" src="${pageContext.request.contextPath}/image/statistic.jpg" alt="">
            </a>
        </div>
        <div class="col-md-5">
            <h3><fmt:message key="admin.main.info"/> </h3>
            <p><fmt:message key="admin.main.info.text"/> </p>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/bank/admin/statistic"><fmt:message
                    key="admin.main.info.button"/> </a>
        </div>
    </div>
    <!-- /.row -->

    <hr>


</div>

</body>
</html>
