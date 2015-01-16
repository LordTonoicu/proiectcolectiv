$(document).ready(function(){
	$( "#updateCerere" ).click(function() {
		if ($("#nrCerere").val() == "" || $("#dataInregistrare").val()==""|| $("#stadiuSolutionare").val()==""|| $("#cnpConcesionar").val()==""){
			event.preventDefault();
			alert("Va rugam sa introduceti date valide!");
		}
	});
})
