$(document).ready(function(){
	$( "#adaugaLocDeVeci" ).click(function() {
		if ($("#suprafata").val() == "" || $("#numar").val()==""){
			event.preventDefault();
			alert("Va rugam sa introduceti date valide!");
		}
	});
})