<%@ include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<jsp:include page="staticResources.jsp"></jsp:include>
</head>
<body style="background-image: url(/god-web/static/resources/img/fondo.gif)">
    <div id="cuerpo">
	<tiles:insertAttribute name="contenido" />
    </div>
</body>
</html>