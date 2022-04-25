package com.bookstoreweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.bookstoreweb.entity.Book;
import com.bookstoreweb.util.HibernateUtil;

@WebServlet("/readBooks")
public class ReadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Book> books = session.createQuery("from Book").list();
		request.setAttribute("books", books);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/viewBooks.jsp");
		requestDispatcher.forward(request, response);
		session.close();
	}
}
