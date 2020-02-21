package com.ibm.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.bean.Customer;
import com.ibm.dao.DaoApply;;

@WebServlet("/logic")
public class Logic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		if (request.getParameter("user_exist").equals("yes"))
			response.sendRedirect("old_user.html");
		else response.sendRedirect("new_user.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ServiceClass b_ser = new ServiceClass();
		// System.out.println(request.getParameter("login"));
		try {
			// OLD USER
			if (request.getParameter("login").equals("LOGIN")) {
				Customer c = new Customer();
				
				c.setId(Integer.parseInt(request.getParameter("cust_id")));
				c.setPassword(request.getParameter("pass"));
				if (b_ser.login(c)) {
					session.setAttribute("user_id", request.getParameter("cust_id"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
					dispatcher.include(request, response);
				}
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.include(request, response);
			}
			if (request.getParameter("login").equals( "REGISTER")) {

				if (request.getParameter("cust_name") == null || request.getParameter("dob") == null
						|| request.getParameter("pass") == null || request.getParameter("phn") == null
						|| request.getParameter("mail") == null || request.getParameter("bal") == null
						|| request.getParameter("cust_name") == "" || request.getParameter("dob") == ""
						|| request.getParameter("pass") == "" || request.getParameter("phn") == ""
						|| request.getParameter("mail") == "" || request.getParameter("bal") == "") {

					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.include(request, response);

				} else {
					Customer c = new Customer(request.getParameter("cust_name"), request.getParameter("dob"),
							request.getParameter("pass"), request.getParameter("phn"), request.getParameter("mail"),
							Integer.parseInt(request.getParameter("bal")));

					if (b_ser.validateObject(c)) {

						// NEW USER
						session.setAttribute("user_id", request.getParameter("cust_id"));
						b_ser.createAccount(c);
						RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
						dispatcher.include(request, response);
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
						dispatcher.include(request, response);
					}

				}
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.include(request, response);
			
			}
		} catch (NumberFormatException e) {
			System.out.println("Integer formatting problem: " + e.getMessage());
		}
		// if(request.getParameter("registeration") == null)

		// doGet(request, response);
	}

}
