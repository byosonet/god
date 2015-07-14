<%@ include file="../taglibs.jsp"%>

<link rel="icon" href="${staticResourcesPath}/iconos/favicon.ico" />

<!-- GobMx -->
<!-- <link href="http://cdn.imss.gob.mx/assets/main.css" rel="stylesheet"> -->
<!-- <link href="http://framework-gb.cdn.gob.mx/qa/assets/styles/main.css" rel="stylesheet"> -->
<!-- <link type="text/css" href="${staticResourcesPath}/gobmx-imss/assets/main.css" rel="stylesheet" /> -->
<link type="text/css" href="${staticResourcesPath}/gobmx-main/assets/styles/main.css" rel="stylesheet" />

<!-- Bootstrap -->
<!-- <link type="text/css" href="${staticResourcesPath}/estilos/bootstrap/bootstrap.min.css" rel="stylesheet" /> -->
<!-- <link type="text/css" href="${staticResourcesPath}/estilos/bootstrap/pygments-manni.css" rel="stylesheet" /> -->
<!-- <link type="text/css" href="${staticResourcesPath}/estilos/bootstrap/bootstrap-tooltip.css" rel="stylesheet" /> -->
<!-- <link type="text/css" href="${staticResourcesPath}/estilos/bootstrap/bootstrap-popover.css" rel="stylesheet" /> -->
<link type="text/css" href="${staticResourcesPath}/estilos/bootstrap/DT_bootstrap.css" rel="stylesheet" />

<!-- Jquery-->
<link type="text/css" href="${staticResourcesPath}/estilos/jquery/ui-lightness/jquery-ui.css" rel="stylesheet" />

<!-- Fonts -->
<link type="text/css" href="${staticResourcesPath}/estilos/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- JGrowl -->
<link type="text/css" href="${staticResourcesPath}/estilos/jquery/jquery.jgrowl.css" rel="stylesheet" />

<!-- Jqplot -->
<link type="text/css" href="${staticResourcesPath}/estilos/jquery/jquery.jqplot.min.css" rel="stylesheet" />
<link type="text/css" href="${staticResourcesPath}/estilos/jquery/morris.css" rel="stylesheet" />

<!-- IMSS -->
<link type="text/css" href="${staticResourcesPath}/estilos/imss/portal.css" rel="stylesheet" />
<!--[if IE]> <link href="${staticResourcesPath}/estilos/imss/ie.css" type="text/css" rel="stylesheet" /><![endif]-->

<!-- jQuery -->
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/jquery.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/dtable/jquery.dataTables.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/dtable/jquery.dataTables.pagination.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/dtable/jquery.dataTables.sort.date.plugin.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/jquery-post-json.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/form2Object/form2object.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/form2Object/jquery.toObject.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/jquery.alphanum.js"></script>

<!-- Bootstrap -->
<c:if test="${ param.isGobMxIncluded ne true}">
	<script type="text/javascript" src="${staticResourcesPath}/js/bootstrap/bootstrap.min.js"></script>
</c:if>
<script type="text/javascript" src="${staticResourcesPath}/js/bootstrap/DT_bootstrap.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/bootstrap/bootstrap-tooltip.js"></script>
<c:if test="${ param.isGobMxIncluded ne true}">
	<script type="text/javascript" src="${staticResourcesPath}/js/bootstrap/bootstrap-popover.js"></script>
</c:if>

<!-- jQuery UI -->
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/jquery-ui.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/jquery.ui.datepicker-es.js"></script>

<!-- JSON -->
<script type="text/javascript" src="${staticResourcesPath}/js/json/json2.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/json/json.min.js"></script>

<!-- Cometd -->
<script type="text/javascript" src="${staticResourcesPath}/js/org/cometd.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/org/cometd/AckExtension.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/org/cometd/ReloadExtension.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/org/cometd/TimeStampExtension.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/org/cometd/TimeSyncExtension.js"></script>

<!-- Cometd and Jquery-->
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.cookie.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.cometd.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.cometd-ack.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.cometd-reload.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.cometd-timestamp.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.cometd-timesync.js"></script>

<!-- JGrowl -->
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/comet/jquery.jgrowl.js"></script>

<!-- JQPlot -->
<script type="text/javascript" src="${staticResourcesPath}/js/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/jqplot/jqplot.pieRenderer.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/morris/morris.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/morris/raphael.min.js"></script>

<!-- Generales DELTA -->
<script type="text/javascript" src="${staticResourcesPath}/js/delta/general.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/delta/CometConector.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/delta/gestionCtrlSelect.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/delta/procesaErrores.js"></script>
<script type="text/javascript" src="${staticResourcesPath}/js/delta/limpiaFormularios.js"></script>

<!-- html5 enabled -->
<script type="text/javascript" src="${staticResourcesPath}/js/delta/html5.js"></script>

<!-- Scripts de "Procesando..." -->
<script type="text/javascript" src="${staticResourcesPath}/js/jquery/blockUI/jquery.blockUI.js"></script>