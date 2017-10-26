<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>KikitoWebSite</title>
	</head>
    <body>
        <p>Liste des comptes client :</p>
		<c:forEach var="compteClient" items="${comptesClient}">
		   <tr>
		     <td>${compteClient.libelle}</td>
		     <td>${compteClient.numero}</td>
		   </tr>
		  </c:forEach>  
        
         </br><p>Liste complète des comptes:</p>
	 	 <c:forEach var="compte" items="${comptes}">
		   <tr>
		     <td>${compte.libelle}</td>
		     <td>${compte.numero}</td>
		   </tr>
		  </c:forEach>     
        
    </body>
</html>