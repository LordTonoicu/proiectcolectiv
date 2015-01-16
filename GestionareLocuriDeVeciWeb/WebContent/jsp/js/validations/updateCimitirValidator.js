$(document).ready(function(){
	$( "#updateCimitir" ).click(function() {
		if ($("#denumire").val() == "" || $("#adresa").val()==""){
			event.preventDefault();
			alert("Va rugam sa introduceti date valide!");
		}
	});
})