$(document).ready(function(){
	$( "#adaugaCimitir" ).click(function() {
		if ($("#Denumire").val() == "" || $("#Adresa").val()==""){
			event.preventDefault();
			alert("Va rugam sa completati toate campurile!");
		}
	});
})
