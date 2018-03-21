<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="objMenuPadre" class="cl.fgutierrez.legalwork.dto.MenuDTO" scope="page"></jsp:useBean>
<jsp:useBean id="objMenuHijo" class="cl.fgutierrez.legalwork.dto.MenuDTO" scope="page"></jsp:useBean>


  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
     
     
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MENU PRINCIPAL</li>
        <c:forEach items="${ListadoMenu}" var="objMenuPadre">
        <c:if test="${objMenuPadre.padre_menu==0}">
        <li class="treeview">
          <a href="#">
            <i class="fa fa-circle"></i> <span><c:out value="${objMenuPadre.nom_menu}"></c:out></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <c:forEach items="${ListadoMenu}" var="objMenuHijo">
                  <c:if test="${objMenuHijo.id_menu!=0 && objMenuPadre.id_menu==objMenuHijo.padre_menu}">
                      <li><a href="<c:out value="${objMenuHijo.url_menu}"/>"> <i class="fa fa-circle-o"></i> <span>   <c:out value="${objMenuHijo.nom_menu}"></c:out> </span></a></li>
                 </c:if>
            </c:forEach>
          </ul>
            
        </li>
        
        </c:if>
        </c:forEach>
                      
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>