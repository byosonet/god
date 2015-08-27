<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sólo a Dios la Gloria</title>
        <script type="text/javascript" language="javascript" src="${contextpath}/static/resources/js/model/ModelUser.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                //OCULTANDO LOS DIVS DE LOS JSP
                var status;
                $('div#contactoJSP').hide();
                $('div#agregarCoroJSP').hide();
                $('div#perfilJSP').hide();
                $('div#avisoJSP').hide();
                
                      var listaCoroCompleta = $('#listaCoroCompleta')
                          .dataTable(
                              {
                              "aoColumns": [ {"bSearchable": true}, {"bSearchable": false}, {"bSearchable": false},{"bSearchable": false}],
                              "sPaginationType": "full_numbers",
                              "bPaginate": false,
                              "oLanguage" : {
                                  "sZeroRecords":   "No se encontro ningún resultado con el criterio de Busqueda.",
                                  "sSearch":        "Coro #:",
                                  "sInfo":          "",
                                  "sInfoEmpty":     "",
                                  "sInfoFiltered":  "",
                              }
                              });
                                                          
                    $('a#exit').click(function(){
                        muestraMsjSistemaSuccessIndex("Gracias por tu visita, Dios te bendiga.");
                    });          
                              
                              
                    $('a#ref').click(function(){
                        $.blockUI();
                        var a_href = $(this).attr('href');
                        var idCoro = a_href.split("#")[1]; 
                        $('input#idCoro').val(idCoro);

                        var urlAction = '${contextpath}' + '/coro';
                        document.getElementById('enviarCoro').action = urlAction;
                        document.getElementById('enviarCoro').method = 'POST';
                        document.getElementById('enviarCoro').submit();
                    });
                    
                    $('a#aviso').click(function(){
                            $('div#contenidoDinamico').hide();
                            $('div#agregarCoroJSP').hide();
                            $('div#perfilJSP').hide();
                            $('div#contactoJSP').hide();
                            $('div#avisoJSP').show();
                    }); 
                    
                    $('a#contacto').click(function(){
                            $('div#contenidoDinamico').hide();
                             $('div#agregarCoroJSP').hide();
                             $('div#perfilJSP').hide();
                            $('div#contactoJSP').show();
                            $('div#avisoJSP').hide();
                    }); 
                    
                    $('a#registrar').click(function(){
                            $('div#contenidoDinamico').hide();
                             $('div#agregarCoroJSP').show();
                            $('div#contactoJSP').hide();
                            $('div#perfilJSP').hide();
                            $('div#avisoJSP').hide();
                    });  
                    
                    $('a#consultar').click(function(){
                           $('div#contenidoDinamico').show();
                           $('div#contactoJSP').hide();
                           $('div#agregarCoroJSP').hide();
                           $('div#perfilJSP').hide();
                           $('div#avisoJSP').hide();
                    });  
                    
                    $('a#perfil').click(function(){
                           $('div#contenidoDinamico').hide();
                           $('div#contactoJSP').hide();
                           $('div#agregarCoroJSP').hide();
                           $('div#perfilJSP').show();
                           $('div#avisoJSP').hide();
                    });  
                    
                    $('button#limpiar').click(function(){
                        $('#formContacto')[0].reset();
                        $('#formRegistrar')[0].reset();
                        $('#formPerfil')[0].reset();
                    });
                    
                    //OPCION CONTACTO
                    $('button#bcontacto').click(function(){
                        var asunto = $('input#asunto');
                        var nombre = $('input#nombre');
                        var email = $('input#emailContacto');
                        var text = $('textArea#textarea');
                        if(asunto.val() === ""){
                            muestraMsjSistemaError('El asunto es requerido.');
                            return false;
                        }else if(nombre.val() === ""){
                            muestraMsjSistemaError('Tu nombre es requerido.');
                            return false;
                        }else if(email.val() === ""){
                            muestraMsjSistemaError('Tu email es requerido.');
                            return false;
                        }else if(text.val() === ""){
                            muestraMsjSistemaError('No puedes enviar tus comentarios en blanco.');
                            return false;
                        }
                        
                        $.blockUI();
                        $.ajax({
                                type: 'POST',
                                url:  '${contextpath}'+'/contacto/sistema',
                                data: $('form#formContacto').serialize(),
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
                    
                    
                        //OPCION REGISTRAR
                        $('button#bregistrar').click(function(){
                        var nombreCoro = $('input#nombreCoro');
                        var autor = $('input#autor');
                        var numCoro = $('input#numCoro');
                        var desccoro = $('textArea#desccoro');
                        if(nombreCoro.val() === ""){
                            muestraMsjSistemaError('El nombre del coro es requerido.');
                            return false;
                        }else if(autor.val() === ""){
                            muestraMsjSistemaError('El nombre del autor es requerido.');
                            return false;
                        }else if(numCoro.val() === ""){
                            muestraMsjSistemaError('El número del coro es requerido.');
                            return false;
                        }else if(desccoro.val() === ""){
                            muestraMsjSistemaError('Debes agregar el contenido del coro.');
                            return false;
                        }
                        
                        $.blockUI();
                        $.ajax({
                                type: 'POST',
                                url:  '${contextpath}'+'/agregar/coro',
                                data: $('form#formRegistrar').serialize(),
                                    success: function (data) {
                                       $.unblockUI();
                                       muestraMsjSistemaSuccessRegistrarCoro(data.mensaje);
                                },
                                   error: function(msj){
                                       status = JSON.parse(msj.responseText);
                                       $.unblockUI();
                                       muestraMsjSistemaError(status.mensaje);
                                    }
                          });
                    });
                    
                    
                    
                        //OPCION PERFIL
                        $('button#bperfil').click(function(){
                        var passwordUsuario = $('input#passwordUsuario');
                       
                        if(passwordUsuario.val() === ""){
                            muestraMsjSistemaError('Escribe tu nuevo password para actualizar.');
                            return false;
                        }
                        
                        $.blockUI();
                        $.ajax({
                                type: 'POST',
                                url:  '${contextpath}'+'/actualizar/usuario',
                                data: $('form#formPerfil').serialize(),
                                    success: function (data) {
                                       $.unblockUI();
                                       muestraMsjSistemaSuccessIndex(data.mensaje);
                                },
                                   error: function(msj){
                                       status = JSON.parse(msj.responseText);
                                       $.unblockUI();
                                       muestraMsjSistemaError(status.mensaje);
                                    }
                          });
                    });
                    
                    
                    
                    
                    //FUNCIONES DE DIALOGS DE SUCCESS Y ERROR
                            function muestraMsjSistemaError(msjStatus){
                            BootstrapDialog.show({
                             size: BootstrapDialog.SIZE_SMALL,
                             title: 'Mensaje del Sistema:',
                             closable: false,
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
                             size: BootstrapDialog.SIZE_SMALL,
                             title: 'Mensaje del Sistema:',
                             closable: false,
                             message: msjStatus,
                             type: BootstrapDialog.TYPE_SUCCESS,
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
                         
                         function muestraMsjSistemaSuccessRegistrarCoro(msjStatus){
                            BootstrapDialog.show({
                             size: BootstrapDialog.SIZE_SMALL,
                             title: 'Mensaje del Sistema:',
                             closable: false,
                             message: msjStatus,
                             type: BootstrapDialog.TYPE_SUCCESS,
                             cssClass: 'login-dialog',
                             buttons: [{
                                 icon: 'glyphicon glyphicon-check',
                                 label: 'OK',
                                 cssClass: 'btn-primary',
                                 action: function(dialog) {
                                     dialog.close();
                                        $.blockUI();
                                        var urlAction = '${contextpath}' + '/ingresar';
                                        document.getElementById('regresar').action = urlAction;
                                        document.getElementById('regresar').method = 'POST';
                                        document.getElementById('regresar').submit();
                                 }
                             }]
                         });
                         }
                         
                         
                         function muestraMsjSistemaSuccessIndex(msjStatus){
                            BootstrapDialog.show({
                             size: BootstrapDialog.SIZE_SMALL,
                             title: 'Mensaje del Sistema:',
                             closable: false,
                             message: msjStatus,
                             type: BootstrapDialog.TYPE_SUCCESS,
                             cssClass: 'login-dialog',
                             buttons: [{
                                 icon: 'glyphicon glyphicon-ok',
                                 label: 'ACEPTAR',
                                 cssClass: 'btn-primary',
                                 action: function(dialog) {
                                     dialog.close();
                                    $.blockUI();
                                    var urlAction = '${contextpath}';
                                    document.getElementById('index').action = urlAction;
                                    document.getElementById('index').method = 'GET';
                                    document.getElementById('index').submit();
                                 }
                             }]
                         });
                         }  
                }          
            );
        </script>
         <style>
             body{
                font:  150% comic sans ms;
                color: gray;
                font-size: 12.5px;
             }
         </style>
    </head>
    <body>
    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-12 col-sm-offset-0 col-md-10 col-md-offset-1 main">
          <center><h4 class="page-header" style="text-align: center;">Hola, <c:out value="${usuario}"/></h4></center>

          <div class="row placeholders">
            <div class="col-xs-3 col-sm-1">
                <a id="perfil" href="#"><img src="${contextpath}/static/resources/img/user.png" data-src="holder.js/50x50/auto/sky" class="img-responsive"></a>
              <h5>Perfil</h5>
              
            </div>
            <div class="col-xs-3 col-sm-1">
              <a id="registrar" href="#"><img src="${contextpath}/static/resources/img/add.png" data-src="holder.js/50x50/auto/vine" class="img-responsive"></a>
            <h5>Registrar</h5>
              
            </div>
            <div class="col-xs-3 col-sm-1">
                <a id="consultar" href="#"><img src="${contextpath}/static/resources/img/consultar.png" data-src="holder.js/50x50/auto/sky" class="img-responsive"></a>
              <h5>Consultar</h5>
              
            </div>
            
            <div class="col-xs-3 col-sm-1">
                <a id="contacto" href="#"><img src="${contextpath}/static/resources/img/mail.png" data-src="holder.js/50x50/auto/vine" class="img-responsive"></a>
              <h5>Contacto</h5>
              
            </div>
              
            <div class="col-xs-12 col-sm-8">
                <h4>Avisos</h4>  
                <h5 style="text-align: justify"><c:out value="${titulo}" escapeXml="false"/></h5>  
            </div>
          </div>
             
          <div id="contactoJSP"><jsp:include page="contacto.jsp"></jsp:include></div>
          <div id="agregarCoroJSP"><jsp:include page="agregarCoro.jsp"></jsp:include></div>
          <div id="perfilJSP"><jsp:include page="perfil.jsp"></jsp:include></div>
          <div id="avisoJSP"><jsp:include page="aviso.jsp"></jsp:include></div>
              
          <div id="contenidoDinamico">
          <h4 style="text-align: center;" class="sub-header alert alert-info">Lista de Coros</h4>

          <div class="table-responsive">
            <table class="table table-striped" id="listaCoroCompleta">
              <thead>
                <tr>
                  
                  <th style="text-align: center">CORO</th>
                  <th style="text-align: center">NOMBRE</th>
                  <th style="text-align: center">AUTOR</th>
                  <th style="text-align: center">ESTADO</th>
                  
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${corosCompletos}" var="corocomp" varStatus="indice">
               <tr>
                
                <td style="text-align: center;width: 2%;"><a id="ref" href="#${corocomp.idCoro}">${corocomp.numCoro}</a></td>
                <td><a id="ref" href="#${corocomp.idCoro}">${corocomp.nombre}</a></td>
                <td>${corocomp.autor}</td>
                    <c:choose>
                       <c:when test="${corocomp.activo == 1}">
                           <td style="text-align:center;">
                              <b class="glyphicon glyphicon-ok alert alert-success" style="margin-top:-4px;margin-bottom: -3px;"> Procesado</b>
                           </td>
                       </c:when>
                       <c:otherwise>
                          <td style="text-align:center;">
                             <b class="glyphicon glyphicon-remove alert alert-danger" style="margin-top:-4px;margin-bottom: -3px;"> Pendiente</b>
                           </td>
                       </c:otherwise>
                   </c:choose>
                </tr>    
                </c:forEach>
                
              </tbody>
            </table>
          </div>
          </div>
        </div>
      </div>
    </div>
    <form id="enviarCoro">
        <input type="hidden" id="idCoro" name="idCoro"/>
        <input type="hidden" id="userEmail" name="userEmail" value="${userEmail}">
        <input type="hidden" id="userPassword" name="userPassword" value="${userPassword}">
    </form>
    
    <form id="regresar">
        <input type="hidden" id="user" name="user" value="${userEmail}">
        <input type="hidden" id="password" name="password" value="${userPassword}">
    </form>
    
    <form id="index">
    </form>
    </body>
</html>
