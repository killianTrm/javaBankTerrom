<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>KikitoWebSite</title>
	</head>
    <body>
        <p>Bienvenue sur le site de Kikito !</p>

        
	 	 <c:forEach var="client" items="${clients}">
		   <tr>
		     <td>${client.prenom}</td>
		     <td>${client.nom}</td>
		   </tr>
		  </c:forEach>     
        
    </body>
</html>