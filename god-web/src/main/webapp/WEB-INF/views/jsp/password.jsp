<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Bienvenido</title>
  <link rel="stylesheet" type="text/css" href="${contextpath}/static/resources/css/style.css">
  <script type="text/javascript">
      $(function(){
          var status;
          $('input#email').focus();
          $('input#enviar').click(function(){
              
              var email = $('input#email');
              var confEmail = $('input#confEmail');
              if(email.val() === ""){
                  muestraMsjSistemaError('El email es requerido.');
                  return false;
              }else if(confEmail.val() === ""){
                  muestraMsjSistemaError('El email es requerido.');
                  return false;
              }else if(email.val() !== confEmail.val()){
                  muestraMsjSistemaError('El email no coincide.');
                  return false;
              }
              
              $.blockUI();
              $.ajax({
	              type: 'POST',
	              url: '${contextpath}'+'/password/enviar/email',
	              data: $('form#recuperar').serialize(),
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
                    var urlAction = '${contextpath}';
                    document.getElementById('regresar').action = urlAction;
                    document.getElementById('regresar').method = 'GET';
                    document.getElementById('regresar').submit();
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
      <h1>Recupera tu Password</h1>
      <form id="recuperar">
        <p><input type="text" name="email" id="email" value="" placeholder="email" style="margin-left: -3px;"></p>
        <p><input type="text" name="confEmail" id="confEmail" value="" placeholder="confirma email" style="margin-left: -3px;"></p>
        <p class="submit">
            <input id="limpiar" type="reset" name="limpiar" value="Limpiar">
            <input id="enviar" type="button" name="enviar" value="Enviar">
        </p>
      </form>
      <form id="regresar"></form>
    </div>
    </div>
</body>
</html>