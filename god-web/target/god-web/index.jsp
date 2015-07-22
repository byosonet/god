<%@ include file="./WEB-INF/views/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Bienvenido</title>
  <link rel="shortcut icon" href="./static/resources/img/favicon.ico">
  <link rel="stylesheet" href="./static/resources/css/style.css">
  
  <script src="./static/resources/js/jquery/jquery-1.11.3.min.js"></script>
  <script src="./static/resources/js/jquery/jquery-migrate-1.2.1.min.js"></script>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  
  <script type="text/javascript">
      $(function(){
          $('input#login').focus();
          
          $('input#acceder').click(function(){
              console.log(' -- Accediendo al servidor');
              
              $.ajax({
	              type: 'POST',
	              url: '${contextpath}'+'/validar/usuario',
	              data: $('form#ingresar').serialize(),
	                  success: function (data) {
                              console.log(' -- status '+data.status);
                              $('form#ingresar').submit();
	              },
                         error: function(err){
                              console.log(' -- status: '+err.status);
                          }
	        });
              
              
          });
      });
  </script>
  
</head>
<body>
    <div>
    
    <div class="login">
      <h1>¡Solo a Dios la gloria!</h1>
      <form id="ingresar" method="post" action="${contextpath}/ingresar">
        <p><input type="text" name="user" id="login" value="" placeholder="Usuario"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p class="submit"><input id="acceder" type="button" name="commit" value="Acceder"></p>
      </form>
    </div>
    <div class="login-help">
      <p>¿Olvide mi contraseña? <a href="${contextpath}/password/recuperar">Recuperar contraseña</a>.</p>
    </div>
  
    </div>
</body>
</html>
