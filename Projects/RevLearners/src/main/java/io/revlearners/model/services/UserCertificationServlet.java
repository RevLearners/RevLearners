package io.revlearners.model.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.revlearners.model.bean.Certification;
import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.RequestStatus;
import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.dao.hibernate.BeanDao;

@MultipartConfig
@WebServlet(name = "UserCertification", urlPatterns = "/UserCertification")
public class UserCertificationServlet extends HttpServlet {
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
		UserCertification newUserCert = new UserCertification();
		Certification cert = new Certification();
		FileBlob file = new FileBlob();
		RequestStatus status = new RequestStatus();
		
		
		
		
		UserCertificationService service = new UserCertificationService();
		service.addUserCertification(newUserCert);
		System.out.println(newUserCert);
	}

}
