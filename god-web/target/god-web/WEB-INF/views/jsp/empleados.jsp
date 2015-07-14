<html>
    <head>
        <title>Lista de Empleados</title>
        <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript">
         $(document).ready(function() {
                $("input#generar").click(function(){
                console.log(' -- Click en generar:::::');
                $.ajax({
                   type: "GET",
                   url: "http://localhost:8084/HimnarioPresbiteriano/empleados",
                   success: function (data) {
                             var obj = data;
                            $('div#tableEmpleados').html('<table style="width:100%;;text-align:center;">'
                            +'<tr>'
                            +  '<td>Nombre</td>'
                            +  '<td>Apellido</td>'		
                            + ' <td>Edad</td>'
                            +'</tr>'
                            +'<tr>'
                            +  '<td>'+obj[0].nombre+'</td>'
                            +  '<td>'+obj[0].apellido+'</td>'		
                            +  '<td>'+obj[0].edad+'</td>'
                            +'</tr>'
                            +'<tr>'
                            +  '<td>'+obj[1].nombre+'</td>'
                            +  '<td>'+obj[1].apellido+'</td>'		
                            +  '<td>'+obj[1].edad+'</td>'
                            +'</tr>'
                          +'</table>');
                        }
                    });
                });
        });
        </script>
    <style>
        table, th, td {
            border: 1px solid black;
            padding: 5px;
        }
        table {
            border-spacing: 15px;
        }
    </style>
    </head>
    <body>
        <h1>Lista de empleados Obtenida</h1>
        <input type="button" name="Generar" value="Generar" id="generar">
        <br>
        <div id="tableEmpleados"></div>
    </body>
</html>