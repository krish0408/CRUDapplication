package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.vo.Product;

/**
 * Servlet implementation class Edit2servlet
 */
@WebServlet("/edit2")
public class Edit2servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        Float price=Float.parseFloat(request.getParameter("price"));  
        String Description=request.getParameter("desription");  
        Integer Quantity=Integer.parseInt(request.getParameter("quantity"));  
          
          
        Product p=new Product();  
        p.setId(id);  
        
        p.setName(name);  
        p.setPrice(price);  
        p.setDescription(Description);  
        p.setQuantity(Quantity);   
          
        int status=ProductDAO.update(p);  
        if(status>0){  
            response.sendRedirect("view");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
	}


