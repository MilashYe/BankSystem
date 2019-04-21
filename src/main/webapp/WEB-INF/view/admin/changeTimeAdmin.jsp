
<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/16/19
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Statistic</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="message" />

</head>
<body>
<!-- Navigation -->
<jsp:include page="../include/adminHeader.jsp"/>
    <div class="col">
        <div class="card row">
            <p class="card-title">Change time</p>
            <table class="table table-hover table-30">
                <tr>
                    <th>Account number</th>
                    <th>Change time</th>
                    <th>Message info</th>

                </tr>
                <c:forEach var="time" items="${times}">
                    <tr>
                        <td>
                            <c:out value="${time.acId}"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${time.changeTime}" dateStyle="full" type="both" />

                        </td>
                        <td>
                            <c:out value="${time.message}"/>
                        </td>

                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>

    <nav aria-label="Page navigation">
        <%--<ul class="pagination fixed-bottom">
            <li class="page-item">

            </li>
            <c:forEach var="i" begin="${requestScope.page}" end="${requestScope.page+5}" step="1">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/bank/admin/statistic?page=${i}&pageCount=${requestScope.pageCount}">
                        <c:out value="${i+1}"/>
                    </a>
                </li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="${pageContext.request.contextPath}/bank/admin/statistic?page=${sessionScope.page+1}&pageCount=${requestScope.pageCount}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>--%>
        <ul class="pagination justify-content-center">
            <c:if test="${requestScope.currentPage != 0}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/bank/admin/statistic?page=${sessionScope.currentPage-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${requestScope.pageCount}" var="i">
                <c:choose>
                    <c:when test="${requestScope.currentPage eq i}">
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/bank/admin/statistic?page=${i-1}">
                                <c:out value="${i}"/><span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/bank/admin/statistic?page=${i-1}">
                                <c:out value="${i}"/>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${requestScope.currentPage lt requestScope.pageCount-1}">
                <li class="page-item">
                    <a class="page-link" style="width: 120px;"
                       href="${pageContext.request.contextPath}/bank/admin/statistic?page=${requestScope.currentPage+1}">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</body>
</html>
