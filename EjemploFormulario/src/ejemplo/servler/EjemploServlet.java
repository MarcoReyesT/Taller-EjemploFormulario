package ejemplo.servler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejemplo.domain.Contacto;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet("/EjemploServlet")
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		out.println(" Hola tu nombre es " + nombre + ". Saludos!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean nombr = false, apell = false, eMaill = false, telef = false;
		List<Contacto> oContactoLista = new ArrayList<Contacto>();
		oContactoLista.add(new Contacto("Victor", "Aravena",
				"victor.aravena@ufrontera.cl", "111111"));
		oContactoLista.add(new Contacto("Patricio", "Gonzalez", "pg@algo.cl",
				"111111"));
		String nombre = request.getParameter("nombre");
		if (!nombre.equals("") && !nombre.equals(null)) {
			nombr = true;
		}
		String apellido = request.getParameter("apellido");
		if (!apellido.equals("") && !apellido.equals(null)) {
			apell = true;
		}
		String mail = request.getParameter("mail");
		if (!mail.equals("") && !mail.equals(null)) {
			eMaill = true;
		}
		String telefono = request.getParameter("telefono");
		if (!telefono.equals("") && !telefono.equals(null)) {
			telef = true;
		}
		if (telef && nombr && apell && eMaill) {
			oContactoLista.add(new Contacto(nombre, apellido, mail, telefono));
			request.setAttribute("listaContacto", oContactoLista);
			
			request.getRequestDispatcher("/Formulario.jsp").forward(request,
					response);
		} else {
			request.setAttribute("mensaje", " Uno o mas datos nulos");
			request.getRequestDispatcher("/Formulario.jsp").forward(request, response);
		}
		
	}
}
