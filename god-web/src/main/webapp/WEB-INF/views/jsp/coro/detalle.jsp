<%@ include file="../../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sólo a Dios la Gloria</title>
    <script type="text/javascript">
      $(function(){
          $('button#back').click(function(){
              $.blockUI();
                var urlAction = '${contextpath}' + '/ingresar';
                document.getElementById('regresar').action = urlAction;
                document.getElementById('regresar').method = 'POST';
                document.getElementById('regresar').submit();
          });
      });
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
        <div class="col-sm-12 col-sm-offset-0 col-md-8 col-md-offset-2 main">
            <br>
            <center><h4 class="page-header">"<c:out value="${nombre}"/>"<br><u>(CORO <c:out value="${numCoro}"/>)</u></h4></center>
            <br>
        <center>
        
        <c:choose>
            <c:when test="${statusDescripcion}">
               <div style="width: 100%;text-align: justify;">
                   <font size="3" face="Verdana" color="black">
                    <strong>
                        <c:out value="${coro}" escapeXml="false"/>
                        <br><br>
                    </strong>
                    </font>
                </div>
            </c:when>
            <c:when test="${status == 1}">
              <div class="row alert alert-info" style="width: 100%;text-align: center;">
                   <strong><c:out value="${coro}"/></strong>
                </div>
            </c:when>
            <c:otherwise>
               <div class="row alert alert-danger" style="width: 100%;text-align: center;">
                   <strong><c:out value="${coro}"/></strong>
                </div>
            </c:otherwise>
        </c:choose>
        
                
        </center>
        <br>
        <center>
            <h4 class="page-header">
                <button id="back" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span> REGRESAR</button>
            </h4>
        </center>
        </div>
    </div>
  </div>
    <form id="regresar">
        <input type="hidden" id="cifrar" name="cifrar" value="${cifrar}">
    </form>
    </body>
</html>