package com.digit.hibernate.Servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.digit.hibernate.Servlet.bean.AadharDetails;
import com.digit.hibernate.Servlet.model.HibernateManager;

@WebServlet("/Register")
public class Register extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AadharDetails ad=new AadharDetails();
        ad.setFirst_name(req.getParameter("fstname"));
        ad.setLast_name(req.getParameter("lname"));
        ad.setFather_name(req.getParameter("fname"));
        ad.setState(req.getParameter("state"));
        ad.setPhone_number(req.getParameter("number"));
        ad.setEmail(req.getParameter("email"));
        ad.setAddress(req.getParameter("address"));
        ad.setPin_code(req.getParameter("pincode"));
     
        
        HibernateManager h=new HibernateManager();
        
        boolean b = h.saveObject(ad);
        if(b==true) {
        	resp.sendRedirect("/AdhaarHibernate/RegisterSuccess.html");
        }
        else {
        	resp.sendRedirect("/AdhaarHibernate/RegisterFail.html");
        }
        
	}
	

}
