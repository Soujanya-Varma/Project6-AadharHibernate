package com.digit.hibernate.Servlet.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernate.Servlet.bean.AadharDetails;
import com.digit.hibernate.Servlet.model.*;
@WebServlet("/update")
public class Update extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("fstname");
	
	AadharDetails ad=new AadharDetails();
	ad.setId(id);
	ad.setFirst_name(name);
	
	HibernateManager hbm= new HibernateManager();
	if(hbm.update(id,name)==true) {
		
		resp.sendRedirect("/AdhaarHibernate/UpdateSuccess.html");
	}
	else {
		resp.sendRedirect("/AdhaarHibernate/UpdateFail.html");
		
	}
	//hbm.readAll();
	
	

}
}
