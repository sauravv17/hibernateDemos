package com.bookstoreweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.bookstoreweb.entity.Book;
import com.bookstoreweb.util.HibernateUtil;


@WebServlet("/addBookServlet")
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname = request.getParameter("bookname");
		String isbn = request.getParameter("isbn");
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Book book =new Book(bookname,isbn,price);
		session.save(book);
		
		session.getTransaction().commit();
		
		session.close();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Added <i>"+bookname+"</i> to your books collection</h1>" );
		
		out.println("<a href ='BookStore.html'> Home </a>");
	}

}
