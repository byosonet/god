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
                    "sPaginationType": "full_numbers",
                    "bPaginate": false,
                    "oLanguage" : {
                        "sZeroRecords":   "No se encontro ningún resultado con el criterio de Busqueda.",
                        "sSearch":        "Buscar Coro #:",
                        "sInfo":          "",
                        "sInfoEmpty":     "",
                        "sInfoFiltered":  "",
                    }
                   
                    });
        } 
                
            
            
            );
    </script>
    </head>
    <body>
        <table id="example" class="display" cellspacing="0" width="40%" style="font-size: 12px;">
        <thead>
            <tr>
                <th>#</th>
                <th>Coro</th>
            </tr>
        </thead>
 
        <tbody style="text-align: center;">
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>521</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Feliz Cumpleaños</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://11.254.13.76:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
        </tbody>
    </table>
    </body>
</html>
