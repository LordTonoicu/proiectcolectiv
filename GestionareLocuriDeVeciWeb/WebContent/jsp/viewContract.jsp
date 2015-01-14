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
		var idContract;
		window.onunload = refreshParent;
	    function refreshParent() {
	        window.opener.location.reload();
	        this.close();
	    }
	    function setFormsAndParseResponse(response)
	    {
	    	var tokens = response.split(";;;");
	    	document.getElementById("nrContract").value = idContract;
	    	document.getElementById("dataEliberare").value = tokens[0];
	    	document.getElementById("cnpConcesionar1").value = tokens[1];
	    	document.getElementById("cnpConcesionar2").value = tokens[2];
	    }
	    function requestContractById(id)
	    {
	    	var xmlHttpReq = new XMLHttpRequest();
			var params = "getContract=true&nrContract="+id;
			xmlHttpReq.open('POST', '../ContractServlet', true);
			xmlHttpReq.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xmlHttpReq.setRequestHeader("Content-length", params.length);
			xmlHttpReq.setRequestHeader("Connection", "close");
		
			xmlHttpReq.onreadystatechange = function() {
				if (xmlHttpReq.readyState == 4) {
					setFormsAndParseResponse(xmlHttpReq.responseText);
				}

			}
			xmlHttpReq.send(params);
		}
		function getById() {
			var parentDocument = window.opener.document;
			var parentRowId = window.opener.getId();
			document.getElementById("nrContract").value = "Se incarca...";
			document.getElementById("dataEliberare").value ="Se incarca...";
	    	document.getElementById("cnpConcesionar1").value = "Se incarca...";
	    	document.getElementById("cnpConcesionar2").value = "Se incarca...";
	    	idContract = parentDocument.getElementById("nrContractV"
					+ parentRowId).value;
			requestContractById(idContract);
			
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
                   
                    <h1 class="page-header"> Vizualizare contract</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                       
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="../ContractServlet" method="POST">
                                        <div  class="form-group">
                                             <label> Nr contract </label>
                                            <input  id="nrContract" name="nrContract" class="form-control" readonly/>
                                        
                                        </div>
                                        
                                       
                                         <div  class="form-group">
                                             <label> Data Eliberare </label>
                                            <input id="dataEliberare" name="dataEliberare" class="form-control" readonly/>
                                        
                                        </div>
                                        
                                        
                                       
                                       <div class="form-group">
                                         <label>Primul concesionar </label>
                                         <input id="cnpConcesionar1" name="cnpConcesionar1" class="form-control" readonly>
                                         
                                        
                                        </div>
                                                         
                                         <div  class="form-group"> 
                                           
                                            <label> Al doilea concesionar </label> 
                                            
                                            <input id="cnpConcesionar2" name="cnpConcesionar2" class="form-control" readonly>
	                                       
                                        </div>
                                     
                                                                       
                                      
                                        
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
