<%@ include file="../layout/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<jsp:include page="staticResources.jsp"></jsp:include>
</head>
<body style="background: lightslategrey;">
    <div id="cuerpo">
	<tiles:insertAttribute name="contenido" />
    </div>
</body>
</html>