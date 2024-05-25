package it.unisannio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Servlet implementation class registration
 */
@WebServlet("/Register")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("./registration.html");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		writeToFile(request);

        // Set response content type
        response.setContentType("text/html");

        // Create PrintWriter object
        PrintWriter out = response.getWriter();

        // Generate HTML response
        out.println("<html>");
        out.println("<head><title>Registration Confirmation</title></head>");
        out.println("<body>");
        out.println("<p>" + request.getParameter("firstname") + ", your registration has been executed correctly.</p>");
        out.println("</body>");
        out.println("</html>");
	}

	private void writeToFile(HttpServletRequest request) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\simon\\eclipse-workspace\\registrazioni.txt";
    	File f = new File(filePath);
    	FileOutputStream fos = new FileOutputStream(f);
    	PrintStream ps = new PrintStream(fos);
    	       
    	ps.println("nome    :"+request.getParameter("firstname"));
    	ps.println("cognome :"+request.getParameter("lastname"));
    	ps.println("email   :"+request.getParameter("email"));
    	ps.println("password:"+request.getParameter("password"));
    	ps.close();  
	}

}
