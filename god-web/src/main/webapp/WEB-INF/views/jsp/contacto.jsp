<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<body>
    <div>
        <h3 class="page-header" style="text-align: center;">Contacto</h3>
        <br>
        <form class="form-horizontal" role="form">
            
            <div class="form-group">
              <label class="control-label col-sm-2" for="pwd">Nombre:</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="nombre" placeholder="Ingresa tu nombre">
              </div>
              
              <label class="control-label col-sm-1" for="email">Email:</label>
              <div class="col-sm-4">
                <input type="email" class="form-control" id="email" placeholder="Ingesa tu email">
              </div>
              
            </div>

            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10" style="text-align: right;">
                  <button type="reset" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span> LIMPIAR</button>
                  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span> ENVIAR</button>
              </div>
            </div>
        </form>
        
        
    </div>
</body>
</html>