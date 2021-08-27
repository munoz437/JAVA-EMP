<%-- 
    Document   : index
    Created on : 28/08/2019, 07:45:35 PM
    Author     : JLME
--%>

<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.List"%>
<%@page import="clases.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Empleados</title>
        <link href="bootstrap-4/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap-4/js/jquery.js" type="text/javascript"></script>
        <script src="bootstrap-4/js/bootstrap.js" type="text/javascript"></script>
    </head>
    <!--body--------------------------------------------------------------BODY-->
    <body>

        <nav  class="navbar navbar-expand-lg  navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Jorge Muñoz</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contacto</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sub Menu</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Ingenieria Sistemas</a>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input id="txt_buscar" name="txt_buscar" class="form-control mr-sm-2" type="number" placeholder="Buscar Id" aria-label="Search">
                    <button id="btn_buscar" name="btn_buscar" class="btn btn-outline-secondary my-2 my-sm-0 " type="button" data-toggle="modal" data-target="#miModal">Buscar</button>
                </form>
            </div>
        </nav>

        <!--<h1>Formulario Estudiante</h1>-->
        <button type="button"  class="btn btn-danger  btn-lg" data-toggle="modal" data-target="#miModal">
            Nuevo
        </button><!------------------------------------------BOTON NUEVO-->

        <div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">DATOS EMPLEADO</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    <div class="modal-body">
                        <div>

                            <form action="sr_prueba" method="post" class="form-group" ><!--onsubmit="return enviar();"--> 
                                  <input type="text"class="form-control" id="txt_id" name="txt_id" placeholder="0"  readonly="" required>


                                <input type="text"class="form-control" id="txt_nombres" name="txt_nombres" placeholder="Nombre 1 Nombre 2" required>

                                <input type="text" class="form-control"id="txt_apellidos" name="txt_apellidos" placeholder="Apellido 1 Apellido 2" required>

                                <input type="text" class="form-control"id="txt_direccion" name="txt_direccion" placeholder="Direccion Completa">

                                <input type="number" class="form-control"id="txt_telefono" name="txt_telefono" placeholder="Telefono" >

                                <input type="number" class="form-control" id="txt_carne" name="txt_carne" placeholder="DPI">
                                <!--pattern="[E]{1}[0-9]{3}" title="Formato Incorrecto...(E001)" required--> 

                                <input type="date" class="form-control"id="txt_fn" name="txt_fn" placeholder="Fecha Nacimiento" required>

                                <input type="text" class="form-control"id="txt_correo" name="txt_correo" placeholder="Fecha de Ingreso">

                                <select id="drop_sangre" class="form-control" name="drop_sangre" required>
                                    <%
                                        Estudiante clsEstudiante = new Estudiante();
                                        List<List<String>> lista = clsEstudiante.combo_tipo_sangre();
                                        for (int i = 0; i < lista.get(0).size(); i++) {
                                            out.println("<option value='" + lista.get(0).get(i) + "'>"
                                                    + lista.get(1).get(i) + "</option>");
                                        }
                                    %>
                                </select>
                                <div class=" text-center"> 
                                    <input type="submit" class="btn btn-info  btn-lg" id="btn_agregar" name="btn_agregar" value="Agregar">

                                    <input type="submit" class="btn btn-dark btn-lg" id="btn_modificar" name="btn_modificar" value="Modificar" onclick="javascript:if (!confirm('¿Desea Modificar?'))
                                                return false">
                                    <input type="submit" class="btn btn-danger btn-lg " id="btn_eliminar" name="btn_eliminar" value="Eliminar" onclick="javascript:if (!confirm('¿Desea Eliminar?'))
                                                return false">
                                    <input type="reset" class="btn btn-primary btn-lg " id="" name="" value="Limpiar" >
                                </div>
                            </form>
                        </div><!--FORMULARIO-->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Cerrar</font></font></button>
                    </div>
                </div>
            </div>
        </div>
        <!--TERMINA----------------------------------------------MODAL-->

        <div class="table-responsive ">
            <table class="table table-hover table-bordered">
                <thead>

                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Direccion</th>
                <th>Telefono</th>
                <th>Puesto</th>
                <th>DPI</th>
                <th>Nacimiento</th>
                <th>F.Ingreso</th>
                </thead>
                <tbody id="tbl_estudiante">

                    <tr>
                        <%
                            DefaultTableModel tblModelo = new DefaultTableModel();
                            tblModelo = clsEstudiante.llenarEstudiante();
                            for (int a = 0; a < tblModelo.getRowCount(); a++) {
                                out.println("<tr  data-idestudiante=" + tblModelo.getValueAt(a, 0).toString() + " data-idts=" + tblModelo.getValueAt(a, 9).toString() + ">");
                                out.println("<td>" + tblModelo.getValueAt(a, 1).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 2).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 3).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 4).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 5).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 6).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 7).toString() + "</td>");
                                out.println("<td>" + tblModelo.getValueAt(a, 8).toString() + "</td>");
                                out.println("</tr>");
                            }

                        %>

                    </tr>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            $('#tbl_estudiante').on('click', 'tr td', function (evt) {
                var target, ide, ids, carne, nombres, apellidos, direccion, telefono, fn, fr;
                target = $(event.target);
                ide = target.parents().data('idestudiante');
                ids = target.parents().data('idts');
                nombres = target.parents("tr").find("td").eq(0).html();
                apellidos = target.parents("tr").find("td").eq(1).html();
                direccion = target.parents("tr").find("td").eq(2).html();
                telefono = target.parents("tr").find("td").eq(3).html();
                carne = target.parents("tr").find("td").eq(5).html();
                fn = target.parents("tr").find("td").eq(6).html();
                fr = target.parents("tr").find("td").eq(7).html();


                $("#txt_id").val(ide);
                $("#txt_nombres").val(nombres);
                $("#txt_apellidos").val(apellidos);
                $("#txt_direccion").val(direccion);
                $("#txt_telefono").val(telefono);
                $("#txt_carne").val(carne);
                $("#txt_fn").val(fn);
                $("#txt_correo").val(fr);
                $("#drop_sangre").val(ids);

                $(document).ready(function ()//MOSTRAR LA VENTANA MODAL
                {
                    $("#miModal").modal("show");
                });
            });


        </script>

        <script>
           /* $(document).ready(function () {
                $('#btn_agregar').click(function () {
                    var id = $("#txt_id").val();
                    var carne = $("#txt_carne").val();
                    var nombre = $("#txt_nombres").val();
                    var apellido = $("#txt_apellidos").val();
                    var direccion = $("#txt_direccion").val();
                    var telefono = $("#txt_telefono").val();
                    var correo = $("#txt_correo").val();
                    var fn = $("#txt_fn").val();
                    var sangre = $("#drop_sangre").val();

                    agregardatos(id, nombre, apellido, direccion, telefono, correo, fn, sangre);
                    
                    function agregardatos(id, nombre, apellido, direccion, telefono, correo, fn, sangre) {

                        var cadena = "id=" id +
                                "&carne=" + carne +
                                "&nombre=" + nombre +
                                "&apellido=" + apellido +
                                "&direccion=" + direccion +
                                "&telefono=" + telefono +
                                "&correo=" + correo +
                                "&fn=" + fn +
                                "&sangre=" + sangre;

                        $.ajax({
                            type: "POST",
                            url: "sr_prueba.java",
                            data: cadena,
                            success:
                        });

                    }
                });
            });*/
            function enviar() {
                //alert("Hola");

                /* var cadena="id="id+
                 "&carne="+carne+
                 "&nombre="+nombre+
                 "&apellido="+apellido+
                 "&direccion="+direccion+
                 "&telefono="+telefono+
                 "&correo="+correo+
                 "&fn="+fn+
                 "&sangre="+sangre;*/

                /*$.ajax({
                 type:'POST',
                 url:'sr_prueba.java',
                 data:cadena,
                 succes:function(resp){
                 if(resp==1){
                 alertify.success("Exito");
                 $('#tbl_estudiante').load('index.jsp');
                 }else{
                 alertify.success("Fallo :(");
                 
                 }
                 }
                 });*/
                /*var id = $("#txt_id").val();
                 var carne = $("#txt_carne").val();
                 var nombre = $("#txt_nombres").val();
                 var apellido = $("#txt_apellidos").val();
                 var direccion = $("#txt_direccion").val();
                 var telefono = $("#txt_telefono").val();
                 var correo = $("#txt_correo").val();
                 var fn = $("#txt_fn").val();
                 var sangre = $("#drop_sangre").val();
                 $.post('sr_prueba', {
                 id:id,
                 nombre:nombre,
                 apellido:apellido,
                 direccion:direccion,
                 telefono:telefono,
                 carne:carne,
                 fn:fn,
                 correo:correo,
                 sangre:sangre;
                 };*/

            }
        </script>

        <footer class="page-footer-responsive font-small teal pt-4 text-white bg-dark">

            <div class="footer-copyright text-center py-3">© 2019 Copyright:
                JORGE LUIS MUÑOZ ELÍAS
            </div>
        </footer>

    </body>   
</html>
