<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SpringBlog</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/blog.css" rel="stylesheet">

</head>


  <body>
  <jsp:include page="blog-header.jsp"/>
    <div class="row">
            <h2>${category.catName}</h2>
            <div class="container blog-container-wrap">
                <div class="row">
                    <div class="col-lg-8 blog-container-wrap-content">
                        <c:forEach items="${posts}" var="p">
                            <div class="blog-container-wrap-content-blog" data-key="'${p.postId}'">
                            <h2 class=""><a class="blog-title-btn" href="/view/post/${p.postId}">${p.postTitle}</a></h2>
                            <hr>
                            </div>
                        </c:forEach>
                    </div>
                </div>
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <jsp:include page="blog-footer.jsp"/>

  </body>
</html>
