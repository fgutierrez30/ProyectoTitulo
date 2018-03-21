<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <jsp:include page="./getAllTrabajos" flush="true"/>
        <jsp:useBean id="trabajosPen" class="cl.fgutierrez.legalwork.dto.TrabajoTpTrabajoClienteDTO" scope="page"></jsp:useBean>
        
        
        <c:choose>
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO" scope="session"></jsp:useBean>  
                
                
                <%@include file="master/header.jsp" %>
                <%@include file="menu.jsp" %>
        
                   <div class="content-wrapper">
            <section class="content-header">
                <h1>
                 Asignacion de Trabajos
                </h1>
            </section>
           
            <section class="content">
                
                <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Trabajos Pendientes de Asignacion</h3>

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
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>ID</th>
                  <th>Cliente</th>
                  <th>Tipo de Trabajo</th>
                  <th>Descripcion</th>
                  <th>Fecha de Inicio</th>
                  <th>Fecha de Entrega</th>
                  <th>Estado</th>
                </tr>
                <c:forEach items="${listTrabajosPen}" var="trabajosPen">
                <tr>
                    <td><c:out value="${trabajosPen.trabajo.idTrabajo}"/></td>
                    <td><c:out value="${trabajosPen.cliente.razonSocial}"/></td>
                    <td><c:out value="${trabajosPen.tpTrabajo.nomTipoTrabajo}"/></td>
                    <td><c:out value="${trabajosPen.trabajo.detTrabajo}"/></td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${trabajosPen.trabajo.fechaInicioTrabajo}"/></td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${trabajosPen.trabajo.fechaFinTrabajo}"/></td>
                    <td><span class="label label-success"><c:out value="${trabajosPen.trabajo.estadoTrabajo}"/></span></td>
                  <td><a href="#"><span class="badge bg-aqua">Editar</span></a></td>
                                  
                </tr>
                </c:forEach>
             
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
                
            </section>
            
            
        </div>
        
  <script src="js/edita.js"></script>
                
              </c:otherwise>
        </c:choose>
    </body>
</html>
