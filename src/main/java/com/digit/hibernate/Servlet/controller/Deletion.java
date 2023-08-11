package com.digit.hibernate.Servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernate.Servlet.bean.AadharDetails;
import com.digit.hibernate.Servlet.model.*;

@WebServlet("/delete")
public class Deletion extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
int id=Integer.parseInt(req.getParameter("id"));
	AadharDetails ad=new AadharDetails();
	ad.setId(id);;
	
	
	HibernateManager hbm= new HibernateManager();
	if(hbm.delete(id)==true) {
		
		resp.sendRedirect("/AdhaarHibernate/DeleteSuccess.html");
	}
	else {
		resp.sendRedirect("/AdhaarHibernate/DeleteFail.html");
		
	}
	//hbm.readAll();
}
}

