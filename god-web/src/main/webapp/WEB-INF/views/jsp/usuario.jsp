<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
    <div class="container-fluid">
       <h4 style="text-align: center;" class="sub-header">Usuarios Registrados</h4>
          <div class="table-responsive">
            <table class="table" id="listaUsuario">
              <thead>
                <tr>
                  <th style="text-align: center" class="alert alert-dismissible">NOMBRE</th>
                  <th style="text-align: center" class="alert alert-dismissible">FECHA ALTA</span></th>
                  <th style="text-align: center" class="alert alert-dismissible">ULT. CONEXION</span></th>
                  <th style="text-align: center" class="alert alert-dismissible">CORREO</span></th>
                  <th style="text-align: center" class="alert alert-dismissible">PROFESI&Oacute;N</span></th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${listaUsuario}" var="user" varStatus="indice">
               <tr>
                    <td style="text-align: left;width: 2%;">${user.nombre}</td>
                    <td style="text-align: center;">
                        <fmt:formatDate value="${user.fechaAlta}" pattern="dd/MM/yyyy HH:mm:ss" />
                    </td>    
                    <td style="text-align: center;">
                        <fmt:formatDate value="${user.ultConexion}" pattern="dd/MM/yyyy HH:mm:ss" />
                    </td>
                    <td style="text-align: left;width: 2%;">${user.email}</td>
                    <td style="text-align: left;width: 2%;">${user.actividad}</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
    </div>