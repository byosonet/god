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
                $('div#contactoJSP').hide();
                
                      var listaCoroCompleta = $('#listaCoroCompleta')
                          .dataTable(
                              {
                              "sPaginationType": "full_numbers",
                              "bPaginate": false,
                              "oLanguage" : {
                                  "sZeroRecords":   "No se encontro ningún resultado con el criterio de Busqueda.",
                                  "sSearch":        "Buscar:",
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
                }          
            );
        </script>
         <style>
             body{
                font: bold 130% tahoma,verdana,arial;
                color: #000;
             }
         </style>
    </head>
    <body>
    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-12 col-sm-offset-0 col-md-8 col-md-offset-2 main">
          <center><h4 class="page-header">Hola, <c:out value="${usuario}"/></h4></center>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-2 placeholder">
              <img src="${contextpath}/static/resources/img/user.png" data-src="holder.js/100x100/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Perfil</h4>
              <span class="text-muted">Información de Usuario</span>
            </div>
            <div class="col-xs-6 col-sm-2 placeholder">
              <img src="${contextpath}/static/resources/img/add.png" data-src="holder.js/100x100/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Registrar</h4>
              <span class="text-muted">Agregar nuevos Himnos</span>
            </div>
            <div class="col-xs-6 col-sm-2 placeholder">
                <a id="consultar" href="#"><img src="${contextpath}/static/resources/img/consultar.png" data-src="holder.js/100x100/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail"></a>
              <h4>Consultar</h4>
              <span class="text-muted"><a id="consultar" href="#">Himnario Presbiteriano</a></span>
            </div>
            <div class="col-xs-6 col-sm-2 placeholder">
              <img src="${contextpath}/static/resources/img/descargar.png" data-src="holder.js/100x100/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Descargar</h4>
              <span class="text-muted">Impresión Documentos</span>
            </div>
            <div class="col-xs-6 col-sm-2 placeholder">
              <img src="${contextpath}/static/resources/img/historial.png" data-src="holder.js/100x100/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Favoritos</h4>
              <span class="text-muted">Lo más visto de esta semana</span>
            </div>  
            <div class="col-xs-6 col-sm-2 placeholder">
                <a id="contacto" href="#"><img src="${contextpath}/static/resources/img/mail.png" data-src="holder.js/100x100/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail"></a>
              <h4>Contacto</h4>
              <span class="text-muted"><a id="contacto" href="#">Acerca de nosotros</a></span>
            </div>
          </div>
             
          <div id="contactoJSP"><jsp:include page="contacto.jsp"></jsp:include></div>    
              
          <div id="contenidoDinamico">
          <h3 class="sub-header" style="text-align: center;">Lo más recientes</h3>
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
