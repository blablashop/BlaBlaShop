package com.telefonica.jee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telefonica.jee.dao.ProductoDAO;
import com.telefonica.jee.dao.ProductoDAOImpl;
import com.telefonica.jee.model.Producto;

@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	ProductoDAO productoDAO = null;
	//ManufacturerDAO manufacturerDAO = null;
	
	public ProductoController() {
		productoDAO = new ProductoDAOImpl();
		//manufacturerDAO = new ManufacturerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listProducto(request, response);
				break;
				
			case "EDIT":
				getSingleProducto(request, response);
				break;
				
			case "DELETE":
				deleteProducto(request, response);
				break;
				
			default:
				listProducto(request, response);
				break;
				
		}
		
	}

	private void deleteProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(productoDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Product Deleted Successfully!");
		}
		
		listProducto(request, response);
	}

	private void getSingleProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Producto theProducto = productoDAO.get(Integer.parseInt(id));
		
		request.setAttribute("producto", theProducto);
		
		dispatcher = request.getRequestDispatcher("/views/producto-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Manufacturer> theListM = manufacturerDAO.get();
		
		//request.getSession().setAttribute("listC", theListC);
		
		List<Producto> theList = productoDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/producto-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Producto producto = new Producto();
		producto.setName(request.getParameter("name"));
		producto.setPrecio(new BigDecimal (request.getParameter("price")));
		
		
		if(id.isEmpty() || id == null) {
			
			if(productoDAO.save(producto)) {
				request.setAttribute("NOTIFICATION", "Product Saved Successfully!");
			}	
		}else {	
			producto.setId(Integer.parseInt(id));
			if(productoDAO.update(producto)) {
				request.setAttribute("NOTIFICATION", "Product Updated Successfully!");
			}	
		}
		listProducto(request, response);
	}

}
