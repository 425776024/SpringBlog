<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">SpringBlog</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#about">About</a>
                    </li>
                    <li><a href="#contact">Contact</a>
                    </li>
                </ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
                        <c:if test="${user!=null}">
                        <a class="header-user-name" href="/admin/index">
                            <c:out value="${user.userName}"/>
                        </a>
                        </c:if>
                        <c:if test="${user==null}">
                            <a class="header-user-name" href="/admin/login">
                                登陆
                            </a>
                        </c:if>
                    </li>
					<li><a href="#">Help</a></li>
				 </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- /.container -->


