$(document).ready(function(){
	$( "#updateDecedat" ).click(function() {
		if ($("#NumeDecedat").val() == "" || $("#PrenumeDecedat").val()=="" ||
				$("#CnpDecedat").val()=="" || $("#DateInmormantareDecedat").val()=="" || 
				$("#NrAdeverintaInhumareDecedat").val()=="" || $("#Religie").val()=="" ||
				$("#nrAdeverintaAsistenta").val()==""){
			event.preventDefault();
			alert("Va rugam sa completati toate campurile!");
		}
	});
})