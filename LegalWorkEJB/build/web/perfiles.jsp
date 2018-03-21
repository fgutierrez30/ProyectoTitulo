<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        
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
        Perfiles
      </h1>
     </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Maestro de Perfiles</h3>

        </div>
        <div class="box-body">
          <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Nuevo Perfil</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" name="frmUsuario" method="post" action="./registraUsuario">
              <div class="box-body">
                <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Nombre Perfil</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtNombre">
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
              <h3 class="box-title">Edicion de Perfiles</h3>
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
                  <th>Nombre</th>
                  <th style="width: 10px"></th>
                </tr>
                <c:forEach items="${listaPerfiles}" var="perfil">
                <tr>
                    <td><c:out value="${perfil.idPerfil}"/></td>
                    <c:url value="./modificarPerfil" var="modificaPerfil">
                        <c:param name="id_perfil" value="${perfil.idPerfil}"/>
                    </c:url>
                    <td><c:out value="${perfil.nomPerfil}"/></td>
                    
                  <td><a href="${modificaPerfil}"><span class="badge bg-red" onclick="window.location.href=${modificaPerfil}">Editar</span></a></td>
                </tr>
                </c:forEach>
                
              </table>
            </div>
                                 
            
          </div>
          <!-- /.box -->
          
           </div>
            
            
        </div>
          
        <!-- /.box-body -->
        <c:if test="${sessionScope.objetoAeditar!=null}">
            <jsp:useBean id="objetoAeditar" class="cl.fgutierrez.legalwork.entidades.Perfil" scope="page"/>
        
                
    <div class="col-md-6">            
      <br>
          <div class="box box-danger">
          <div class="box-header with-border">
            <h3 class="box-title">Actualiza Perfil</h3>
            <div class="box-tools pull-right">
              <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
            </div><!-- /.box-tools -->
          </div><!-- /.box-header -->
          <div class="box-body">
            <form role="form" name="frmPerfil" method="post" action="./modificarPerfil">
              <div class="box-body">
                  <div class="form-group col-xs-3">
                  <label for="exampleInputEmail1">Codigo Perfil</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtIdPerfil" value="<c:out value="${sessionScope.objetoAeditar.idPerfil}"/>" readonly="readonly">
                </div>
                <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Nombre Perfil</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtNuevoNombre" value="<c:out value="${sessionScope.objetoAeditar.nomPerfil}"/>">
                </div>
                  
                  
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-danger">Actualizar</button>
              </div>
            </form>
          </div><!-- /.box-body -->
        </div><!-- /.box -->
        
    </div>        
       </c:if>            
                
        
         
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>

  
              </c:otherwise>
        </c:choose>
    </body>
</html>
