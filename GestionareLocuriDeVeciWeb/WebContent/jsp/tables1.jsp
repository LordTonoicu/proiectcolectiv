<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.registers.InregRegAnualDeProgrInmormantari"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestionare locuri de veci</title>

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

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../StartServlet">Gestionare locuri de veci</a>
            </div>


            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <form action="../GetByParcelaLocDeVeciServlet" method="POST">
                            <div class="input-group custom-search-form">
                                <input type="text" name="DenParcela" class="form-control" placeholder="Parcela" style="width:90px; margin-right: 5px">
                                <input type="text" name="nrLoc" class="form-control" placeholder="Nr loc" style="width:80px">
                                <span class="input-group-btn">
                    
                                    <button class="btn btn-default" type="submit">
                                        <i class="fa fa-search"></i>
                                        
                                    </button>
                                </span>
                            </div>
                            </form>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Gestiune<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../CimitirServlet">Cimitire</a>
                                </li>
                                <li>
                                    <a href="../ConcesionarServlet">Concesionari</a>
                                </li>
                                <li>
                                    <a href="../DecedatServlet">Decedati</a>
                                </li>
                                <li>
                                	<a href="../DecedatFaraApartinatoriServlet">Decedati fara apartinatori</a>
                                </li>
                                <li> 
                                    <a href="../ContractServlet">Cereri</a>
                                </li>
                                 <li>
                                    <a href="../CerereInhumareServlet">Cereri Inhumare</a>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Rapoarte <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                               
                                <li>
                                    <a href="../StartServlet">Istoric modificari</a>
                                </li>
                                <li>
                                    <a href="../ExpirateServlet">Locuri de veci expirate</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Registre<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../Table1Servlet">Registru anual de programare a inmormantarilor</a>
                                </li>
                                <li>
                                    <a href="../Table2Servlet">Registru de morminte</a>
                                </li>
                                <li>
                                    <a href="../Table3Servlet">Registru de morminte-monumente funerare</a>
                                </li>
                                <li>
                                    <a href="../Table4Servlet">Registrul index anual al decedatilor</a>
                                </li>
                                <li>
                                    <a href="../Table5Servlet">Registru anual de evidenta a decedatilor fara apartinatori</a>
                                </li>
                                <li>
                                    <a href="../Table6Servlet">Registrul cu evidenta cererilor de atribuire a locurilor de inhumare</a>
                                </li>
                                 <li>
                                    <a href="../Table7Servlet">Registrul anual de evidenta a contractelor de concesiune</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Registre </h1>

                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    <form action="../Table1Servlet" action="POST"> 
                        <div class="panel-heading">
                            Registrul anual de programare a inmormantarilor
                            
                              <button class="btn btn-primary" type="submit" name="exportExcel" style="float:right;margin-top:-7px;margin-right:10px">
                                    Exporta Excel

                            </button>
                        </div>
                       </form>

                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    
                                        <tr>
                                            <th>Nume</th>
                                            <th>Prenume</th>
                                            <th>Religie</th>
											<th>Cimitir</th>                                            	
                                            <th>Parcela</th>
                                            <th>Nr. Loc</th>
                                            <th>Data inmormantarii</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    	ArrayList<InregRegAnualDeProgrInmormantari> registru = (ArrayList<InregRegAnualDeProgrInmormantari>) request.getSession().getAttribute("registru1");
                                    	
                                    	for(InregRegAnualDeProgrInmormantari inregistrare : registru)
                                    	{
                                    		
                                    %>
                                        <tr class="odd gradeX">
                                            <td><%=inregistrare.getNumeDecedat()%></td>
                                            <td><%=inregistrare.getPrenumeDecedat() %></td>
                                            <td><%=inregistrare.getReligieDecedat()%></td>
                                            <td><%=inregistrare.getCimitir()%></td>
                                            <td><%=inregistrare.getParcela()%></td>
                                            <td><%=inregistrare.getNrLoc()%></td>
                                            <td><%=inregistrare.getDataInmormantarii()%></td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                              
                        </div>
                        <!-- /.panel-body -->

                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
           
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
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

    <!-- DataTables JavaScript -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
    </script>

</body>

</html>
