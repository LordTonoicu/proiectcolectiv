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
	    	document.getElementById("nrCerere").value=parentDocument.getElementById("nrCerereV"+parentRowId).innerHTML;
	    	console.log(parentDocument.getElementById("dataInregistrareV"+parentRowId).innerHTML);
	    	document.getElementById("cnpConcesionar").value = parentDocument.getElementById("cnpConcesionarV"+parentRowId).innerHTML;
	       	document.getElementById("dataInregistrare").value = parentDocument.getElementById("dataInregistrareV"+parentRowId).innerHTML;
	       	document.getElementById("stadiuSolutionare").value = parentDocument.getElementById("stadiuSolutionareV"+parentRowId).innerHTML;
	    		    	
	    }	
	</script>
</head>

<body onload="loadData()">

    <%@ page import="domain.*" %>
    <%@ page import="dto.*" %>
	<%@ page import="java.util.ArrayList" %>
	<jsp:useBean id="listConcesionari" class="java.util.ArrayList" scope="session"/>
	<jsp:setProperty name="listConcesionari" property="*"/> 

    <div id="wrapper">

        <!-- Navigation -->
       

        <div id="page-wrapper" style="position:fixed">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Actualizare cerere inhumare</h1>
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
                                    <form role="form" action="../CerereInhumareServlet" method="POST">
                                        <div  class="form-group">
                                            
                                            <input type="hidden" id="nrCerere" name="nrCerere" class="form-control" />
                                        
                                        </div>
                                        
                                       
                                         <div  class="form-group">
                                             <label> Data Inregistrare </label>
                                            <input id="dataInregistrare" name="dataInregistrare" class="form-control" />
                                        
                                        </div>
                                        
                                        <div  class="form-group">
                                             <label> Stadiu Solutionare </label>
                                            <input id="stadiuSolutionare" name="stadiuSolutionare" class="form-control" />
                                        
                                        </div>
                                        
                                        
                                       
                                       <div class="form-group">
                                         <label>Concesionar </label>
                                         <input id="cnpConcesionar" name="cnpConcesionar" class="form-control" readonly>
                                                                         
                                         <select onchange="document.getElementById('cnpConcesionar').value = this.value" class="form-control">
                 							<option value="" class="form-control"></option>
                                        <% 
											int i=0;
											for(Object obj : listConcesionari){
												i++;	
												 
												 ConcesionarDTO concesionar = (ConcesionarDTO)obj;
												 DatePersonale dateP = concesionar.getDatePersonale();
												 Concesionar con = concesionar.getConcesionar();
											      
											%>
											 
											 <option value=<%=con.getCnpConcesionar()%> class="form-control"> <%=dateP.getNume()+" "+dateP.getPrenume()+" ( "+con.getCnpConcesionar()+" )"%></option>
												
												<%}
												 %>
											 
											</select>
                                        
                                        </div>
                                                                                            
                                                                       
                                        <button type="submit" id="updateCerere" name="updateCerere" class="btn btn-primary" >Salveaza Modificari</button>
                                        
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
    
    <!-- addConcesionar validator -->
	<script type="text/javascript" src="js/validations/addConcesionarValidator.js"></script>

</body>

</html>
