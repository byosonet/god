<%@ include file="./WEB-INF/views/layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Bienvenido</title>
  <link rel="stylesheet" type="text/css" href="${contextpath}/static/resources/css/style.css">
  <jsp:include page="./WEB-INF/views/layout/staticResources.jsp"></jsp:include>
  <style>
      
  </style>
  
  <script type="text/javascript">
      $(function(){
          var status;
          $('input#login').focus();
          $('input#acceder').click(function(){
              
              var email = $('input#login');
              var password = $('input#password');
              if(email.val() === ""){
                  muestraMsjSistemaError('El email es requerido.');
                  return false;
              }else if(password.val() === ""){
                  muestraMsjSistemaError('El password es requerido.');
                  return false;
              }
              
              $.blockUI();
              $.ajax({
	              type: 'POST',
	              url: '${contextpath}'+'/validar/usuario',
	              data: $('form#ingresar').serialize(),
	                  success: function (data) {
                             $.unblockUI();
                             muestraMsjSistemaSuccess(data.mensaje);
	              },
                         error: function(msj){
                             status = JSON.parse(msj.responseText);
                             $.unblockUI();
                             muestraMsjSistemaError(status.mensaje);
                          }
	        });
          });
          
          $('input#registrar').click(function(){
                $.blockUI();
                var urlAction = '${contextpath}' + '/registrar/usuario';
		document.getElementById('ingresar').action = urlAction;
                document.getElementById('ingresar').method = 'GET';
		document.getElementById('ingresar').submit();
          });

        function muestraMsjSistemaError(msjStatus){
           BootstrapDialog.show({
            size: BootstrapDialog.SIZE_LARGE,
            title: 'Mensaje del Sistema:',
            message: msjStatus,
            type: BootstrapDialog.TYPE_DANGER,
            cssClass: 'login-dialog',
            buttons: [{
                icon: 'glyphicon glyphicon-check',
                label: 'OK',
                cssClass: 'btn-primary',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
        }
        
        function muestraMsjSistemaSuccess(msjStatus){
           BootstrapDialog.show({
            size: BootstrapDialog.SIZE_LARGE,
            title: 'Mensaje del Sistema:',
            message: msjStatus,
            type: BootstrapDialog.TYPE_SUCCESS,
            cssClass: 'login-dialog',
            buttons: [{
                icon: 'glyphicon glyphicon-check',
                label: 'CONTINUAR',
                cssClass: 'btn-primary',
                action: function(dialog) {
                    dialog.close();
                    $.blockUI();
                    var urlAction = '${contextpath}' + '/ingresar';
                    document.getElementById('ingresar').action = urlAction;
                    document.getElementById('ingresar').method = 'POST';
                    document.getElementById('ingresar').submit();
                }
            }]
        });
        }
      });
  </script>
  
</head>
<body style="background-image: url(/god-web/static/resources/img/fondo.gif)">
     <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#" style="color:white;">GOD WEB</a>
            </div>
          </div>
        </nav>
    <div>
    <div class="login" style="margin-top: 50px;">
      <h1>¡Solo a Dios la gloria!</h1>
      <form id="ingresar" method="post" action="${contextpath}/ingresar">
        <p><input type="text" name="user" id="login" value="" placeholder="email" style="margin-left: -3px;"></p>
        <p><input type="password" name="password" id="password" value="" placeholder="password" style="margin-left: -3px;"></p>
        <p class="submit">
            <input id="registrar" type="button" name="registrar" value="Registrar">
            <input id="acceder" type="button" name="acceder" value="Acceder">
        </p>
      </form>
    </div>
    <div class="login-help">
      <p>¿Olvide mi contraseña? <a href="${contextpath}/password/recuperar">Recuperar contraseña</a>.</p>
    </div>
    </div>
  <nav class="navbar navbar-inverse navbar-fixed-bottom">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#" style="font-size: 0.75em;color:white;">Developer: by Ulysses Mac</a>
            </div>
          </div>
</nav>
</body>
</html>
