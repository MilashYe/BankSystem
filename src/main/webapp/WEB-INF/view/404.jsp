<%--
  Created by IntelliJ IDEA.
  User: yevhenii
  Date: 4/24/19
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>404</title>

    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
    <!-- Loading Elements Styles -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
    <!-- Loading Font Styles -->
    <link href="${pageContext.request.contextPath}/css/iconfont-style.css" rel="stylesheet" />

</head>
<body>
<div id="wrap">
    <!-- 404 ERROR BLOCK -->
    <section id="error-404" class="cover-bg no-sep screen-height" style="background-image:url(../../image/bg51.jpg)">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="mega-title">4<i class="icon center-icon icon-compass2"></i>4</h2>
                    <h2><strong>It looks like you're lost.</strong></h2>
                    <h2 class="sep-bottom">The page you're looking for isn't here.</h2>
                    <a href="${pageContext.request.contextPath}/bank/main" class="btn btn-lg btn-primary"><i class="icon icon-arrow-left"></i> Go back home</a>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
