<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="languages.messages" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>KikitoWebSite</title>
	</head>
	
	        <form>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="fr" ${language == 'fr' ? 'selected' : ''}>Français</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
        </form>
        
    <body>
       
         <table>
		 <fmt:message key="transaction_list"/>
	 	<c:forEach var="transactionclient" items="${transactionsClient}">
		  <tr><td><fmt:message key="transaction_transacId"/></td><td>${transactionClient.transacID}</td></tr>
		   <tr><td><fmt:message key="transaction_libelle"/></td><td>${transactionClient.libelle}</td> </tr>
		     <tr><td><fmt:message key="transaction_montant"/></td><td>${transactionClient.montant}</td></tr>
		     <tr><td><fmt:message key="transaction_date"/></td><td>${transactionClient.date}</td> </tr>
		    </c:forEach>
		   </table>
		
		<table>      
		      <% out.println("Toutes les transactions enregistrées: "); %>
		        <c:forEach var="transaction" items="${transactions}">
				   <tr><td>${transaction.transacID}</td></tr>
				   <tr>
				     <td>${transaction.libelle}</td>
				     <td>${transaction.montant}</td>
				     <td>${transaction.date}</td>
				   </tr> 
				 </c:forEach>
		 </table>
    </body>
</html>