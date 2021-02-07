package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vo.Product;

public class ProductDAO {
	private static final String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
    //1,2,3,4,5
	private static final String SELECT_QUERY = "select * from test.product where id=?";
	private static final String SELECT_ALL_QUERY = "select * from test.product";
	private static final String UPDATE_PRODUCT_SQL = "update test.product set id = ?, name =?, price = ?, description = ?, quantity = ?";
    private static final String DELETE_PRODUCT_SQL = "delete from test.product where id =?";
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "Kri0357shna$");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Product p){  
        int status=0;  
        try{  
            Connection con=ProductDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(insertQuery);  
            ps.setString(1,p.getName());  
            ps.setFloat(2,p.getPrice());  
            ps.setString(3,p.getDescription());  
            ps.setInt(4,p.getQuantity());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Product p){  
        int status=0;  
        try{  
            Connection con=ProductDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(UPDATE_PRODUCT_SQL);  
            ps.setString(1,p.getName());  
            ps.setFloat(2,p.getPrice());  
            ps.setString(3,p.getDescription());  
            ps.setInt(4,p.getQuantity());  
            ps.setInt(5,p.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=ProductDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(DELETE_PRODUCT_SQL);  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Product getProductById(int id){  
        Product p=new Product();  
          
        try{  
            Connection con=ProductDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(SELECT_QUERY);  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                p.setId(rs.getInt(1));  
                p.setName(rs.getString(2));  
                p.setPrice(rs.getFloat(3));  
                p.setDescription(rs.getString(4));  
                p.setQuantity(rs.getInt(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return p;  
    }  
    public static List<Product> getAllProducts(){  
        List<Product> list=new ArrayList<Product>();  
          
        try{  
            Connection con=ProductDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(SELECT_ALL_QUERY);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Product p=new Product();  
                p.setId(rs.getInt(1));  
                p.setName(rs.getString(2));  
                p.setPrice(rs.getFloat(3));  
                p.setDescription(rs.getString(4));  
                p.setQuantity(rs.getInt(5));  
                list.add(p);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  

}
