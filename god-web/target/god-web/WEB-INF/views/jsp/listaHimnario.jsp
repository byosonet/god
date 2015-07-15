<%@ include file="../taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Himnario</title>
        
        <link rel="shortcut icon" href="${contextpath}/static/resources/img/favicon.ico">
        
        <link rel="stylesheet" type="text/css" href="${contextpath}/static/resources/css/dataTables.css">
        <script type="text/javascript" language="javascript" src="${contextpath}/static/resources/js/jquery/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" language="javascript" src="${contextpath}/static/resources/js/jquery/dataTables.min.js"></script>
        
    
        <script type="text/javascript">
      $(document).ready(function() {
            var example = $('#example')
                .dataTable(
                    {
                    "searching": true,
                    "sPaginationType": "full_numbers",
                    "oLanguage" : {
                            "sProcessing":    "Procesando...",
                    "sLengthMenu":    "Mostrar _MENU_ registros",
                    "sZeroRecords":   "No se encontraron resultados",
                    "sEmptyTable":    "Ningún dato disponible en esta tabla",
                    "sInfo":          "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoEmpty":     "Mostrando registros del 0 al 0 de un total de 0 registros",
                    "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
                    "sInfoPostFix":   "",
                    "sSearch":        "Buscar:",
                    "sUrl":           "",
                    "sInfoThousands":  ",",
                    "sLoadingRecords": "Cargando...",
                    "oPaginate": {
                        "sFirst":    "Primero",
                        "sLast":    "Ultimo",
                        "sNext":    "Siguiente",
                        "sPrevious": "Anterior"
                    },
                    "oAria": {
                        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                    }
                    },
                    "bLengthChange" : false,
                    "bFilter" : false,
                    "bProcessing" : false,
                    "iDeferLoading" : 0,
                    "bSort" : false
                    });
        } );
    </script>
    </head>
    <body style="background:ButtonFace;">
        <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>N° Coro</th>
                <th>Nombre</th>
                <th>Autor</th>
                <th>Ultima Fecha de Actualización</th>
                <th>Descripción</th>
            </tr>
        </thead>
 
        <tbody>
            <tr>
                <td>520</td>
                <td>Bendice, ¡ oh, alma mía!</td>
                <td>Robert Lopez</td>
                <td>23/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>525</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
            <tr>
                <td>527</td>
                <td>Feliz, Feliz Cumpleaños</td>
                <td>Nery Lopez</td>
                <td>10/07/2010</td>
                <td><a href="http://localhost:8084/god-web/">Ver detalle</a></td>
            </tr>
        </tbody>
    </table>
    </body>
</html>
