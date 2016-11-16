<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 14-5-12
  Time: 上午9:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SpringBlog</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/blog.css" rel="stylesheet">

</head>

<body>

  <jsp:include page="blog-header.jsp"/>
  <div class="container blog-container-wrap">


    <div class="row">
      <div class="col-lg-8 blog-container-wrap-content">
          <!-- blog-->

      </div>
      <div class="col-lg-4">
          <jsp:include page="blog-menu.jsp"/>
      </div>
    </div>


  </div>
  <jsp:include page="blog-footer.jsp"/>


  <!-- JavaScript -->
  <script src="/resources/js/lib/jquery-1.10.2.js"></script>
  <script src="/resources/js/lib/bootstrap.js"></script>
  <script src="/resources/js/lib/json.min.js"></script>
  <script src="/resources/js/blog.js"></script>


</body>
</html>