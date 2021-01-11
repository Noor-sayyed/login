package com.zensar.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class loginController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String requestAction = request.getParameter("requestAction");

		if (requestAction.equalsIgnoreCase("login")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("passoword");
			loginRepository loginRepository = new loginRepository();

			boolean loginResult = loginRepository.checkLogin(userName, password);
			if (loginResult) {
				try {
					response.sendRedirect("index.jsp");
				} catch (Exception e) {
					System.out.println("Exception Occured:" + e);
				}
			} else {
				request.setAttribute("errorMessage", "Invalid Username/Password");
			}
			try {

				RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
				try {
					rd.forward(request, response);
				} catch (Exception e) {

				}

			} catch (Exception e) {
				System.out.println("Exception Occured:" + e);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		doGet(request, response);
	}

}
