package com.telefonica.jee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.telefonica.jee.dao.*;

import com.telefonica.jee.model.Categorias;


@WebServlet("/CategoriasController")
public class CategoriasController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	CategoriasDAO categoriasDAO = null;
	//ManufacturerDAO manufacturerDAO = null;
	
	public CategoriasController() {
		categoriasDAO = new CategoriasDAOImpl();
		//manufacturerDAO = new ManufacturerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listCategorias(request, response);
				break;
				
			case "EDIT":
				getSingleCategorias(request, response);
				break;
				
			case "DELETE":
				deleteCategorias(request, response);
				break;
				
			default:
				listCategorias(request, response);
				break;
				
		}
		
	}

	private void deleteCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(categoriasDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Categorias Deleted Successfully!");
		}
		
		listCategorias(request, response);
	}

	private void getSingleProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Categorias theCategorias = categoriasDAO.get(Integer.parseInt(id));
		
		request.setAttribute("categorias", theCategorias);
		
		dispatcher = request.getRequestDispatcher("/views/categorias-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Manufacturer> theListM = manufacturerDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Categorias> theList = categoriasDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/categorias-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Categorias categorias = new Categorias();
		categorias.setName(request.getParameter("name"));
		
		
		
		if(id.isEmpty() || id == null) {
			
			if(categoriasDAO.save(categorias)) {
				request.setAttribute("NOTIFICATION", "Categorias Saved Successfully!");
			}	
		}else {	
			((Object) categorias).setId(id);
			if(categoriasDAO.update(categorias)) {
				request.setAttribute("NOTIFICATION", "Categorias Updated Successfully!");
			}	
		}
		listCategorias(request, response);
	}

}
