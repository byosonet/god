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
    <body style="background-image: url(/god-web/static/resources/img/fondo.gif)">
        <table id="example" class="display" cellspacing="0" width="100%" style="font-size: 12px;">
        <thead>
            <tr>
                <th style="text-align: center">ID</th>
                <th style="text-align: center">NOMBRE</th>
                <th style="text-align: center">AUTOR</th>
                <th style="text-align: center">FECHA ACT.</th>
            </tr>
        </thead>
 
        <tbody style="text-align: center;">
            <c:forEach items="${coros}" var="coro" varStatus="indice">
               <tr>
                <td>${coro.idCoro}</td>
                <td><a href="http://localhost:8084/god-web/coro/${coro.idCoro}">${coro.nombre}</a></td>
                <td>${coro.autor}</td>
                <td>${coro.fechaAct}</td>
                </tr>    
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>
