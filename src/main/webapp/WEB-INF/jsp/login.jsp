<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!--BootstrapValidator CSS-->
    <link rel="stylesheet" href="/resources/css/bootstrapValidator.css"/>

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">


  </head>

  <body>

    <div class="container">

      <form id="form-signin" method="post">

        <h2 class="form-signin-heading">Please sign in</h2>
        <div class="form-group">
          <input name="name"  type="text" class="form-control form-signin-name" placeholder="User name" autofocus>
        </div>
        <div class="form-group">
          <input name="password"  type="password" class="form-control form-signin-password" placeholder="Password">
        </div>
        <div class="alert alert-danger admin-login-alert">
          <strong class="admin-login-alert-msg"></strong>
        </div>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block " id="sign-in-btn">Sign in</button>

      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/js/lib/jquery-1.10.2.js"></script>
    <script src="/resources/js/lib/bootstrap.js"></script>
    <script src="/resources/js/lib/json.min.js"></script>
    <script src="/resources/js/lib/bootstrapValidator.js"></script>
    <script src="/resources/js/login.js"></script>
  </body>

</html>
