$(document).ready(function(){
	$( "#adaugaConcesionar" ).click(function() {
		if ($("#domiciliu").val() == "" || $("#cnp").val()=="" ||
				$("#nrChitanta")==val() || $("#prenume").val()=="" || $("nume").val()==""){
			event.preventDefault();
			alert("Va rugam sa introduceti date valide!");
		}
	});
})