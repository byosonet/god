<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<body>
    <div>
        <h3 class="alert alert-info" style="text-align: center;">Contacto</h3>
        <br>
        
        <center>
        <div style="width: 100%;text-align: justify;">
            <font face="Arial" color="gray">
                <hr><blockquote>
                    God-Web nace de la idea de un proyecto como apoyo a la Iglesia Nacional Presbiteriana de México
                    para el acceso digital al Himnario Evángelico "Solo a Dios la Gloria", aun estamos en fase de desarrollo,                  pero tu opinión es muy importante para nosotros, así que no dudes en dejarnos tus comentarios.</blockquote>   <hr>                          
                </blockquote></hr>
            </font>
        </div>
        </center>
                
        <br>
        <form class="form-horizontal" role="form">
            
             <div class="form-group">
              <label class="control-label col-sm-1" for="asunto">Asunto:</label>
              <div class="col-sm-11">
                <input type="text" class="form-control" id="asunto" name="asunto" placeholder="Asunto">
              </div>
            </div>
            
            <div class="form-group">
              <label class="control-label col-sm-1" for="nombre">Nombre:</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa tu nombre">
              </div>
              
              <label class="control-label col-sm-1" for="email">Email:</label>
              <div class="col-sm-5">
                <input type="email" class="form-control" id="email" name="email" placeholder="Ingesa tu email">
              </div>
              
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-12" for="comenatario" style="text-align: left;">Escribe tus comentarios:</label>
            </div>
            
            <div class="form-group">
              <div class="col-sm-12">
                  <textArea class="form-control" id="textarea" name="textarea" placeholder="Gracias por ponerte en contacto." style="height: 200px;"></textarea>
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