$(document).ready(function(){
	$( "#updateContract" ).click(function() {
		if ($("#nrContract").val() == "" || $("#dataEliberare").val()==""|| $("#cnpConcesionar1").val()==""|| $("#cnpConcesionar2").val()==""){
			event.preventDefault();
			alert("Va rugam sa introduceti date valide!");
		}
	});
})
