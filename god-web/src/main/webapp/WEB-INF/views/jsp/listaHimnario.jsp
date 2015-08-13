<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Himnario</title>
        <jsp:include page="../layout/staticResources.jsp"></jsp:include>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">GOD WEB</a>
            </div>
          </div>
        </nav>

    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-12 col-sm-offset-3 col-md-8 col-md-offset-2 main">
          <center><h2 class="page-header">HOLA BIENVENIDO: <c:out value="${usuario}"/></h2></center>

          <div class="row placeholders">
            <div class="col-xs-12 col-sm-3 placeholder">
              <img src="${contextpath}/static/resources/img/user.png" data-src="holder.js/100x100/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Perfil</h4>
              <span class="text-muted">Información de Usuario</span>
            </div>
            <div class="col-xs-12 col-sm-3 placeholder">
              <img src="${contextpath}/static/resources/img/add.png" data-src="holder.js/100x100/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Registrar</h4>
              <span class="text-muted">Agregar nuevos Himnos</span>
            </div>
            <div class="col-xs-12 col-sm-3 placeholder">
              <img src="${contextpath}/static/resources/img/consultar.png" data-src="holder.js/100x100/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Consultar</h4>
              <span class="text-muted">Estado de las Solicitudes</span>
            </div>
            <div class="col-xs-12 col-sm-3 placeholder">
              <img src="${contextpath}/static/resources/img/descargar.png" data-src="holder.js/100x100/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Descargar</h4>
              <span class="text-muted">Impresión Documentos</span>
            </div>
          </div>

          <h3 class="sub-header">Ultimas actualizaciones</h3>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>NOMBRE</th>
                  <th>AUTOR</th>
                  <th>FECHA ACTUALIZACIÓN</th>
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${coros}" var="coro" varStatus="indice">
               <tr>
                <td>${coro.idCoro}</td>
                <td><a href="http://<spring:message code="url.href.server"/>/god-web/coro/${coro.idCoro}">${coro.nombre}</a></td>
                <td>${coro.autor}</td>
                <td>
                    <fmt:formatDate value="${coro.fechaAct}" pattern="dd/MM/yyyy HH:mm:ss" />
                </td>
                </tr>    
                </c:forEach>
                
              </tbody>
            </table>
          </div>
          
          <h3 class="sub-header">Lista del Himnario</h3>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>NOMBRE</th>
                  <th>AUTOR</th>
                  <th>FECHA ACTUALIZACIÓN</th>
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${corosCompletos}" var="coroc" varStatus="indice">
               <tr>
                <td>${coroc.idCoro}</td>
                <td><a href="http://<spring:message code="url.href.server"/>/god-web/coro/${coroc.idCoro}">${coroc.nombre}</a></td>
                <td>${coroc.autor}</td>
                <td>
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
    </body>
</html>
