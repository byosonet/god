<%@ include file="../../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coro #520</title>
    </head>
    <body style="background: white;">
    <div style="text-align: center;">
            
            <br><div style="font-size: 18px">Coro # <c:out value="${idCoro}"/></div>
            
        <center>
        <div style="width: 50%;text-align: justify; margin-top:50px;">
            <font size="3" face="Verdana" color="black">
            <strong>
                
                <c:out value="${coro}"/>
                
                <br><br>
            </strong>
            </font>
        </div>
        </center>
        <br>
        <form id="ingresar" method="get" action="${contextpath}/lista/obtener">
            <p style="text-align: center;"><input id="button" type="submit" value="REGRESAR AL MENU"></p>
        </form>
  </div>
    </body>
</html>
