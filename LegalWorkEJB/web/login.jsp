<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <title>Legal Work Assigment</title>
  
       <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
       <link rel="stylesheet" href="css/bootstrap.min.css">
       
  <!-- Font Awesome -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
       <link rel="stylesheet" href="css/AdminLTE.min.css">
  <!-- iCheck -->
       <link rel="stylesheet" href="css/blue.css">
   </head>
   
 <body class="hold-transition login-page">
        <div class="login-box">
  <div class="login-logo">
    <a href="#"><b>Legal Work Assigment</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Iniciar Sesion</p>

    <form action="./validarUsuario" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Nombre de Usuario" name="txblogin">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" class="form-control" placeholder="Contraseña" name="txbpass">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Ingresar</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <c:if test="${sessionScope.msgError!=null}">
        <c:out value="${msgError}"/>
        <c:remove var="msgError"/>
    </c:if>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="js/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="css/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="js/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
    </body>
</html>
