<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  	
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>

  window.onunload = refreshParent;
  function refreshParent() {
      window.opener.location.reload();
      this.close();
  }
  function getById(){
  	var parentDocument = window.opener.document;
  	var parentRowId = window.opener.getId();
  	document.getElementById("idLocDeVeci").value = parentDocument.getElementById("idLocDeVeciV"+parentRowId).value;
  	document.getElementById("idDecedat").value = parentDocument.getElementById("idDecedatV"+parentRowId).value;
 	document.getElementById("CnpDecedat").value = parentDocument.getElementById("cnpDecedatV"+parentRowId).value;
 	document.getElementById("NumeDecedat").value = parentDocument.getElementById("numeDecedatV"+parentRowId).value;
 	document.getElementById("PrenumeDecedat").value = parentDocument.getElementById("prenumeDecedatV"+parentRowId).value;
 	document.getElementById("Religie").value = parentDocument.getElementById("religieV"+parentRowId).innerHTML;
 	document.getElementById("DateInmormantareDecedat").value = parentDocument.getElementById("dataInmormantareV"+parentRowId).innerHTML;
 	document.getElementById("NrAdeverintaInhumareDecedat").value = parentDocument.getElementById("nrAdeverintaV"+parentRowId).innerHTML;
 	document.getElementById("NrAdeverintaAsistenta").value = parentDocument.getElementById("nrAdeverintaAsistentaV"+parentRowId).innerHTML;
 		 
  }
</script>
 
  

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="overflow: hidden" onload="getById()">
    	<%@ page import="domain.*" %>
	<%@ page import="java.util.ArrayList" %>
	<jsp:useBean id="listLocuriDeVeci" class="java.util.ArrayList" scope="session"/>
	<jsp:setProperty name="listLocuriDeVeci" property="*"/> 

    <div id="wrapper">

        <!-- Navigation -->
       

        <div id="page-wrapper" style="position:fixed">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Actualizare decedat</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Completati toate campurile
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="../DecedatServlet" method="POST">
                                        <div class="form-group">
                                            <input type="hidden" class="form-control"  id="idLocDeVeci" name="idLocDeVeci">
                                       		<input type="hidden" class="form-control" id="idDecedat" name="idDecedat">
                                       	
                                        </div>
                                        <div class="form-group">
                                            <label>Nume</label>
                                            <input class="form-control"  id="NumeDecedat" name="NumeDecedat">
                                       
                                        </div>
                                           <div class="form-group">
                                            <label>Prenume</label>
                                            <input class="form-control" id="PrenumeDecedat" name="PrenumeDecedat">
                                       
                                        </div>
                                        <div class="form-group">
                                            <label>Cnp Decedat</label>
                                            <input class="form-control"  id="CnpDecedat" name="CnpDecedat">
                                        
                                        </div>
                                        <div class="form-group">
                                            <label>Data inmormantare</label>
                                            <input type="date"  id="DateInmormantareDecedat" name="DateInmormantareDecedat" class="form-control">
                                          
                                        </div>
                                       
                                        <div class="form-group">
                                            <label>Nr adeverinta inhumare</label>
                                            <input class="form-control"  id="NrAdeverintaInhumareDecedat" name="NrAdeverintaInhumareDecedat">
                                          
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Religie</label>
                                            <input class="form-control"  id="Religie" name="Religie">
                                          
                                        </div>
                                        
                                         <div class="form-group">
                                            <label>Nr adeverinta asistenta</label>
                                            <input class="form-control"  id="NrAdeverintaAsistenta" name="NrAdeverintaAsistenta">
                                          
                                        </div>
                                        
                                        <button type="submit" class="btn btn-primary" name="updateDecedat" id="updateDecedat">Salvare Modificari</button>
                                        
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                               
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/sb-admin-2.js"></script>
    
   	<!-- addDecadat validator -->
	<script type="text/javascript" src="js/validations/addDecedatValidator.js"></script>

</body>

</html>
