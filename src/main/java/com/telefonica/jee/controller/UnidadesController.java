package com.telefonica.jee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.telefonica.jee.dao.*;

import com.telefonica.jee.model.Unidades;


@WebServlet("/UnidadesController")
public class UnidadesController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	UnidadesDAO unidadesDAO = null;
	//ManufacturerDAO manufacturerDAO = null;
	
	public UnidadesController() {
		unidadesDAO = new UnidadesDAOImpl();
		//manufacturerDAO = new ManufacturerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listUnidades(request, response);
				break;
				
			case "EDIT":
				getSingleUnidades(request, response);
				break;
				
			case "DELETE":
				deleteUnidades(request, response);
				break;
				
			default:
				listUnidades(request, response);
				break;
				
		}
		
	}

	private void deleteUnidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(unidadesDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Unidades Deleted Successfully!");
		}
		
		listUnidades(request, response);
	}

	private void getSingleUnidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Unidades theUnidades = unidadesDAO.get(Integer.parseInt(id));
		
		request.setAttribute("unidades", theUnidades);
		
		dispatcher = request.getRequestDispatcher("/views/unidades-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listUnidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Manufacturer> theListM = manufacturerDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Unidades> theList = unidadesDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/unidades-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Unidades unidades = new Unidades();
		unidades.setName(request.getParameter("name"));

		
		
		if(id.isEmpty() || id == null) {
			
			if(unidadesDAO.save(unidades)) {
				request.setAttribute("NOTIFICATION", "Unidades Saved Successfully!");
			}	
		}else {	
			unidades.setId(Integer.parseInt(id));
			if(unidadesDAO.update(unidades)) {
				request.setAttribute("NOTIFICATION", "Unidades Updated Successfully!");
			}	
		}
		listUnidades(request, response);
	}

}
