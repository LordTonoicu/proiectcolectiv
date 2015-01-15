<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

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
	<script>
	 window.onunload = refreshParent;
	  	function refreshParent() {
	        window.opener.location.reload();
	        this.close();
	    }
	  
	    function loadData(){
	    	var parentDocument = window.opener.document;
	    	var parentRowId = window.opener.getId();
	    	document.getElementById("idConcesionar").value=parentDocument.getElementById("idConcesionar"+parentRowId).value;
	    	document.getElementById("nume").value = parentDocument.getElementById("nume"+parentRowId).innerHTML;
	    	document.getElementById("prenume").value = parentDocument.getElementById("prenume"+parentRowId).innerHTML;
	    	document.getElementById("domiciliu").value = parentDocument.getElementById("addrDomiciliu"+parentRowId).innerHTML;
	    	document.getElementById("cnp").value = parentDocument.getElementById("cnp"+parentRowId).innerHTML;
	    	document.getElementById("nrChitanta").value = parentDocument.getElementById("nrChitanta"+parentRowId).innerHTML;
	    	
	    }	
	</script>
</head>

<body onload="loadData()">

    <div id="wrapper">

        <!-- Navigation -->
       

        <div id="page-wrapper" style="position:fixed">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Actualizare concesionar</h1>
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
                                    <form role="form" action="../ConcesionarServlet">
                                    <div class="form-group">
                                    		<input type="hidden" name="idConcesionar" id="idConcesionar"/>
                                            <label>Nume</label>
                                            <input id="nume" name="nume" class="form-control">
                                        
                                        </div>
                                        <div class="form-group">
                                            <label>Prenume</label>
                                            <input id="prenume" name="prenume" class="form-control">
                                        
                                        </div>
                                        <div class="form-group">
                                            <label>Domiciliu</label>
                                            <input id="domiciliu" name="domiciliu" class="form-control">
                                        
                                        </div>
                                        <div class="form-group">
                                            <label>CNP</label>
                                            <input id="cnp" name="cnp" class="form-control">
                                          
                                        </div>
                                        <div class="form-group">
                                            <label>Nr chitanta</label>
                                            <input id="nrChitanta" name="nrChitanta" class="form-control">
                                       
                                        </div>                                  
                                         <button id="updateConcesionar" name="updateConcesionar" type="submit" class="btn btn-primary">Salveaza Modificarile</button>
                                        
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
    
    <!-- updateConcesionar validator -->
	<script type="text/javascript" src="js/validations/updateConcesionarValidator.js"></script>

</body>

</html>
