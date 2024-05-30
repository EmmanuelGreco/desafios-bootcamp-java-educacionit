<%
if (session.getAttribute("email") == null) {
    response.sendRedirect("login.jsp");
    return;}
%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  Especifica el prefijo que se utilizará para acceder a las etiquetas de la biblioteca importada. En este caso, el prefijo "c" se utilizará para acceder a las etiquetas de JSTL Core en el archivo JSP. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- fmt: Este prefijo se utiliza para formatear y presentar datos, como fechas, números y mensajes. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- fn: Este prefijo se utiliza para acceder a las funciones de utilidad proporcionadas por JSTL, como operaciones de cadena, colección y manipulación de fechas. -->

<!DOCTYPE html> 
<html> 
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Cache-Control">
	<meta http-equiv="Pragma" content="no-cache">
</head>
<body>
    <h4>Session ID: <%=request.getSession().getId()%></h4>
  	<h3>Hola <font color=green><%=session.getAttribute("email")%></font>!</h3>
    <h2>BIENVENIDO A <font color=blue>EDUCACIÓNIT</font>!</h2>
  	<hr> 
    <h3>Listado de Empleados</h3>
    
    <table border="1">
        <tr>
            <th>Legajo</th>
            <th>Apellido</th>
            <th>Nombre</th>
            <th>Antigüedad</th>
            <th>Puesto</th>
        </tr>  		
  		
        <c:forEach items="${listaEmpleados}" var="empleado">  
			<tr>
                <td>${empleado.legajo}</td>
                <td>${empleado.apellido}</td>
                <td>${empleado.nombre}</td>
                <td>${empleado.antiguedad}</td>
                <td>${empleado.puesto}</td>
			</tr>
        </c:forEach>        
    </table>
    
    <br>
    <hr>
    <form action="cerrarsesion" method="get">
    <br><input type="submit" value="Cerrar sesión"/>
    </form>
</body>
</html>
