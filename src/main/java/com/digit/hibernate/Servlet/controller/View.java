package com.digit.hibernate.Servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernate.Servlet.bean.AadharDetails;

import com.digit.hibernate.Servlet.model.HibernateManager;
@WebServlet("/View")
public class View extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		AadharDetails ad=new AadharDetails();
		HibernateManager hbm=new HibernateManager();
		AadharDetails curAd = hbm.readSpecific(id);
		if (curAd == null) {
			// empty - no user
			resp.sendRedirect("Fail.html");
			return;
		}
		// user exists
		HttpSession session = req.getSession();
		session.setAttribute("curUser", curAd);
		resp.sendRedirect("/AdhaarHibernate/View.jsp");
		return;
//
//		hbm.view(id);
		
//		System.out.println(hbm.getId() + " " + hbm.getFirst_name());
		
//		HttpSession session = req.getSession();
//        session.setAttribute("curuser", hbm);
			
			
		
		
	}
}







		//		long aadhar_id=Integer.parseInt(req.getParameter("aadhar_id"));
		//		
		//		AadharDetails ad=new AadharDetails();
		//		ad.setAadhar_ID(aadhar_id);
		//		HibernateManager hbm= new HibernateManager();
		//		if(hbm.readSpecific(aadhar_id)==true) {
		//			
		//			resp.sendRedirect("/ServletHibernate/Success.html");
		//		}
		//		else {
		//			resp.sendRedirect("/ServletHibernate/Fail.html");
		//			
		//		}
		//	}
		



		





	





