<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Himnario</title>
        <jsp:include page="../layout/staticResources.jsp"></jsp:include>
        <script type="text/javascript" language="javascript" src="${contextpath}/static/resources/js/model/ModelUser.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                //OCULTANDO LOS DIVS DE LOS JSP
                var status;
                $('div#contactoJSP').hide();
                
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
                              
                     var listaCoroActualizada = $('#listaCoroActualizada')
                          .dataTable(
                              {
                              "sPaginationType": "full_numbers",
                              "bPaginate": false,
                              "bFilter": false,
                              "bInfo": false,
                              "oLanguage" : {
                                  "sZeroRecords":   "No se encontro ningún resultado con el criterio de Busqueda.",
                                  "sSearch":        "Buscar:",
                                  "sInfo":          "",
                                  "sInfoEmpty":     "",
                                  "sInfoFiltered":  "",
                              }

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
                    
                    $('a#contacto').click(function(){
                            $('div#contenidoDinamico').hide();
                            $('div#contactoJSP').show();
                    });  
                    
                    $('a#consultar').click(function(){
                           $('div#contenidoDinamico').show();
                           $('div#contactoJSP').hide();  
                    });  
                    
                    
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
                }          
            );
        </script>
         <style>
             body{
                font:  150% comic sans ms;
                color: gray;
             }
         </style>
    </head>
    <body>
    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-12 col-sm-offset-0 col-md-10 col-md-offset-1 main">
          <center><h4 class="page-header">Hola, <c:out value="${usuario}"/></h4></center>

          <div class="row placeholders">
            <div class="col-xs-4 col-sm-1">
              <img src="${contextpath}/static/resources/img/user.png" data-src="holder.js/50x50/auto/sky" class="img-responsive">
              <h5>Perfil</h5>
              
            </div>
            <div class="col-xs-4 col-sm-1">
              <img src="${contextpath}/static/resources/img/add.png" data-src="holder.js/50x50/auto/vine" class="img-responsive">
              <h5>Registrar</h5>
              
            </div>
            <div class="col-xs-4 col-sm-1">
                <a id="consultar" href="#"><img src="${contextpath}/static/resources/img/consultar.png" data-src="holder.js/50x50/auto/sky" class="img-responsive"></a>
              <h5>Consultar</h5>
              
            </div>
            <div class="col-xs-4 col-sm-1">
              <img src="${contextpath}/static/resources/img/descargar.png" data-src="holder.js/50x50/auto/vine" class="img-responsive">
              <h5>Descargar</h5>
              
            </div>
            <div class="col-xs-4 col-sm-1">
              <img src="${contextpath}/static/resources/img/historial.png" data-src="holder.js/50x50/auto/vine" class="img-responsive">
              <h5>Favoritos</h5>
              
            </div>  
            <div class="col-xs-4 col-sm-1">
                <a id="contacto" href="#"><img src="${contextpath}/static/resources/img/mail.png" data-src="holder.js/50x50/auto/vine" class="img-responsive"></a>
              <h5>Contacto</h5>
              
            </div>
              
            <div class="col-xs-12 col-sm-6">
                <h4>Avisos</h4>  
                <h5 style="text-align: justify">El día 9 de agosto de 2015 se llevo a cabo el culto especial de acción de gracias por el VIII aniversario de la Iglesia Nacional Presbiteriana ¡SIDON TIAKIL! del municipio de Oschuc, Chiapas. <a href="#">Seguir leyendo <span class="glyphicon glyphicon-arrow-right"/></a></h5>  
            </div>
          </div>
             
          <div id="contactoJSP"><jsp:include page="contacto.jsp"></jsp:include></div>    
              
          <div id="contenidoDinamico">
          <h3 style="text-align: center;" class="sub-header alert alert-info">Consultar</h3>
          
          <h4 class="sub-header" style="text-align: center;">Lo más recientes</h4>
          <div class="table-responsive">
            <table class="table table-striped" id="listaCoroActualizada">
              <thead>
                <tr>
                  
                  <th style="text-align: center">NOMBRE</th>
                  <th style="text-align: center">AUTOR</th>
                  <th style="text-align: center">FECHA ACTUALIZACIÓN</th>
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${coros}" var="coro" varStatus="indice">
               <tr>
                
                <td><a id="ref" href="#${coro.idCoro}">${coro.nombre}</a></td>
                <td>${coro.autor}</td>
                <td style="text-align: center">
                    <fmt:formatDate value="${coro.fechaAct}" pattern="dd/MM/yyyy HH:mm:ss" />
                </td>
                </tr>    
                </c:forEach>
                
              </tbody>
            </table>
          </div>
          
          <br><br>
          <h4 class="sub-header" style="text-align: center;">Himnario Evángelico</h4>
          <div class="table-responsive">
            <table class="table table-striped" id="listaCoroCompleta">
              <thead>
                <tr>
                  
                  <th style="text-align: center">NÚMERO DE CORO</th>
                  <th style="text-align: center">NOMBRE</th>
                  <th style="text-align: center">AUTOR</th>
                  <th style="text-align: center">FECHA ACTUALIZACIÓN</th>
                  
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${corosCompletos}" var="coroc" varStatus="indice">
               <tr>
                
                <td style="text-align: center;"><a id="ref" href="#${coroc.idCoro}">${coroc.numCoro}</a></td>
                <td><a id="ref" href="#${coroc.idCoro}">${coroc.nombre}</a></td>
                <td>${coroc.autor}</td>
                <td style="text-align: center">
                    <fmt:formatDate value="${coroc.fechaAct}" pattern="dd/MM/yyyy HH:mm:ss" />
                </td>
                
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
    </body>
</html>
