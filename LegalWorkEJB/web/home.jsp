<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>

    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <c:choose>
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="cl.fgutierrez.legalwork.dto.UsuarioPerfilDTO" scope="session"></jsp:useBean>  

                <%@include file="master/header.jsp" %>
                <%@include file="menu.jsp" %>
                <div class="content-wrapper">
                    <section class="content">
                        <div class="box">
                            <div class="box-body">
                                <div class="col-lg-3 col-xs-6">
                                    <!-- small box -->
                                    <div class="small-box bg-red">
                                        <div class="inner">
                                            <h3>10</h3>

                                            <p>Trabajos Fuera <br>de Plazo</p>
                                        </div>
                                        <div class="icon">
                                            <i class="fa fa-hourglass-3"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Ver <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>

                                    <div class="small-box bg-red">
                                        <div class="inner">
                                            <h3>10</h3>

                                            <p>Tareas Fuera <br>de Plazo</p>
                                        </div>
                                        <div class="icon">
                                            <i class="fa fa-hourglass-3"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Ver <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>

                                </div>

                                <div class="col-lg-3 col-xs-6">
                                    <div class="small-box bg-yellow">
                                        <div class="inner">
                                            <h3>5</h3>

                                            <p>Trabajos <br> proximos a Vencer</p>
                                        </div>
                                        <div class="icon">
                                            <i class="fa fa-hourglass-2"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Ver <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>

                                    <div class="small-box bg-yellow">
                                        <div class="inner">
                                            <h3>5</h3>

                                            <p>Tareas <br> proximas a Vencer</p>
                                        </div>
                                        <div class="icon">
                                            <i class="fa fa-hourglass-2"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Ver <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>

                                </div>

                                <div class="col-lg-3 col-xs-6">

                                    <div class="small-box bg-green">
                                        <div class="inner">
                                            <h3>15</h3>

                                            <p>Trabajos <br> en curso </p>
                                        </div>
                                        <div class="icon">
                                            <i class="fa fa-hourglass-1"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Ver <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>

                                    <div class="small-box bg-green">
                                        <div class="inner">
                                            <h3>15</h3>

                                            <p>Tareas <br> en curso</p>
                                        </div>
                                        <div class="icon">
                                            <i class="fa fa-hourglass-1"></i>
                                        </div>
                                        <a href="#" class="small-box-footer">
                                            Ver <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                    </div>

                                </div>

                            </div>


                        </div>


                    </section>


                </div>


            </c:otherwise>
        </c:choose>
    </body>
</html>
