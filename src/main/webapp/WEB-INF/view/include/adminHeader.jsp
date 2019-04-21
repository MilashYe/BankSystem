
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/2/19
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<header>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message" />
</header>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow ">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/bank/admin/main">
            <fmt:message key="main.page.welcome.name"/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/bank/admin/main">
                        <fmt:message key="main.home"/>
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/bank/admin/addUsers">
                        <c:out value="Connect user"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/bank/admin/statistic">
                        <c:out value="Show statistic"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/bank/admin/approveCreditPage">
                        <c:out value="Approve credits"/>
                    </a>
                </li>



                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="main.menu"/>
                    </a>
                    <!-- Here's the magic. Add the .animate and .slide-in classes to your .dropdown-menu and you're all set! -->
                    <div class="dropdown-menu dropdown-menu-right animate slideIn" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/bank/privateAccount">
                            <fmt:message key="main.account"/>
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/bank/logout">
                            <fmt:message key="logout"/>
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="?locale=en">
                            EN
                        </a>
                        <a class="dropdown-item" href="?locale=uk">
                            UK
                        </a>

                    </div>
                </li>
            </ul>




        </div>
    </div>
</nav>

</body>
</html>
