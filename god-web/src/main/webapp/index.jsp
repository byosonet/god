<%@ include file="./WEB-INF/views/layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Sólo a Dios la Gloria</title>
  <jsp:include page="./WEB-INF/views/layout/staticResources.jsp"></jsp:include>
  <script type="text/javascript">
      $(function(){ 
          var myVar;
           
            myVar = setInterval(alertFunc, 10);
            function alertFunc() {
                var operacion;
                var valor;
                var cantidad;
                valor = $('input#dial').val();
                cantidad = $('input#dial2').val();
                operacion = valor * cantidad;
                operacion.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
                $('span#total').text(operacion);
            }

          $('input#dial').knob();
          $('input#dial2').knob();
          var slider = document.getElementById('slider');
            noUiSlider.create(slider, {
                    start: [20],
                    connect: 'lower',
                    range: {
                            'min': 0,
                            'max': 100
                    },
                    pips: {
                        mode: 'values',
                        values: [20, 50, 80],
                        density: 12,
                        format: {to: updatePips}
                    }
            });
            
            function updatePips( value, type ){
                switch(true)   {
                    case (value === 20):
                        value = "<label>Familiar</label>";
                        break;
                    case (value === 80):
                        value = "<label>Personal</label>";
                        break;
                    case (value === 50):
                        value = "<label>Laboral</label>";
                        break;
                }
                return value;
            }
      });
  </script>
  <style>
             body{
                font:  150% comic sans ms;
                color: gray;
             }
  </style>
</head>
<body style="background: InactiveBorder">
     <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/god-web/" style="color:white;">Himnario Presbiteriano</a>
          </div>
          <div style="height: 1px;" aria-expanded="false" class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                  <a style="color:white;" aria-expanded="true" aria-haspopup="true" role="button" data-toggle="dropdown" class="navbar-brand dropdown-toggle" href="#">Menú </a>
                </li>
              </ul>
          </div>
        </div>
      </nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-sm-offset-0 col-md-12 col-md-offset-0 main">
            <h4 style="text-align: center;">Trámite Seguros Voluntarios</h4>
                <div class="row">
                    <div class="col-sm-6" style="margin-top: 30px;height: 100px">
                        <label class="font-bold">Tipo Seguro</label>
                        <div id="slider" class="noUi-target noUi-ltr noUi-horizontal noUi-background"></div>
                    </div>
                    <br>
                    <div class="col-sm-6">
                       <div>

                               <div class="alert alert-info table-responsive" style="background-color: #f9f9f9">
                                 <table class="table table-striped" id="cobertura">
                                   <thead>
                                    <tr>
                                      <th></th>
                                      <th>Cobertura</th>
                                      <th></th>

                                    </tr>
                                  </thead>
                                   <tbody>
                                        <tr>
                                            <td><label class="btn btn-sm btn-primary"><strong>8</strong></label> Fallecimiento</td>
                                            <td><label class="btn btn-sm btn-danger"><strong>4</strong></label> Vida</td>
                                            <td><label class="btn btn-sm btn-info"><strong>10</strong></label> Enfermedad</td>
                                         </tr>
                                         <tr>
                                            <td><label class="btn btn-sm btn-success"><strong>5</strong></label> Accidente</td>
                                            <td><label class="btn btn-sm btn-info"><strong>21</strong></label> Asalto</td>
                                            <td><label class="btn btn-sm btn-danger"><strong>12</strong></label> Robo</td>
                                         </tr>
                                         <tr>
                                            <td><label class="btn btn-sm btn-default"><strong>13</strong></label> Familiar</td>
                                            <td><label class="btn btn-sm btn-warning"><strong>16</strong></label> Infarto</td>
                                            <td><label class="btn btn-sm btn-success"><strong>4</strong></label> Embarazo</td>
                                         </tr>
                                   </tbody>
                                 </table>
                               </div>
                        </div>
                    </div>
                </div>
            
            <div class="row sub-header">
                    <h4 style="text-align: center">Calculadora de Seguro Voluntario</h4>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6" style="text-align: center">Seguro Familiar</div>
                <div class="col-md-6">
                    <div class="row col-sm-12">
                        <label class="control-label col-sm-3 col-xs-3" style="text-align: center;">Cant.</label>
                        <label class="control-label col-sm-3 col-xs-3" style="text-align: center;">Edad</label>
                        <label class="control-label col-sm-3 col-xs-3" style="text-align: center;">Familia</label>
                        <label class="control-label col-sm-3 col-xs-3" style="text-align: center;">$</label>
                    </div>
                    
                    <div class="row col-sm-12">
                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <input data-step="1" data-min="18" data-max="75" data-width="40" data-height="40" data-fgColor="#000000" id="dial" type="text" value="25" class="dial">
                        </div>
                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <input data-step="1" data-min="1" data-max="100" data-width="40" data-height="40" data-fgColor="#FF0000" id="dial2" type="text" value="50" class="dial">
                        </div>

                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <span class="glyphicon glyphicon-user"> HIJO</span> 
                        </div>

                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <span id="total"> $ 15,345.00</span> 
                        </div>
                        
                    </div>
                </div>
            </div>
            
            
            <br>
              <div class="row">
                <div class="col-md-6" style="text-align: center"></div>
                <div class="col-md-6">
                    <div class="row col-sm-12">
                    </div>
                    
                    <div class="row col-sm-12">
                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <input data-step="1" data-min="18" data-max="75" data-width="40" data-height="40" data-fgColor="#000000" id="dial" type="text" value="25" class="dial">
                        </div>
                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <input data-step="1" data-min="1" data-max="100" data-width="40" data-height="40" data-fgColor="#FF0000" id="dial2" type="text" value="50" class="dial">
                        </div>

                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <span class="glyphicon glyphicon-user"> HIJO</span> 
                        </div>

                        
                        <div class="col-sm-3 col-xs-3" style="text-align: center">
                            <span id="total"> $ 15,345.00</span> 
                        </div>
                        
                    </div>
                </div>
            </div>
            
        </div>
    </div>    
</div>
         

<br>
<br>
<br>
<br>
  <nav class="navbar navbar-inverse navbar-fixed-bottom">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="https://www.linkedin.com/pub/gustavo-ulises-trejo-armenta/94/aa6/262" style="font-size: 0.75em;color:white;">by Ulysses M@c</a>
            </div>
          </div>
</nav>
</body>
</html>
