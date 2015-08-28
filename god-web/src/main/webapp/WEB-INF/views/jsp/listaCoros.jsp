<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<body>
    <div>
       <h4 style="text-align: center;" class="sub-header alert alert-info">Lista de Coros</h4>

          <div class="table-responsive">
            <table class="table table-striped" id="listaCoroCompleta">
              <thead>
                <tr>
                  
                  <th style="text-align: center">CORO</th>
                  <th style="text-align: center">NOMBRE</th>
                  <th style="text-align: center">ESTADO</th>
                  
                </tr>
              </thead>
              <tbody>
                
                <c:forEach items="${corosCompletos}" var="corocomp" varStatus="indice">
               <tr>
                
                <td style="text-align: center;width: 2%;"><a id="ref" href="#${corocomp.idCoro}">${corocomp.numCoro}</a></td>
                <td><a id="ref" href="#${corocomp.idCoro}">${corocomp.nombre}</a></td>
                    <c:choose>
                       <c:when test="${corocomp.activo == 2}">
                           <td style="text-align:center;">
                              <b class="glyphicon glyphicon-ok alert alert-success" style="margin-top:-4px;margin-bottom: -3px;"> Procesado</b>
                           </td>
                       </c:when>
                       <c:when test="${corocomp.activo == 1}">
                           <td style="text-align:center;">
                              <b class="glyphicon glyphicon-refresh alert alert-info" style="margin-top:-4px;margin-bottom: -3px;"> Validando</b>
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
</body>
</html>