<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <jsp:include page="./getAllUsr" flush="true"/>
        <jsp:useBean id="usuarios" class="cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO" scope="page"></jsp:useBean>
        <jsp:include page="./getAllPerfiles" flush="true"/>
        <jsp:useBean id="perfil" class="cl.fgutierrez.legalwork.entidades.Perfil" scope="page"/>
        <c:choose>
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO" scope="session"></jsp:useBean>  
                
                
                <%@include file="master/header.jsp" %>
                <%@include file="menu.jsp" %>
        
        
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Usuarios
      </h1>
     </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Maestro de Usuarios</h3>

        </div>
        <div class="box-body">
          <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Nuevo Usuario</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" name="frmUsuario" method="post" action="./registraUsuario">
              <div class="box-body">
                <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Nombre</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtNombre">
                </div>
                  <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Apellido</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtApell">
                </div>
                  <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Rut</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtRut">
                </div>
                <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Nombre de Usuario</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" name="txtNomUsr">
                </div>
                  <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Contraseña</label>
                  <input type="password" class="form-control" id="exampleInputPassword1" name="txtPass">
                </div>
                <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Tipo de Usuario</label>
                  <select class="form-control" name="cmbPerfil">
                      <option value="0">(Seleccione)</option>
                      <c:forEach items="${listaPerfiles}" var="perfil">
                          <option value="${perfil.idPerfil}"><c:out value="${perfil.nomPerfil}"/></option>
                      </c:forEach>
                  </select>
                </div>
                  
                  <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">E-Mail</label>
                  <input type="email" class="form-control" id="exampleInputPassword1" name="txtEmail">
                </div>
               <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Telefono</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtFono">
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-success">Crear</button>
              </div>
            </form>
          </div>
          <!-- /.box -->
          </div>
            <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Edicion de Usuarios</h3>
<!--              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="Buscar">

                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>-->
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-striped table-hover">
                <tr>
                  <th style="width: 10px">ID</th>
                  <th>Nombre Completo</th>
                  <th>Tipo de Usuario</th>
                  <th style="width: 40px"></th>
                </tr>
                <c:forEach items="${listadoUsr}" var="usuarios">
                <tr>
                    <td><c:out value="${usuarios.usr.idUsr}"/></td>
                    <c:url value="./modificarUsuario" var="modificaUsuario">
                    <c:param name="codigoUsr" value="${usuarios.usr.idUsr}"/>
                    </c:url>
                    <td><c:out value="${usuarios.usr.nomUsr} ${usuarios.usr.apellUsr}"/></td>
                  <td>
                      <c:out value="${usuarios.perfil.nomPerfil}"/>
                  </td>
                  <td>
                   <%-- class="badge bg-red"     <a class="btn btn-app" data-toggle="modal" data-target="#myModal"> <i class="fa fa-edit"></i>edit</a>
                      <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Editar</button> --%>
                   <a href="${modificaUsuario}" data-toggle="modal" data-target="#myModal"><span class="btn btn-sm">Editar</span></a>
                  </td>
                  
                </tr>
                </c:forEach>
                
              </table>
            </div>
            
          </div>
          <!-- /.box -->
    
           </div>
        </div>
        <!-- /.box-body -->
        
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>

   <c:if test="${sessionScope.objetoAeditar!=null}">
   <jsp:useBean id="objetoAeditar" class="cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO" scope="page"/>
                    
  <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Editar usuario</h4>
            </div>
            <div class="modal-body">
              <p>Some text in the modal.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>

        </div>
</div>
                    
                    
                </c:if>
        
        
      
              </c:otherwise>
        </c:choose>
    </body>
</html>
