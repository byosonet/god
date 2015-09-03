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
                              "aoColumns": [ {"bSearchable": true}, {"bSearchable": false}, {"bSearchable": false}],
                              "sPaginationType": "full_numbers",
                              "bPaginate": true,
                              "bLengthChange" : false,
                              "pageLength": 5,
                              "oLanguage" : {
                                    "sProcessing":     "Procesando...",
                                    "sLengthMenu":     "Mostrar _MENU_ registros",
                                    "sZeroRecords":    "No se encontraron resultados",
                                    "sEmptyTable":     "Ningún dato disponible en esta tabla",
                                    "sInfo":           "",
                                    "sInfoEmpty":      "",
                                    "sInfoFiltered":   "",
                                    "sInfoPostFix":    "",
                                    "sSearch":         "<span class='glyphicon glyphicon-search'></span>",
                                    "sUrl":            "",
                                    "sInfoThousands":  ",",
                                    "sLoadingRecords": "Cargando...",
                                    "oPaginate": {
                                        "sFirst":    "",
                                        "sLast":     "",
                                        "sNext":     "",
                                        "sPrevious": ""
                                    },
                                    "oAria": {
                                        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                                    }
                              }
                              });
                              
                              
                      var listaBitacora = $('#listaBitacora')
                          .dataTable(
                              {
                              "aoColumns": [ {"bSearchable": false}, {"bSearchable": true}, {"bSearchable": false}],
                              "sPaginationType": "full_numbers",
                              "bPaginate": true,
                              "bLengthChange" : false,
                              "pageLength": 10,
                              "bSort" : false,
                              "oLanguage" : {
                                    "sProcessing":     "Procesando...",
                                    "sLengthMenu":     "Mostrar _MENU_ registros",
                                    "sZeroRecords":    "No se encontraron resultados",
                                    "sEmptyTable":     "Ningún dato disponible en esta tabla",
                                    "sInfo":           "",
                                    "sInfoEmpty":      "",
                                    "sInfoFiltered":   "",
                                    "sInfoPostFix":    "",
                                    "sSearch":         "<span class='glyphicon glyphicon-search'></span>",
                                    "sUrl":            "",
                                    "sInfoThousands":  ",",
                                    "sLoadingRecords": "Cargando...",
                                    "oPaginate": {
                                        "sFirst":    "",
                                        "sLast":     "",
                                        "sNext":     "",
                                        "sPrevious": ""
                                    }
                              }
                              });
                                                          
                    $('a#exit').click(function(){
                        $.blockUI();
                        $.ajax({
                                type: 'POST',
                                url:  '${contextpath}'+'/sistema/salir',
                                data: $('form#regresar').serialize(),
                                 success: function (data) {
                                       $.unblockUI();
                                       muestraMsjSistemaSuccessIndex("Gracias por tu visita, Dios te bendiga.");
                                }  
                          });
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
                         
                         $('a#menuSpan').click(function(){
                            if( $('div#menuPrincipal').is(":visible") ){
                                $('div#menuPrincipal').css('display','none');
                            }else{
                               $('div#menuPrincipal').css('display','block');
                            }
                         });
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
          <div style="text-align:center"><a href="#" class="glyphicon glyphicon-th-large" style="font-size: 2.5em;" id="menuSpan"></a></div>
          <br>
          <div class="row placeholders" id="menuPrincipal">
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
                <c:choose>
                       <c:when test="${detalle == ''}">
                         <h5 style="text-align: center"><c:out value="${titulo}" escapeXml="false"/></h5> 
                       </c:when>
                       <c:otherwise>
                         <h5 style="text-align: justify"><c:out value="${titulo}" escapeXml="false"/></h5>
                       </c:otherwise>
                </c:choose> 
            </div>
          </div>
          <div id="contactoJSP"><jsp:include page="contacto.jsp"></jsp:include></div>
          <div id="agregarCoroJSP"><jsp:include page="agregarCoro.jsp"></jsp:include></div>
          <div id="perfilJSP"><jsp:include page="perfil.jsp"></jsp:include></div>
          <div id="avisoJSP"><jsp:include page="aviso.jsp"></jsp:include></div>
          <div id="contenidoDinamico"><jsp:include page="listaCoros.jsp"></jsp:include></div>
        </div>
      </div>
    </div>
    
    <form id="regresar">
        <input type="hidden" id="cifrar" name="cifrar" value="${cifrar}">
    </form>
    
    <form id="index">
    </form>
    </body>
</html>
