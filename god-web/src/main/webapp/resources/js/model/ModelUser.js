$( document ).ready( function() {
function UserModel(email,nombre) {
    var self = this;
    self.nombre = ko.observable(nombre);
    self.email = ko.observable(email);
    
    this.recuperar = function() {
        var mail =  this.email();
        $.ajax({
            type: 'POST',
            url: '/god-web/localizar/email',
            data: ko.toJSON({ email: mail }),
            contentType: "application/json",
            dataType: "json",
                success: function (data) {
                   self.nombre(data.mensaje);
            }
	    });        
    };
}
ko.applyBindings(new UserModel("example@gmail.com",""));
} );

/*
 <div style="text-align: center">
    <form id="localiza">
    <p>INGRESA TU EMAIL: <input id="email" data-bind="value: email"/></p>
    <p>NOMBRE DEVUELTO:  <input data-bind="value: nombre" disabled/></p>
    <button data-bind="click: recuperar">CONSULTAR EMAIL</button>
    </form>
</div>
 */