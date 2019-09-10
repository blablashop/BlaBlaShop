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
	
	public ProductController() {
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
				listProduct(request, response);
				break;
				
			case "EDIT":
				getSingleProduct(request, response);
				break;
				
			case "DELETE":
				deleteProduct(request, response);
				break;
				
			default:
				listProduct(request, response);
				break;
				
		}
		
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(productoDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Product Deleted Successfully!");
		}
		
		listProduct(request, response);
	}

	private void getSingleProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Producto theProduct = productoDAO.get(Integer.parseInt(id));
		
		request.setAttribute("product", theProduct);
		
		dispatcher = request.getRequestDispatcher("/views/producto-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Manufacturer> theListM = manufacturerDAO.get();
		
		request.getSession().setAttribute("listC", theListC);
		
		List<Producto> theList = productoDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/product-list.jsp");
		
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
