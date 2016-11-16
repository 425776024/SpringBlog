<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SpringBlog</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-wysihtml5.css"/>


    <!-- Add custom CSS here -->
    <link href="/resources/css/admin.css" rel="stylesheet">


</head>

<body>
    <div class="admin-container">

        <jsp:include page="blog-header.jsp" />
        <!-- /.container -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <jsp:include page="admin-menu.jsp"/>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <div class="admin-container-inner-wrap">

                    </div>
                </div>
            </div>
        </div>


    </div>

    <!-- JavaScript -->
    <script src="/resources/js/lib/jquery-1.10.2.js"></script>
    <script src="/resources/js/lib/bootstrap.js"></script>
    <script src="/resources/js/lib/json.min.js"></script>
    <script src="/resources/js/lib/wysihtml5-0.3.0.js"></script>
    <script src="/resources/js/lib/bootstrap3-wysihtml5.js"></script>
    <script src="/resources/js/admin.js"></script>

</body>

</html>
