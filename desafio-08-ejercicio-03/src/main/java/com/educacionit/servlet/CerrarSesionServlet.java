package com.educacionit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cerrarsesion") 
public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CerrarSesionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("email") != null) {
			
			response.setContentType("text/html; charset=UTF-8");
			// Este comando especifica la codificación de caracteres. Permite que al usar HTML en servlet
			// me permita mostrar caracteres como la Ñ o caracteres con tilde, por ejemplo
			PrintWriter printCerrarSesion = response.getWriter();
			session = request.getSession();		
			session.invalidate();
	
	    	RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");
			requestdispatcher.include(request, response);
			printCerrarSesion.println("<h3><font color=green>Gracias! Su sesión se ha cerrado exitosamente.</font></h3>");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			// Si usaría el forward de arriba, recargaría el jsp, y no mostraría el mensaje del printWriter.
			printCerrarSesion.close();
		} else {
			//response.sendRedirect("login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
