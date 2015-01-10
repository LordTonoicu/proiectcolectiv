$(document).ready(function(){
	$( "#updateParcela" ).click(function() {
		if ($("#denumireParcela").val() == ""){
			event.preventDefault();
			alert("Va rugam sa completati campul!");
		}
	});
})