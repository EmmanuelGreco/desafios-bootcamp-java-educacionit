<%@ page session="true"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  Especifica el prefijo que se utilizará para acceder a las etiquetas de la biblioteca importada. En este caso, el prefijo "c" se utilizará para acceder a las etiquetas de JSTL Core en el archivo JSP. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- fmt: Este prefijo se utiliza para formatear y presentar datos, como fechas, números y mensajes. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- fn: Este prefijo se utiliza para acceder a las funciones de utilidad proporcionadas por JSTL, como operaciones de cadena, colección y manipulación de fechas. -->

<!DOCTYPE html> 
<html> 
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Cache-Control">
	<meta http-equiv="Pragma" content="no-cache">
</head> 
<body>
	<h2>Inicio de sesión</h2>
	<hr>
	<br>
 	
 	<form action="login" method="post">            
        <label>Email: </label><input type="text" name="email"/><br>           
        <br><label>Clave: </label><input type="password" name="clave"/><br>
       	<br><input type="submit" value="Login"/>
    </form>

	<c:if test="${not empty mensaje}">
  		<h3><font color=red>${mensaje}</font></h3>
    </c:if>
</body> 
</html>
