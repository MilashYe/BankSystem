<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/22/19
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>

    <title>LogIn</title>
    <link href="${pageContext.request.contextPath}/css/registration.css" rel="stylesheet" type="text/css"/>

    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>

    <fmt:setBundle basename="message" />

</head>


<body>
<!-- Navigation -->

<jsp:include page="WEB-INF/view/include/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">
                        <fmt:message key="main.login"/>
                    </h5>
                    <c:if test="${not empty info}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${info}"/>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                    </c:if>
                    <form class="form-signin" method="post" action="${pageContext.request.contextPath}/bank/login">
                        <div class="form-label-group">
                            <input type="text" name="login" id="inputLogin"
                                   value="${login}"
                                   class="form-control" placeholder="login" required autofocus>
                            <label for="inputLogin"><fmt:message key="registration.login"/></label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                            <label for="inputPassword"><fmt:message key="registration.password"/></label>
                        </div>

                        <button class="btn btn-lg btn-success btn-block text-uppercase" type="submit" >

                            <fmt:message key="registration.login"/>
                        </button>

                    </form>
                    <button  class="btn btn-ex btn-lg btn-success  btn-block text-uppercase" type="submit" onclick="location.href='${pageContext.request.contextPath}/bank/registration'">

                        <fmt:message key="registration.main"/>
                    </button>
                    <button onclick="location.href='${pageContext.request.contextPath}/bank/main'"
                            class="btn btn-ex btn-lg btn-success btn-block text-uppercase " type="submit" >

                        <fmt:message key="back.button"/>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


</html>