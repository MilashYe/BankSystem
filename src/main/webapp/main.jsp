<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 3/22/19
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"/>
    <fmt:setLocale value="${sessionScope.lang}"/>



</head>
<body>
<c:out value="${pageContext.request.contextPath}"/>
</body>
</html>
