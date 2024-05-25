package it.unisannio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("./Login.html");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String filePath = "C:\\Users\\simon\\eclipse-workspace\\registrazioni.txt";
		FileInputStream fis = new FileInputStream(filePath);
		Scanner sc = new Scanner(fis);
		boolean login = false;
		String line = null;
		do {
			line = sc.nextLine();
			if((line!=null)&&line.startsWith("email")){
				String un = line.substring(line.indexOf(":")+1).trim();
				if(un.equals(email)) {
					String pw = sc.nextLine().substring(line.indexOf(":")+1).trim();
					if(pw.equals(password)) {
						login = true;
					}
				}
			}
		}while(!login && sc.hasNextLine());
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String output =
				"<HTML>"+
						"<head>"+
							"<title> login </title>"+
						"</head>"+
						"<body>" +
							"<h2>" +
							(login ? "Welcome" : "Login failed") +
							"</h2>" +
						"</body>" +
				"</HTML>";
		pw.print(output);
		pw.flush();
		sc.close();
	}

}
