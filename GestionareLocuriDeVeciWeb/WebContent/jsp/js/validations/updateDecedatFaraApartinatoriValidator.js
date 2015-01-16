$(document).ready(function(){
	$("#updateDecedatFaraApartinator").click(function() {
		if ($("#NumeDecedat").val() == "" || $("#PrenumeDecedat").val()=="" ||
				$("#CnpDecedat").val()=="" || $("#DateInmormantareDecedat").val()=="" || 
				$("#NrAdeverintaInhumareDecedat").val()=="" || $("#Religie").val()=="" ||
				$("#NrAdeverintaAsistenta").val()==""){
			event.preventDefault();
			alert("Va rugam sa completati toate campurile!");
		}
	});
})