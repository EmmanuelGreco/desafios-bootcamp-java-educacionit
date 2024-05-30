package com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.model.Empleado;

@WebServlet("/home") 
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Uso la correspondiente validación de if para no acceder 
		// a la lista de empleados a través del link y saltarse el ingreso de las credenciales.
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("email") != null) {
			
			List<Empleado> empleados = new ArrayList<>();
			
			empleados.add(new Empleado(1000, "Sánchez", "José", 7, "Corporate Coordinator"));
			empleados.add(new Empleado(2000, "González", "Susana", 6, "Academic Director"));
			empleados.add(new Empleado(3000, "Martínez", "Roberto", 6, "SR Full-Stack Developer"));
			empleados.add(new Empleado(4000, "Pérez", "Juan", 4, "Academic Coordinator"));
			empleados.add(new Empleado(5000, "López", "María", 4, "Lead Advisor"));
			empleados.add(new Empleado(6000, "Fernández", "Mario", 3, "Marketing Coordinator"));
			empleados.add(new Empleado(7000, "Hernández", "Pedro", 2, "Graphic Designer"));
			empleados.add(new Empleado(8000, "Gómez", "Carlos", 2, "Academic Assistant"));
			empleados.add(new Empleado(9000, "Rodríguez", "Micaela", 1, "Community Manager"));
			empleados.add(new Empleado(10000, "Díaz", "Claudia", 1, "Bootcamp Assistant"));
						
			session.setAttribute("listaEmpleados", empleados);

			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			//response.sendRedirect("login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
