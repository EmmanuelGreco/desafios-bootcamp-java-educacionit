package com.educacionit.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
		// Si utilizo doPost, haría una validación.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setContentType("text/html; charset=UTF-8");
		// Este comando especifica la codificación de caracteres. Permite que al usar HTML en servlet
		// me permita mostrar caracteres como la Ñ o caracteres con tilde, por ejemplo.
        
        Map<String, String> usuarios = new HashMap<>();
        usuarios.put("usuario1", "clave1");
        usuarios.put("usuario2", "clave2");
        usuarios.put("usuario3", "clave3");
        usuarios.put("admin", "admin");
        usuarios.put("root", "root");
        
        String emailusuario = request.getParameter("email");
        String claveusuario = request.getParameter("clave");
  
        if (usuarios.containsKey(emailusuario) && usuarios.get(emailusuario).equals(claveusuario)) {        	
        		HttpSession session = request.getSession(true);
        		session.setAttribute("email", emailusuario);
        		response.sendRedirect("home");
        } else {
        	request.setAttribute("mensaje", "El usuario o la contraseña son incorrectos!");
        	RequestDispatcher requestdispatcher = request.getRequestDispatcher("login.jsp");  
        	requestdispatcher.include(request, response);
        }
	}
}
