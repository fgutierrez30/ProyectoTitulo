<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <jsp:include page="./getAllRegion" flush="true"/>
        <jsp:useBean id="regiones" class="cl.fgutierrez.legalwork.entidades.Region" scope="page"></jsp:useBean>
        
        <jsp:include page="./getAllCiudades" flush="true"/>
        <jsp:useBean id="ciudades" class="cl.fgutierrez.legalwork.entidades.Ciudad" scope="page"/>
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
        Provincias y Comunas
      </h1>
     </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Maestro Provincias y Comunas</h3>

        </div>
        <div class="box-body">
          <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Nueva Provincia</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" name="frmCiudad" method="post" action="./getAllCiudades">
              <div class="box-body">
                             
                              
                <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Region</label>
                  <select class="form-control" name="cmbRegion">
                      <option value="0">(Seleccione)</option>
                      <c:forEach items="${listaRegiones}" var="regiones">
                          <option value="${regiones.idRegion}"><c:out value="${regiones.nomRegion}"/></option>
                      </c:forEach>
                  </select>
                </div>
                  
                  <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Nombre Provincia</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" name="txtNomCiudad">
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
              <h3 class="box-title">Nueva Comuna</h3>
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
              <form role="form" name="frmComuna" method="post" action="./getAllComuna">
              <div class="box-body">
                             
                              
                <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Provincia</label>
                  <select class="form-control" name="cmbCiudad">
                      <option value="0">(Seleccione)</option>
                      <c:forEach items="${listarCiudades}" var="ciudades">
                          <option value="${ciudades.idCiudad}"><c:out value="${ciudades.nomCiudad}"/></option>
                      </c:forEach>
                  </select>
                </div>
                  
                  <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Nombre Comuna</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" name="txtNomComuna">
                </div>
               
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-success">Crear</button>
              </div>
            </form>
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

                
              </c:otherwise>
        </c:choose>
    </body>
</html>
