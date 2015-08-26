<%@ include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title><tiles:insertAttribute name="title"/></title>
<jsp:include page="staticResources.jsp"></jsp:include>
</head>
<body style="background: InactiveBorder">
    <div id="cuerpo">
        <div id="header">
            <tiles:insertAttribute name="header" />
        </div>
        <div id="contenido">
            <tiles:insertAttribute name="contenido" />
        </div>
        <br>
        <br>
        <div id="footer">
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
</body>
</html>