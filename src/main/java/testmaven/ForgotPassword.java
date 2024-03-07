package testmaven;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");

        // Check if email exists in the database
        try {
			if (emailExists(email)) {
			    // Generate OTP
			    String otp = generateOTP();

			    // Store OTP in session
			    HttpSession session = request.getSession();
			    session.setAttribute("otp", otp);
			    session.setAttribute("email", email);

			    // Send OTP via email (Not implemented in this example)

			    // Redirect to OTP verification page
			    response.sendRedirect("otp.jsp");
			} else {
			    // Handle case where email doesn't exist
			    response.sendRedirect("forgotPassword.jsp?error=email_not_found");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private boolean emailExists(String email) throws ClassNotFoundException {
        // Implement database connection and query to check if email exists
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Establish connection
			Class.forName("com.mysql.jdbc.Driver");

        	Connection conn1 = DriverManager.getConnection("jdbc:mysql:///joins?characterEncoding=utf8", "root",
					"Dattu@123");            
            // Prepare statement
            stmt = conn1.prepareStatement("SELECT * FROM Employee WHERE email = ?");
            stmt.setString(1, email);
            
            // Execute query
            rs = stmt.executeQuery();
            
            // Check if email exists
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateOTP() {
        // Generate OTP (Using UUID)
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

}
