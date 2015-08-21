<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link rel="stylesheet" type="text/css" href="${contextpath}/static/resources/css/style.css">
         <jsp:include page="../layout/staticResources.jsp"></jsp:include>
         <script type="text/javascript" language="javascript" src="${contextpath}/static/resources/js/model/ModelNacimiento.js"></script>
    <style>

    </style>
  
  <script type="text/javascript">
      $(function(){
        var status;
        $('input#masculino').click(function(){
            $('input#femenino').attr('checked',false);
        });

        $('input#femenino').click(function(){
            $('input#masculino').attr('checked',false);
        });
          
          
        $('input#nombre').focus();
        $('input#registrar').click(function(){
            
                var nombre = $('input#nombre');
                var email = $('input#email');
                var passw = $('input#password');
                var confPassword = $('input#confPassword');
                if(nombre.val() === ""){
                    nombre.focus();
                    muestraMsjSistemaError('El nombre es requerido.');
                    return false;
                }else if(email.val() === ""){
                    muestraMsjSistemaError('El email es requerido.');
                    return false;
                }else if(passw.val() === "" || confPassword.val() === ""){
                    muestraMsjSistemaError('El password es requerido.');
                    return false;
                }else if(passw.val() != confPassword.val()){
                    muestraMsjSistemaError('El password no coincide.');
                    return false; 
                }
                var m = $('input#masculino').filter(":checked").val();
                var f = $('input#femenino').filter(":checked").val();
		if(m === undefined && f === undefined){
			  muestraMsjSistemaError('El sexo es un campo requerido.');
			  return false;
		}
                $('input#idEmail').val(email.val());
                $('input#idPassword').val(passw.val());
		$.blockUI();
                $.ajax({
	              type: 'POST',
	              url: '${contextpath}'+'/usuario/nuevo',
	              data: $('form#formRegistrar').serialize(),
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
            size: BootstrapDialog.SIZE_SMALL,
            title: 'Mensaje del Sistema:',
            closable: false,
            message: '<strong>'+msjStatus+'</strong>',
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
            size: BootstrapDialog.SIZE_SMALL,
            title: 'Mensaje del Sistema:',
            closable: false,
            message: '<strong>'+msjStatus+'</strong>',
            type: BootstrapDialog.TYPE_SUCCESS,
            cssClass: 'login-dialog',
            buttons: [{
                icon: 'glyphicon glyphicon-check',
                label: 'CONTINUAR',
                cssClass: 'btn-primary',
                action: function(dialog) {
                    dialog.close();
                    $.blockUI();
                    var urlAction = '${contextpath}' + '/lista/obtener';
                    document.getElementById('ingresar').action = urlAction;
                    document.getElementById('ingresar').method = 'POST';
                    document.getElementById('ingresar').submit();
                }
            }]
        });
        }
        
        
        
      });
  </script>
    <style>
             body{
                font:  150% comic sans ms;
                color: gray;
             }
    </style>
    </head>
    <body>
        <div>
    <div class="login" style="margin-top: 50px;">
      <h1>Registro de Usuario</h1>
      <form id="formRegistrar" method="post" action="${contextpath}/registrar">
        <p><input type="text" name="nombre" id="nombre" value="" placeholder="Nombre Completo" style="margin-left: -3px;"></p>
        <p><input type="text" name="email" id="email" value="" placeholder="Email" style="margin-left: -3px;"></p>
        <p><input type="password" name="password" id="password" value="" placeholder="Password" style="margin-left: -3px;"></p>
        <p><input type="password" name="confPassword" id="confPassword" value="" placeholder="Confirmar Password" style="margin-left: -3px;"></p>
        
        <br><br>
        <div style="text-align: center;"><h1>Información Personal</h1></div> 
        <p style="text-align: center;">
            Día:<select id="dia" name="dia" data-bind="foreach: days, visible: days().length > 0">
            <option data-bind="value: id,text:day"></option></select>
            <br><br>
            Mes:<select id="mes" name="mes" data-bind="foreach: months, visible: months().length > 0">
            <option data-bind="value: id,text:mes"></option></select>
            <br><br>
            Año:<select id="anio" name="anio" data-bind="foreach: years, visible: years().length > 0">
            <option data-bind="value: year,text:year"></option></select>
            <br><br>
            Actividad:<select id="actividad" name="actividad" data-bind="foreach: activities, visible: activities().length > 0">
            <option data-bind="value: activity,text:activity"></option></select>
        </p>
        
        
        <p style="text-align: center;"> 
            Sexo: 
            <input value="M" type="radio" name="sexo" id="masculino"> Masculino
            <input value="F" type="radio" name="sexo" id="femenino"> Femenino
        </p>
        
        <p style="text-align: center;"> 
            Deseo Recibir Notificaciones: Sí <input type="checkbox" id="notificar" name="notificar" value="SI">
        </p>
        
        <p class="submit">
            <input id="limpiar" type="reset" name="limpiar" value="Limpiar">
            <input id="registrar" type="button" name="registrar" value="Registrar">
        </p>
      </form>
        
        <form id="ingresar">
            <input type="hidden" id="idEmail" name="idEmail" value=""/>
            <input type="hidden" id="idPassword" name="idPassword" value=""/>
        </form>
    </div>
    </div>
    </body>
</html>
