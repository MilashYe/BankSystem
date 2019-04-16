
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/8/19
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html >

<head>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message"/>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Title -->
    <title><fmt:message key="error.title"/>
    </title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" />
</head>

<body class="bg-dark text-white py-5">
<div class="container py-5">
    <div class="row">
        <div class="col-md-2 text-center">
            <p><i class="fa fa-exclamation-triangle fa-5x"></i><br/><fmt:message key="error.status.code"/> </p>
        </div>
        <div class="col-md-10">
            <h3><fmt:message key="error.ops"/> </h3>
            <p><fmt:message key="error.access.message"/> </p>
            <a class="btn btn-danger" href="javascript:history.back()"><fmt:message key="back.button"/> </a>
        </div>
    </div>
</div>


</body>

</html>
