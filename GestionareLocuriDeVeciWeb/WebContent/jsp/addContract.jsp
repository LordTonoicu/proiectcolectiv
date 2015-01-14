<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	    	document.getElementById("idLocDeVeci").value = parentDocument.getElementById("idLocDeVeciV"+parentRowId).value;
	    	
	    }	
	</script>
</head>

<body onload="getById()">

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
                    <h1 class="page-header">Adaugare contract</h1>
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
                                         <input type="hidden" id="idLocDeVeci" name="idLocDeVeci" class="form-control" />
                                        <div  class="form-group">
                                        
                                            <label> Nr contract </label>
                                            <input id="nrContract" name="nrContract" class="form-control">
                                        
                                        </div>
                                        
                                       
                                         <div  class="form-group">
                                             <label> Data Eliberare </label>
                                            <input type="date" id="dataEliberare" name="dataEliberare" class="form-control">
                                        
                                        </div>
                                         <div class="form-group">
                                         <label>Primul concesionar </label>
                                         <input type="hidden" id="cnpConcesionar1" name="cnpConcesionar1" class="form-control" readonly>
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
                                            
                                            <input type="hidden" id="cnpConcesionar2" name="cnpConcesionar2" class="form-control" readonly>
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
                                                                       
                                        <button type="submit" id="adaugaContract" name="adaugaContract" class="btn btn-primary" >Adauga Contract</button>
                                        
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
    
    <!-- addParcela validator -->
	<script type="text/javascript" src="js/validations/addParcelaValidator.js"></script>

</body>

</html>
