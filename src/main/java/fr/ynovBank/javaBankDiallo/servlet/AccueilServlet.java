package fr.ynovBank.javaBankDiallo.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ynovBank.javaBankDiallo.TestJPA;
import fr.ynovBank.javaBankDiallo.dao.AccountManager;
import fr.ynovBank.javaBankDiallo.dao.ClientManager;
import fr.ynovBank.javaBankDiallo.model.Client;
import fr.ynovBank.javaBankDiallo.model.Compte;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(AccueilServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().getAttribute("clientConnecte");
		
		List<Compte> comptesClient = AccountManager.loadComptesClient(1);
		request.setAttribute("comptesClient", comptesClient);
		PersistenceUtil util = Persistence.getPersistenceUtil();
		logger.debug("is clientcomptes loaded ? "+util.isLoaded(comptesClient));
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accueil.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
