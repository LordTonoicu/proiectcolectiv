<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	  
	    function getById(){
	    	var parentDocument = window.opener.document;
	    	var parentRowId = window.opener.getId();
	    	document.getElementById("denumire").value = parentDocument.getElementById("denumireV"+parentRowId).innerHTML;
	    	document.getElementById("idCimitir").value = parentDocument.getElementById("idCimitirV"+parentRowId).value;
	    	document.getElementById("adresa").value = parentDocument.getElementById("adresaV"+parentRowId).innerHTML;
	    	document.getElementById("nrLocuri").value = parentDocument.getElementById("nrLocuriV"+parentRowId).innerHTML;
	    	document.getElementById("nrParcele").value = parentDocument.getElementById("nrParceleV"+parentRowId).innerHTML;
	    	
	    }	
	    
	</script>
</head>

<body onload="getById()">

    <div id="wrapper">

        <!-- Navigation -->
       

        <div id="page-wrapper" style="position:fixed">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Update cimitir</h1>
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
                                    <form role="form" action="../CimitirServlet" method="POST">
	                                    <div  class="form-group">
	     									<input type="hidden" id="idCimitir" name="idCimitir" class="form-control">
	                                    </div>
	                                    <div  class="form-group">
	                                        <label>Denumire</label>
	                                        <input id="denumire" name="denumire" class="form-control">
	                                    
	                                    </div>
	                                    <div  class="form-group">
	                                        <label>Adresa</label>
	                                        <input id="adresa" name="adresa" class="form-control" value="">
	                                      
	                                    </div>                            
	                                    <button type="submit" id="updateCimitir" name="updateCimitir" class="btn btn-primary" >Salveaza Modificari</button>    
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
    
   	<!-- updateCimitir validator -->
	<script type="text/javascript" src="js/validations/updateCimitirValidator.js"></script>

</body>

</html>
