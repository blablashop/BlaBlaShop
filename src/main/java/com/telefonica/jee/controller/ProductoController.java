package com.telefonica.jee.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.telefonica.jee.dao.*;

import com.telefonica.jee.model.Producto;
import javax.servlet.http.HttpServlet;

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
		
		request.getSession().setAttribute("listC", theListC);
		
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
		listProduct(request, response);
	}

}
