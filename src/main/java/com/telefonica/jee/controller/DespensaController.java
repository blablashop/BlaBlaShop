package com.telefonica.jee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.telefonica.jee.dao.*;

import com.telefonica.jee.model.Despensa;


@WebServlet("/DespensaController")
public class DespensaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	DespensaDAO despensaDAO = null;
	//ManufacturerDAO manufacturerDAO = null;
	
	public DespensaController() {
		despensaDAO = new DespensaDAOImpl();
		//manufacturerDAO = new ManufacturerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listDespensa(request, response);
				break;
				
			case "EDIT":
				getSingleDespensa(request, response);
				break;
				
			case "DELETE":
				deleteDespensa(request, response);
				break;
				
			default:
				listDespensa(request, response);
				break;
				
		}
		
	}

	private void deleteDespensa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(despensaDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Despensa Deleted Successfully!");
		}
		
		listDespensa(request, response);
	}

	private void getSingleProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Despensa theDespensa = despensaDAO.get(Integer.parseInt(id));
		
		request.setAttribute("despensa", theDespensa);
		
		dispatcher = request.getRequestDispatcher("/views/despensa-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listDespensa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Manufacturer> theListM = manufacturerDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Despensa> theList = despensaDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/despensa-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Despensa despensa = new Despensa();
		despensa.setName(request.getParameter("name"));
		
		
		
		if(id.isEmpty() || id == null) {
			
			if(despensaDAO.save(despensa)) {
				request.setAttribute("NOTIFICATION", "Despensa Saved Successfully!");
			}	
		}else {	
			despensa.setId(Integer.parseInt(id));
			if(despensaDAO.update(despensa)) {
				request.setAttribute("NOTIFICATION", "Despensa Updated Successfully!");
			}	
		}
		listDespensa(request, response);
	}

}
