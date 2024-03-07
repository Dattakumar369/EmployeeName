<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  conn = DriverManager.getConnection("jdbc:mysql:///joins?characterEncoding=utf8", "root",
	   				"Dattu@123");
            
            
            String query = "SELECT * FROM rsloyee";
            
            		 ResultSet rs = (ResultSet) request.getAttribute("rs");
            out.println("<h2>rsloyees</h2>");
		    out.println("<table border=\"1\">");
		    out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Designation</th><th>Mobileno</th>"
		    		+ "<th>Gender</th><th>Relocate</th><th>Previouscompany</th><th>Experience</th>"
		    		+ "<th>Relocate</th><th>Resume</th></tr>");
		    
	        while (rs.next()) {
	        	out.println("<tr>");
			    out.println("<td>" + rs.getId() + "</td>");
			    out.println("<td>" + rs.getFullname() + "</td>");
			    out.println("<td>" + rs.getEmail() + "</td>");
			    out.println("<td>" + rs.getDesignation() + "</td>");
			    out.println("<td>" + rs.getMobileno() + "</td>");
			    out.println("<td>" + rs.getGender() + "</td>");
			    out.println("<td>" + rs.getRelocate()+ "</td>");
			    out.println("<td>" + rs.getPreviouscompany()+ "</td>");
			    out.println("<td>" + rs.getExperience()+ "</td>");
			    out.println("<td>" + rs.getRelocate()+ "</td>");
			    out.println("<td>" + rs.getResume()+ "</td>");
	        }
			    out.println("</tr>");
			    out.println("</table>");
			    
         } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (rs != null) rs.close();
	                if (statement != null) statement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
            %>
</body>
</html>