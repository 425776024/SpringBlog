<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-lg-10 blog-post-container">

        <c:if test="${post != null}">
            <h1 data-key="${post.postId}"><c:out value="${post.postTitle}"/></h1>

            <p class="lead">by <span><c:out value="${author}"/></span>
            <p class="lead">分类 <span><c:out value="${category.catName}"/></span>
            </p>
            <hr>
            <p>
                <span class="glyphicon glyphicon-time"></span>Posted on <c:out value="${postDate}"/>
            </p>
            <hr>

            <p class="post-content">${post.postContent}</p>
            <hr>
        </c:if>

    </div>
</div>
