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
            
  </style>
</head>
<body>
     <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/god-web/" style="color:white;"></a>
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
        <div class="col-sm-12 col-sm-offset-0 col-md-10 col-md-offset-1 main">
            <h2 style="text-align: left;">Paso 1: Cotizar Seguro</h2>
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
                                            <td><label class="btn btn-sm btn-primary"><strong>08</strong></label> Fallecimiento</td>
                                            <td><label class="btn btn-sm btn-danger"><strong>04</strong></label> Vida</td>
                                            <td><label class="btn btn-sm btn-info"><strong>10</strong></label> Enfermedad</td>
                                         </tr>
                                         <tr>
                                            <td><label class="btn btn-sm btn-success"><strong>05</strong></label> Accidente</td>
                                            <td><label class="btn btn-sm btn-info"><strong>21</strong></label> Asalto</td>
                                            <td><label class="btn btn-sm btn-danger"><strong>12</strong></label> Robo</td>
                                         </tr>
                                         <tr>
                                            <td><label class="btn btn-sm btn-default"><strong>13</strong></label> Familiar</td>
                                            <td><label class="btn btn-sm btn-warning"><strong>16</strong></label> Infarto</td>
                                            <td><label class="btn btn-sm btn-success"><strong>04</strong></label> Embarazo</td>
                                         </tr>
                                   </tbody>
                                 </table>
                               </div>
                        </div>
                    </div>
                </div>
            
            <div class="row col-md-12 sub-header">
                    <h4 style="text-align: left;">Calculadora de Seguro</h4>
            </div>
            <br>
            
            <div class="row">
                <div class="col-md-6" style="text-align: left;">
                    
                    <div class="row col-sm-12 sub-header">
                     <br>
                     <span class="control-label col-sm-1 col-xs-2 glyphicon glyphicon-tasks" style="font-size: 2em;"></span>
                     <label class="control-label col-sm-11 col-xs-10">Usted está comprando: <br>Seguro de Salud para la Familia.</label>
                    </div>
                    
                     <div class="row col-sm-12 sub-header">
                     <br>
                     <span class="control-label col-sm-1 col-xs-2 glyphicon glyphicon-credit-card" style="font-size: 2em;"></span>
                     <label class="control-label col-sm-11 col-xs-10">Forma de Pago: <br>Pago mensual a través de la Línea de captura.</label>
                    </div>
                    
                    <div class="row col-sm-12 sub-header">
                     <br>
                    <label style="text-align: center;" class="control-label col-sm-4 col-xs-4">Cantidad</label>
                    <label style="text-align: center;" class="control-label col-sm-4 col-xs-3">Edad</label>
                    <label style="text-align: left;" class="control-label col-sm-4 col-xs-5">Parentesco</label>
                    </div>
                    
                    
                    <div class="row col-sm-12 sub-header">
                     <br>
                        <div class="col-sm-4 col-xs-3" style="text-align: center;">
                            <input data-step="1" data-min="0" data-max="10" data-width="40" data-height="40" data-fgColor="#000000" id="dial" type="text" value="2" class="dial">
                        </div>
                        <div class="col-sm-4 col-xs-3" style="text-align: center;">
                            <input data-step="1" data-min="0" data-max="10" data-width="40" data-height="40" data-fgColor="#000000" id="dial" type="text" value="2" class="dial">
                        </div>
                        <div class="col-sm-4 col-xs-6" style="text-align: center;">
                            <span class="control-label col-sm-1 col-xs-1 glyphicon glyphicon-user"></span>
                            <span class="control-label col-sm-3 col-xs-5">HIJO</span>
                        </div>
                    </div>
                    
                     <div class="row col-sm-12">
                         <br>
                         <label style="text-align: center;" class="control-label col-sm-3 col-xs-2"></label>
                         <span class="control-label col-sm-2 col-xs-1"></span>
                         <span style="text-align: center;" class="control-label col-sm-3 col-xs-2"></span>
                         <input class="control-label col-sm-4 col-xs-6 btn btn-primary" type="button" value="AGREGAR"/>
                     </div>
                    
                </div>
                
                <div class="col-md-1"></div>
                
                <div class="col-md-5">
                    
                    <div class="row col-sm-12 sub-header">
                        <br>
                        <label class="control-label col-sm-6 col-xs-6" style="text-align: center;margin-top: 15px;">Integrantes:</label>
                        <div class="col-sm-6 col-xs-6" style="text-align: center;margin-top: 7px;">
                            <input data-step="1" data-min="0" data-max="10" data-width="40" data-height="40" data-fgColor="#000000" id="dial" type="text" value="2" class="dial">
                        </div>
                    </div>
                   
                     <div class="row col-sm-12 sub-header">
                         <br>
                         <label style="text-align: center;" class="control-label col-sm-3 col-xs-2">4</label>
                         <span class="control-label col-sm-2 col-xs-1 glyphicon glyphicon-user"></span>
                         <span style="text-align: center;" class="control-label col-sm-3 col-xs-2">HIJO</span>
                         <label style="text-align: right;" class="control-label col-sm-4 col-xs-6">$ 10,430.00</label>
                     </div>
                    
                    <div class="row col-sm-12 sub-header">
                         <br>
                         <label style="text-align: center;" class="control-label col-sm-3 col-xs-2">2</label>
                         <span class="control-label col-sm-2 col-xs-1 glyphicon glyphicon-user"></span>
                         <span style="text-align: center;" class="control-label col-sm-3 col-xs-2">PADRE</span>
                         <label style="text-align: right;" class="control-label col-sm-4 col-xs-6">$ 2,433.10</label>
                     </div>
                    
                     <div class="row col-sm-12 sub-header">
                         <br>
                         <label style="text-align: center;" class="control-label col-sm-3 col-xs-2">3</label>
                         <span class="control-label col-sm-2 col-xs-1 glyphicon glyphicon-user"></span>
                         <span style="text-align: center;" class="control-label col-sm-3 col-xs-2">MADRE</span>
                         <label style="text-align: right;" class="control-label col-sm-4 col-xs-6">$ 1,000.00</label>
                     </div>
                    
                    <div class="row col-sm-12 sub-header">
                         <br>
                         <label style="text-align: center;" class="control-label col-sm-3 col-xs-2"></label>
                         <span class="control-label col-sm-2 col-xs-1"></span>
                         <span style="text-align: center;" class="control-label col-sm-3 col-xs-2">TOTAL</span>
                         <label style="text-align: right;" class="control-label col-sm-4 col-xs-6">$ 13,433.10</label>
                     </div>
                    
                     <div class="row col-sm-12">
                         <br>
                         <label style="text-align: center;" class="control-label col-sm-3 col-xs-2"></label>
                         <span class="control-label col-sm-2 col-xs-1"></span>
                         <span style="text-align: center;" class="control-label col-sm-3 col-xs-2"></span>
                         <input class="control-label col-sm-4 col-xs-6 btn btn-primary" type="button" value="CONTRATAR"/>
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
