<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" import="com.digit.hibernate.Servlet.model.HibernateManager"
    import="com.digit.hibernate.Servlet.bean.AadharDetails"
    

    import="org.hibernate.Session"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>
<style>
p{
align-items:center;
}



a{
	align-self: center;
	display: flex;
	align-items: center;
	display: inline-block;
	
  text-decoration: none;
  padding: 10px 20px; 
  border-radius: 4px;
  background-color: #007BFF;
  color: #fff;
  margin-bottom: 10px;
  justify-content: center;
    text-align: center;

}
</style>

</head>

<body>

<%

session = request.getSession();
AadharDetails a = (AadharDetails) session.getAttribute("curUser");
 



 

%>
<center>
    <h1>Your Details</h1><br>

   <p>

        Aadhar Number:

        <%=a.getId()%></p>

    <p>
    <p>

        Name:

        <%=a.getFirst_name()%></p>

    <p>

        Email:

        <%=a.getEmail()%></p>

    <p>

        Phone Number:

        <%=a.getPhone_number()%></p>

    <p>

        Address Line:

        <%=a.getAddress()%></p>

   
    <p>

        State:

        <%=a.getState()%></p>

    <p>

        PinCode:

        <%=a.getPin_code()%></p><br>
         <a href="index.html">Click here to redirect</a>
</center>
</body>

</html>