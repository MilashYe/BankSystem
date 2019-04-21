
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/14/19
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Pay bills</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
    <jsp:include page="../include/userHeader.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">
                            <c:out value="Pay bill"/>
                        </h5>
                        <form class="form-signin" method="post" action="${pageContext.request.contextPath}/bank/user/payBill">
                            <table>
                                <tr>
                                    <th>from account</th>
                                    <th>to account</th>
                                </tr>
                                <tr>
                                    <td>
                                        <label>
                                            <select name="account1">
                                                <c:forEach var="account" items="${sessionScope.user.accounts}">
                                                    <option value="${account.id}"><c:out value="account ${account.id}"/> </option>
                                                </c:forEach>
                                            </select>
                                        </label>
                                    </td>
                                    <td>
                                        <label>
                                            <input type="number" name="account2" required>
                                        </label>
                                    </td>
                                </tr>
                            </table>
                            <p>
                                <label>
                                    <input name="money" type="number" required>
                                </label>
                            </p>
                            <c:if test="${not empty requestScope.info}">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${requestScope.info}"/>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                            </c:if>


                            <button type="submit" class="btn btn-success text-uppercase">pay</button>
                        </form>


                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
