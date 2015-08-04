<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
         <jsp:include page="../layout/staticResources.jsp"></jsp:include>
    <style>
      .login-dialog .modal-dialog {
          width: 350px;
          margin-top: 175px;
          margin-left: 490px;
        }
    </style>
  
  <script type="text/javascript">
      $(function(){
          $('input#nombre').focus();
          /*
           $("input#option").removeAttr('checked');
	$('input#rfc').removeAttr('disabled');
	$('input#numeroRegistroPatronal').removeAttr('disabled');
	
	$('#siguientePaso').click(function() {
		var valor = $('input#option').filter(":checked").val();
		if(valor == undefined){
			  muestraMsgError();
			  return false;
		}else if(valor=='rfc'){
			$rfc = $('input#rfc');
			if ($rfc.val() == "") {
				$rfc.focus();
				$('span#errorDatoRFC').css('color','red');
				$('span#errorDatoRFC').text('El rfc es requerido.');
				return false;
			}
		}else if(valor=='nrp'){
			$nrp = $('input#numeroRegistroPatronal');
			if ($nrp.val() == "") {
				$nrp.focus();
				$('span#errorDatoNRP').css('color','red');
				$('span#errorDatoNRP').text('Número registro patronal es requerido.');
				return false;
			}
		}
		$('span#errorDatoRFC').text('');
		$('span#errorDatoNRP').text('');
		$.blockUI();
		var periodo = $('#anioPeriodo').val() + $('#mesPeriodo').val();
		$('#periodo').val(periodo);
		document.getElementById('busquedaComprobanteFiscalForm').submit();
	});
           */
      });
  </script>
    </head>
    <body style="background: lightslategrey;">
        <div>
    <div class="login" style="margin-top: 150px;">
      <h1>Registro de Usuario</h1>
      <form id="formRegistrar" method="post" action="${contextpath}/registrar">
        <p><input type="text" name="nombre" id="nombre" value="" placeholder="Nombre Completo" style="margin-left: -3px;"></p>
        <p><input type="text" name="email" id="email" value="" placeholder="Email" style="margin-left: -3px;"></p>
        <p><input type="password" name="password" id="password" value="" placeholder="Password" style="margin-left: -3px;"></p>
        <p><input type="password" name="confPassword" id="confPassword" value="" placeholder="Confirmar Password" style="margin-left: -3px;"></p>
        
        <p style="text-align: center;"> 
            Sexo: 
            <input type="radio" name="masculino" id="masculino"> Masculino
            <input type="radio" name="femenino" id="femenino"> Femenino
        </p>
        
        <p style="text-align: center;"> 
            Deseo Recibir Notificaciones: <input type="checkbox" id="notificar" name="notificar">
        </p>
        
        <p class="submit">
            <input id="limpiar" type="reset" name="limpiar" value="Limpiar">
            <input id="registrar" type="button" name="registrar" value="Registrar">
        </p>
      </form>
    </div>
    </div>
    </body>
</html>
