<%@ include file="../layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Himnario</title>
        <jsp:include page="../layout/staticResources.jsp"></jsp:include>
    
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
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>521</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Feliz Cumpleaños</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
            <tr>
                <td>520</td>
                <td><a href="http://localhost:8084/god-web/coro/520">Hay Momentos</a></td>
            </tr>
            
        </tbody>
    </table>
    </body>
</html>
