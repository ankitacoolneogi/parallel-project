package com.ibm.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.bean.Customer;
import com.ibm.bean.Transaction;

@WebServlet("/transact")
public class Transact extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("trans_type").equals("withdraw")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("withdraw.jsp");
			dispatcher.include(request, response);
		}
		if (request.getParameter("trans_type").equals("view")) {
			doPost(request, response);
		}
		if (request.getParameter("trans_type").equals("deposit")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("deposit.jsp");
			dispatcher.include(request, response);
		}
		if (request.getParameter("trans_type").equals("transfer")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("transfer.jsp");
			dispatcher.include(request, response);
		}
		if (request.getParameter("trans_type").equals("bal_status")) {
			doPost(request, response);
		}
		if (request.getParameter("trans_type").equals("prin_trans")) {
			doPost(request, response);
		}
		if (request.getParameter("trans_type").equals("logout")) {
			doPost(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ServiceClass b_ser = new ServiceClass();
		Customer cus = new Customer();

		response.setContentType("text/html");
		try {
			cus.setId(Integer.parseInt((String) session.getAttribute("user_id")));
		} catch (NumberFormatException e) {
			System.out.println("Error in session id: " + e.getMessage());
		}

		if (request.getParameter("trans_type") == null) {

			if (request.getParameter("work").trim().equals("DEPOSIT")) {
				if (b_ser.deposit(cus, Integer.parseInt(request.getParameter("amount"))))
					out.print("successfully depositted!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);

			} else if (request.getParameter("work").trim().equals("WITHDRAW")) {
				if (b_ser.withdrawal(cus, Integer.parseInt(request.getParameter("amount"))))
					out.print("successfully withdrawn!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);
			} else if (request.getParameter("work").trim().equals("TRANSFER")) {
				if (b_ser.send(cus, Integer.parseInt(request.getParameter("acc")),
						Integer.parseInt(request.getParameter("amount"))))
					out.print("successfully transferred!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);
			}
		} else {
			if (request.getParameter("trans_type").trim().equals("view")) {
				out.print("Account Details: ");
				ArrayList<Customer> details = b_ser.viewBalance(cus);
				for (Customer k : details) {
					out.print(k);
				}

				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);
			} else if (request.getParameter("trans_type").trim().equals("bal_status")) {
				out.print("Balance status: ");

				if (b_ser.lowBalance(cus))
					out.print("Account is in low-balance state...");
				else
					out.println("Account status is healthy..");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);
			} else if (request.getParameter("trans_type").trim().equals("prin_trans")) {
				out.print("Transactions are: ");

				ArrayList<Transaction> det = b_ser.printTransaction(cus);
				for (Transaction m : det) {
					out.println(m +"<br>");
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.include(request, response);
			} else if (request.getParameter("trans_type").trim().equals("logout")) {

				session.invalidate();
				out.print("successfully logged out!!..");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.include(request, response);
			}

		}

	}

}
