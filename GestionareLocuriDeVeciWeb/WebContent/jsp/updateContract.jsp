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
	    	document.getElementById("nrContract").value=parentDocument.getElementById("nrContractV"+parentRowId).innerHTML;
	    	console.log(parentDocument.getElementById("cnpConcesionar1V"+parentRowId).innerHTML);
	    	document.getElementById("cnpConcesionar1").value = parentDocument.getElementById("cnpConcesionar1V"+parentRowId).innerHTML;
	    	
	    	document.getElementById("cnpConcesionar2").value = parentDocument.getElementById("cnpConcesionar2V"+parentRowId).innerHTML;
	    	document.getElementById("dataEliberare").value = parentDocument.getElementById("dataEliberareV"+parentRowId).innerHTML;
	    	
	    	
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
                    <h1 class="page-header">Actualizare contract</h1>
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
                                    <form role="form" action="../ContractServlet" method="POST">
                                        <div  class="form-group">
                                            
                                            <input type="hidden" id="nrContract" name="nrContract" class="form-control" />
                                        
                                        </div>
                                        
                                       
                                         <div  class="form-group">
                                             <label> Data Eliberare </label>
                                            <input type="date" id="dataEliberare" name="dataEliberare" class="form-control" />
                                        
                                        </div>
                                        
                                        
                                       
                                       <div class="form-group">
                                         <label>Primul concesionar </label>
                                         <input id="cnpConcesionar1" name="cnpConcesionar1" class="form-control" readonly>
                                         <select onchange="document.getElementById('cnpConcesionar1').value = this.value" class="form-control">
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
                                                         
                                         <div  class="form-group"> 
                                           
                                            <label> Al doilea concesionar </label> 
                                            
                                            <input id="cnpConcesionar2" name="cnpConcesionar2" class="form-control" readonly>
	                                        <select onchange="document.getElementById('cnpConcesionar2').value = this.value" class="form-control">
                 								<option value="" class="form-control"></option>
                                        <% 
											int j=0;                                      		
											for(Object obj : listConcesionari){
												j++;	
												 
												 ConcesionarDTO concesionar = (ConcesionarDTO)obj;
												 DatePersonale dateP = concesionar.getDatePersonale();
												 Concesionar con = concesionar.getConcesionar();
											      
											%>
											 
											 <option value=<%=con.getCnpConcesionar()%> class="form-control"> <%=dateP.getNume()+" "+dateP.getPrenume()+" ( "+con.getCnpConcesionar()+" )"%></option>
												
												<%}
												 %>
											 
											</select>
	                                        
                                        </div>
                                     
                                                                       
                                        <button type="submit" id="updateContract" name="updateContract" class="btn btn-primary" >Salveaza Modificari</button>
                                        
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
