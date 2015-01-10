$(document).ready(function(){
	$( "#adaugaDecedat" ).click(function() {
		if ($("#NumeDecedat").val() == "" || $("#PrenumeDecedat").val()=="" ||
				$("#CnpDecedat").val()=="" || $("#DateInmormantareDecedat").val()=="" || 
				$("#NrAdeverintaInhumareDecedat").val()=="" ){
			event.preventDefault();
			alert("Va rugam sa completati toate campurile!");
		}
	});
})
