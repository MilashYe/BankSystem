
<html>

    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <fmt:setLocale value="${sessionScope.lang}"/>

    <fmt:setBundle basename="message" />

    <nav class="nav flex-column">
        <a class="nav-link active" href="#">Info</a>
        <a class="nav-link" href="#">get credit</a>
        <a class="nav-link" href="#">get deposit</a>
        <a class="nav-link" href="#">Do bank tranfer</a>
        <a class="nav-link" href="#">pay the bill</a>
        <a class="nav-link disabled" href="#">Disabled</a>
    </nav>

</html>
