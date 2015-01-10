$(document).ready(function(){
	$( "#adaugaConcesionar" ).click(function() {
		if ($("#Domiciliu").val() == "" || $("#Cnp").val()=="" ||
				$("#NumarChitanta")==val() || $("#IdLocDeVeci").val()==""){
			event.preventDefault();
			alert("Va rugam sa completati toate campurile!");
		}
	});
})