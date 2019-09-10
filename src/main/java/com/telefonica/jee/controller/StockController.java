package com.telefonica.jee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.telefonica.jee.dao.*;

import com.telefonica.jee.model.Stock;
import javax.servlet.http.HttpServlet;

@WebServlet("/StockController")
public class StockController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	StockDAO stockDAO = null;
	//ManufacturerDAO manufacturerDAO = null;
	
	public StockController() {
		stockDAO = new StockDAOImpl();
		//manufacturerDAO = new ManufacturerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listStock(request, response);
				break;
				
			case "EDIT":
				getSingleStock(request, response);
				break;
				
			case "DELETE":
				deleteStock(request, response);
				break;
				
			default:
				listStock(request, response);
				break;
				
		}
		
	}

	private void deleteStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(stockDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Stock Deleted Successfully!");
		}
		
		listStock(request, response);
	}

	private void getSingleStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Stock theStock = stockDAO.get(Integer.parseInt(id));
		
		request.setAttribute("stock", theStock);
		
		dispatcher = request.getRequestDispatcher("/views/stock-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Manufacturer> theListM = manufacturerDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Stock> theList = stockDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/stock-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Stock stock = new Stock();
		stock.setName(request.getParameter("name"));
		stock.setPrecio(new BigDecimal (request.getParameter("price")));
		
		
		if(id.isEmpty() || id == null) {
			
			if(stockDAO.save(stock)) {
				request.setAttribute("NOTIFICATION", "Stock Saved Successfully!");
			}	
		}else {	
			stock.setId(Integer.parseInt(id));
			if(stockDAO.update(stock)) {
				request.setAttribute("NOTIFICATION", "Stock Updated Successfully!");
			}	
		}
		listStock(request, response);
	}

}
