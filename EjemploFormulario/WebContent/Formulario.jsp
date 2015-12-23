<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EjemploServlet" method="post">
Ingrese el nombre
<input type="text" name="nombre" >
<br>
Ingrese el apellido
<input type="text" name="apellido" >
<br>
Ingrese el mail
<input type="text" name="mail" >
<br>
Ingrese el telefono
<input type="text" name="telefono" >
<br>
<input type="submit" value="Enviar" >
<br>
<i:forEach items= "${listaContacto}" var="contacto">
 ${contacto.nombre} : 
 ${contacto.apellido} : 
 ${contacto.telefono} : 
 ${contacto.mail}
<br/>
</i:forEach>
${mensaje}
</form>
</body>
</html>