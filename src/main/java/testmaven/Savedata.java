package testmaven;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.DatatypeConverter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class Savedata
 */
@WebServlet("/Savedata")
@MultipartConfig
public class Savedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Savedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String id=request.getParameter("id");  
        int i = Integer.parseInt(id);
        String fullname=request.getParameter("fullname");  
        String email=request.getParameter("email");  
        String designation=request.getParameter("designation");  

 String mobileno = request.getParameter("mobileno"); 
	
	 String password=request.getParameter("password");
     //String hashedPassword = hashPassword(password); // Hash the password

 
 String gender=request.getParameter("gender");
        String relocate=request.getParameter("relocate");
        String previouscompany=request.getParameter("previouscompany");
        String experience=request.getParameter("experience");
        //String resume=request.getParameter("resume");

        Part resumePart = request.getPart("resume");

        InputStream resumeInputStream = resumePart.getInputStream();

        
        
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
       
		
		Employee emp=new Employee();
          
		 
		
		emp.setId(i);
		emp.setFullname(fullname);
		emp.setEmail(email);
		emp.setDesignation(designation);
        emp.setMobileno(mobileno);
		emp.setPassword(password);
 		emp.setGender(gender);
		emp.setRelocate(relocate);
		emp.setPreviouscompany(previouscompany);
 		emp.setExperience(experience);
        try {
			emp.setResume(createBlob(resumeInputStream, (int)resumePart.getSize()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Create Blob from InputStream

 		
		 
 		
        
		 
         session.save(emp);
		tx.commit();
		sessionFactory.close();
		session.close();
		resumeInputStream.close();
		 out.println("<script>alert('Signup successful');</script>");
		    response.sendRedirect("login.jsp");
	}

	 
    private Blob createBlob(InputStream inputStream, int size) throws IOException, SQLException {
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        return new SerialBlob(buffer);
    }

	private String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(password.getBytes());
	            byte[] digest = md.digest();
	            return DatatypeConverter.printHexBinary(digest).toLowerCase();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	}
	 
	}


