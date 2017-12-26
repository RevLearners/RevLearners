package io.revlearners.model.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.revlearners.model.bean.User;
import io.revlearners.model.dao.hibernate.BeanDao;

@MultipartConfig
@WebServlet(name = "CreateAccount", urlPatterns = "/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BeanDao dao = new BeanDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User newUser = new User();
		System.out.println("TEST!----------------");
		
		newUser.setFirstName(request.getParameter("fname"));
		newUser.setLastName(request.getParameter("lname"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));
		
		System.out.println(newUser.getEmail());
		
		UserService service = new UserService();
		service.CreateAccount(newUser);
		System.out.println(newUser);
	}

}

