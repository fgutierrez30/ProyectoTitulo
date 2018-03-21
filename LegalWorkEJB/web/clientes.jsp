<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <jsp:include page="./getAllClient" flush="true"/>
        <jsp:useBean id="clientes" class="cl.fgutierrez.legalwork.entidades.Cliente" scope="page"></jsp:useBean>
       
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
        Clientes
      </h1>
     </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Maestro de Clientes</h3>

        </div>
        <div class="box-body">
          <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Nuevo Cliente</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" name="frmUsuario" method="post" action="./getAllClient">
              <div class="box-body">
                <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Rut</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtRut">
                </div>
                  <div class="form-group col-xs-6">
                  <label for="exampleInputEmail1">Razon Social</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtRazonSocial">
                </div>
                  <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">E-Mail</label>
                  <input type="email" class="form-control" id="exampleInputPassword1" name="txtEmail">
                 </div>
                <div class="form-group col-xs-6">
                  <label for="exampleInputPassword1">Telefono</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" name="txtFono">
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
              <h3 class="box-title">Edicion de Clientes</h3>
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
                  <th>Rut</th>
                  <th>Razon Social</th>
                  <th>Correo</th>
                  <th style="width: 40px"></th>
                </tr>
                <c:forEach items="${listaCliente}" var="clientes">
                <tr>
                    <td><c:out value="${clientes.rutCliente}"/></td>
                    <c:url value="./actualizaCliente" var="modificaCliente">
                        <c:param name="rutCliente" value="${clientes.rutCliente}"/>
                    </c:url>
                    <td><c:out value="${clientes.razonSocial}"/></td>
                  <td>
                      <c:out value="${clientes.correoCliente}"/>
                  </td>
                  <td><a href="${modificaCliente}"><span class="badge bg-red" onclick="window.location.href='${modificaCliente}'">Editar</span></a></td>
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
   <jsp:useBean id="objetoAeditar" class="cl.fgutierrez.legalwork.entidades.Cliente" scope="page"/>
                    
       <div class="col-md-9">            
      <br>
          <div class="box box-danger">
          <div class="box-header with-border">
            <h3 class="box-title">Actualiza Perfil</h3>
            <div class="box-tools pull-right">
              <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
            </div><!-- /.box-tools -->
          </div><!-- /.box-header -->
          <div class="box-body">
            <form role="form" name="frmPerfil" method="post" action="./actualizaCliente">
              <div class="box-body">
                  <div class="form-group col-xs-3">
                  <label for="exampleInputEmail1">Rut Cliente</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" name="txtIdPerfil" value="<c:out value="${sessionScope.objetoAeditar.rutCliente}"/>" readonly="readonly">
                </div>
                <div class="form-group col-xs-3">
                  <label for="exampleInputEmail1">Razon Social</label>
                  <input type="text" class="form-control"  name="txtRazonSocAct" value="<c:out value="${sessionScope.objetoAeditar.razonSocial}"/>">
                </div>
                
                <div class="form-group col-xs-3">
                  <label for="exampleInputPassword1">E-Mail</label>
                  <input type="email" class="form-control" id="exampleInputPassword1" name="txtEmailAct" value="<c:out value="${sessionScope.objetoAeditar.correoCliente}"/>">
                 </div>
                <div class="form-group col-xs-3">
                  <label for="exampleInputEmail1">Telefono</label>
                  <input type="text" class="form-control"  name="txtFonoAct" value="<c:out value="${sessionScope.objetoAeditar.telefCliente}"/>">
                </div>
               
<!--                <div class="form-group">
                     
                  <div class="radio">
                    <label>
                        <input type="radio" name="rbEstado" id="optionsRadios1" value="1" checked="" >
                      Activo
                    </label>
                  </div>
                    
                  <div class="radio">
                    <label>
                        <input type="radio" name="rbEstado" id="optionsRadios2" value="2">
                      Bloqueado
                    </label>
                  </div>
                              
                </div>-->
                
                 
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
