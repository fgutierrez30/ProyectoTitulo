<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
        <link rel="stylesheet" href="css/datepicker3.css">
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/bootstrap-datepicker.es.js"></script>
        <script> 
            $(function (){
            $('#fechainicio').datepicker({autoclose:true,language:'es',format:'dd/mm/yyyy',startDate: '-10d'}).attr('readonly','readonly');
            $('#fechafin').datepicker({autoclose:true,language:'es',startDate: '0',format:'dd/mm/yyyy'}).attr('readonly','readonly');
        });
        </script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
           <jsp:include page="./getAllClient" flush="true"/>
           <jsp:useBean id="cliente" class="cl.fgutierrez.legalwork.entidades.Cliente" scope="page"></jsp:useBean>
           <jsp:include page="./getAllTpTrabajo" flush="true"/>
          <jsp:useBean id="tpTrabajo" class="cl.fgutierrez.legalwork.entidades.TipoTrabajo" scope="page"/>
        
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
        Trabajos
      </h1>
     </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Ingreso de Trabajos</h3>

        </div>
          
       <div class="box-body">
           <form name="frmTrabajo" method="post" action="./llenaTrabajo">    
           <div class="col-md-6">
               <div class="form-group col-xs-5">
                  <label for="exampleInputPassword1">Selecionar Cliente</label>
                  <select class="form-control" name="cmbCliente">
                      <option value="0">(Seleccione)</option>
                      <c:forEach items="${listaCliente}" var="cliente">
                          <option value="${cliente.rutCliente}"><c:out value="${cliente.razonSocial}"/></option>
                      </c:forEach>
                    
                  </select>
                </div>
               <div class="form-group col-xs-5">
                  <label for="exampleInputPassword1">Tipo de Trabajo</label>
                  <select class="form-control" name="cmbTpTrabajo">
                      <option value="0">(Seleccione)</option>
                        <c:forEach items="${listaTpTrabajo}" var="tpTrabajo">
                            <option value="${tpTrabajo.idTipoTrabajo}"><c:out value="${tpTrabajo.nomTipoTrabajo}"/></option>
                      </c:forEach>
                  </select>
                </div>
              <div class="form-group col-xs-5">
                <label>Fecha de Inicio:</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                    <input type="text" class="form-control pull-right" id="fechainicio" name="txtFechaInicio">
                </div>
                <!-- /.input group -->
              </div>
              <!-- /.form group -->

               <div class="form-group col-xs-5">
                <label>Fecha de Entrega:</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                    <input type="text" class="form-control pull-right" id="fechafin" name="txtFechaFin">
                </div>
                <!-- /.input group -->
              </div>
              
              <div class="form-group col-xs-10">
                  <label for="exampleInputPassword1">Descripcion</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" placeholder="" name="txtDescripcion">
                </div>
               <div class="box-footer">
                <button type="submit" class="btn btn-primary">Ingresar Trabajo</button>
              </div>
              
            </div>
           </form>
       </div>
             
         
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
                
        </c:otherwise>
        </c:choose>
        
    </body>
</html>
