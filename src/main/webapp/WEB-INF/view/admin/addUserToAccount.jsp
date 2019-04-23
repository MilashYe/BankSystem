<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/16/19
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Connect user to account</title>

    <link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/registration.css" rel="stylesheet" type="text/css"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message" />
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="../include/adminHeader.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/bank/admin/connectUser" method="get">
                            <h5 class="card-title text-center">
                                <fmt:message key="admin.add.main"/>
                            </h5>
                            <div class="form-group">
                                <label for="selectUser"><fmt:message key="admin.add.select.user"/> </label>
                                <select multiple class="form-control" id="selectUser" name="selectUser">
                                    <c:forEach var="u" items="${requestScope.users}">
                                        <option value="${u.id}">
                                            ${u.login}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="selectAccount"><fmt:message key="admin.add.select.account"/> </label>
                                <select multiple class="form-control" id="selectAccount" name="selectAccount">
                                    <c:forEach var="a" items="${requestScope.accounts}">
                                        <option value="${a.id}">
                                                ${a.id}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <c:if test="${not empty requestScope.alert}">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${requestScope.alert}"/>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </c:if>
                            <c:if test="${not empty requestScope.success}">
                                <div class="alert alert-success" role="alert">
                                    <c:out value="${requestScope.success}"/>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </c:if>
                            <button class="btn-ex btn-lg btn-success btn-block text-uppercase " type="submit" >
                                <fmt:message key="button.connect"/> </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
