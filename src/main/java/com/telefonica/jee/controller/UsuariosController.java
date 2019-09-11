package com.telefonica.jee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telefonica.jee.dao.UsuariosDAO;
import com.telefonica.jee.dao.UsuariosDAOImpl;
import com.telefonica.jee.model.Usuarios;

@WebServlet("/UsuariosController")
public class UsuariosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	UsuariosDAO usuariosDAO = null;
	// ManufacturerDAO manufacturerDAO = null;

	public UsuariosController() {
		usuariosDAO = new UsuariosDAOImpl();
		// manufacturerDAO = new ManufacturerDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {

		case "LIST":
			listUsuarios(request, response);
			break;

		case "EDIT":
			getSingleUsuarios(request, response);
			break;

		case "DELETE":
			deleteUsuarios(request, response);
			break;

		default:
			listUsuarios(request, response);
			break;

		}

	}

	private void deleteUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (usuariosDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Usuario Deleted Successfully!");
		}

		listUsuarios(request, response);
	}

	private void getSingleUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Usuarios theUsuarios = usuariosDAO.get(Integer.parseInt(id));

		request.setAttribute("usuarios", theUsuarios);

		dispatcher = request.getRequestDispatcher("/views/usuarios-form.jsp");

		dispatcher.forward(request, response);
	}

	private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// List<Manufacturer> theListM = manufacturerDAO.get();

		// request.getSession().setAttribute("listC", theListC);

		List<Usuarios> theList = usuariosDAO.get();

		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/usuarios-list.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Usuarios usuarios = new Usuarios();
		usuarios.setName(request.getParameter("name"));
		usuarios.setUser(request.getParameter("user"));
		usuarios.setPassword(request.getParameter("password"));
		usuarios.setEmail(request.getParameter("email"));

		if (id.isEmpty() || id == null) {

			if (usuariosDAO.save(usuarios)) {
				request.setAttribute("NOTIFICATION", "Usuario Saved Successfully!");
			}
		} else {
			usuarios.setId(Integer.parseInt(id));
			if (usuariosDAO.update(usuarios)) {
				request.setAttribute("NOTIFICATION", "Usuario Updated Successfully!");
			}
		}
		listUsuarios(request, response);
	}

}
