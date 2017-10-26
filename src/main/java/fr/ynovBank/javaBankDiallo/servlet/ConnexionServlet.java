package fr.ynovBank.javaBankDiallo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import fr.ynovBank.javaBankDiallo.dao.ClientManager;
import fr.ynovBank.javaBankDiallo.model.Client;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private String paramLogin;
	private String paramPassword;

	public void init() throws ServletException {
		this.paramLogin = "zero";
		this.paramPassword = "zoro";
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		RequestDispatcher dispatcher = null;

		Client isClientConnecte = ClientManager.connexionClient(login, pwd);
		if (isClientConnecte != null) {
			dispatcher = request.getRequestDispatcher("/listAccounts.jsp");
			request.getSession().setAttribute("clientConnecte", isClientConnecte);
			response.sendRedirect("TransactionServlet");
		} else {
			dispatcher = request.getRequestDispatcher("/connexion.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}