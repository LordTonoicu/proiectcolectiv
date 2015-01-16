$(document).ready(function(){
	$( "#adaugaParcela" ).click(function() {
		if ($("#denumire").val() == ""){
			event.preventDefault();
			alert("Va rugam sa introduceti date valide!");
		}
	});
})