<%@ include file="../../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coro #520</title>
    <script type="text/javascript">
      $(function(){
          $('a#back').click(function(){
              console.log(' -- Regresar');
          });
      });
  </script>
    </head>
    <body style="background: white;">
    <div class="row">
        <div class="col-sm-12 col-sm-offset-4 col-md-8 col-md-offset-2 main">
            <br>
            <center><h4 class="page-header"><c:out value="${nombre}"/></h4></center>
            <br>
        <center>
        <div style="width: 100%;text-align: justify;">
            <font size="3" face="Verdana" color="black">
            <strong>
                
                <c:out value="${coro}" escapeXml="false"/>
                
                <br><br>
            </strong>
            </font>
        </div>
        </center>
        <br>
        <center><h4 class="page-header"><a id="back">REGRESAR</a></h4></center>
    </div>
  </div>
    </body>
</html>