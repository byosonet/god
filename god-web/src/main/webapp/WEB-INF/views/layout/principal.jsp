<%@ include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<jsp:include page="staticResources.jsp"></jsp:include>
</head>
<body>
    <div id="cuerpo">
        <div id="header">
            <tiles:insertAttribute name="header" />
        </div>
        <div id="contenido">
            <tiles:insertAttribute name="contenido" />
        </div>
        <div id="footer">
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
</body>
</html>