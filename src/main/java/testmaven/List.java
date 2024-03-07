package testmaven;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Configuration configuration = new Configuration().configure();
	        org.hibernate.SessionFactory sessionFactory = configuration.buildSessionFactory();

	        try (Session session = sessionFactory.openSession()) {
	            // HQL query to fetch all employees
	            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
	            java.util.List<Employee> employees = query.list();
	            // Prepare response
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<html><body>");
	            out.println("<h2>Employee Details</h2>");

	            // Iterate through the list of employees and display details
	            for (Employee employee : employees) {
	                out.println("<p>ID: " + employee.getId() + "</p>");
	                out.println("<p>Name: " + employee.getFullname() + "</p>");
	                out.println("<p>Email: " + employee.getEmail() + "</p>");
	                out.println("<p>Designation: " + employee.getDesignation() + "</p>");
	                out.println("<p>Gender: " + employee.getGender() + "</p>");
	                out.println("<p>Mobileno: " + employee.getMobileno() + "</p>");
	                out.println("<p>Previouscompany: " + employee.getPreviouscompany() + "</p>");
	                out.println("<p>Experience: " + employee.getExperience() + "</p>");
	                out.println("<p>Relocate: " + employee.getRelocate() + "</p>");
	                out.println("<p>Resume: " + employee.getResume() + "</p>");

	                out.println("<hr>");
	            }

	            out.println("</body></html>");
	        } catch (Exception e) {
	            // Handle any exceptions
	            e.printStackTrace();
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<html><body>");
	            out.println("<h2>An error occurred while processing your request.</h2>");
	            out.println("</body></html>");
	        } finally {
	            sessionFactory.close(); // Close session factory
	        }
	    }
	}


