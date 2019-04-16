<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/22/19
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Main</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

</head>
<body>
<!-- Navigation -->
<jsp:include page="../include/adminHeader.jsp"/>

<!-- Full Page Image Header with Vertically Centered Content -->
<header class="masthead">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12 text-center">
                <h1 class="font-weight-light text"><fmt:message key="main.page.welcome.name"/> </h1>
                <p class="lead text"><fmt:message key="main.page.welcome.text"/> </p>

            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<section class="py-5">
    <div class="container">
        <h2 class="font-weight-light"><fmt:message key="main.final.project"/> </h2>
        <p><fmt:message key="main.page.final.project.task"/> </p>
    </div>
</section>

</body>
</html>
