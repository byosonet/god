<%@ include file="./WEB-INF/views/layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Bienvenido</title>
  <jsp:include page="./WEB-INF/views/layout/staticResources.jsp"></jsp:include>
  <style>
      .login-dialog .modal-dialog {
          width: 350px;
          margin-top: 175px;
          margin-left: 490px;
          margin-left: 525px;
        }
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
            title: 'Mensaje del Sistema:',
            message: msjStatus,
            cssClass: 'login-dialog',
            buttons: [{
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
            title: 'Mensaje del Sistema:',
            message: msjStatus,
            cssClass: 'login-dialog',
            buttons: [{
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
    <div>
    <div class="login" style="margin-top: 150px;">
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
</body>
</html>
