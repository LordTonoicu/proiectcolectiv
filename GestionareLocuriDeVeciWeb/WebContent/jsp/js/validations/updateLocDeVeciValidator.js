$(document).ready(function(){
	$( "#updateLocDeVeci" ).click(function() {
		if ($("#numar").val() == "" || $("#suprafata").val() == ""){
			event.preventDefault();
			alert("Va rugam sa completati campurile!");
		}
	});
})