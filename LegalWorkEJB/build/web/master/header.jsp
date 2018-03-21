          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header">
          
          <a href="home.jsp" class="logo">
              
            <span class="logo-mini"><b>L</b>WA</span>
           
            <span class="logo-lg"><b>Legal</b>Work Assigment</span>
          </a>
          
          <nav class="navbar navbar-static-top">
            
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
              <ul class="nav navbar-nav">
              
               
                <li class="dropdown user user-menu">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    
                    <span class="hidden-xs"><c:out value="${usuarioConectado.usr.nomUsr} ${usuarioConectado.usr.apellUsr}" /></span>
                  </a>
                  <ul class="dropdown-menu">
                    
                                        
                    <li class="user-panel">
                        <div class="pull-left">
                            <a href="#" class="btn btn-default btn-flat">Cambiar Contraseña</a>
                        </div>
                      <div class="pull-right">
                          <c:url value="./killSession" var="elimina"/>
                        <a href="${elimina}" class="btn btn-default btn-flat">Cerrar Sesion</a>
                      </div>
                    </li>
                  </ul>
                </li>
                
              </ul>
            </div>
          </nav>
   </header>
   

