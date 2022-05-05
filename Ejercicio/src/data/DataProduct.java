package data;

import java.sql.*;
import java.time.*;
import java.util.LinkedList;

import entidades.Product;


public class DataProduct {
	
	public LinkedList<Product> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Product> products = new LinkedList<>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select * from product");
			
			if(rs != null) {
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt("id"));
					p.setDescription(rs.getString("description"));
					p.setPrice(rs.getDouble("price"));
					p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
					p.setStock(rs.getInt("stock"));				
					p.setDisabledOn(rs.getObject("disabledOn",LocalDateTime.class));
					p.setDisabledDate(rs.getObject("disabledDate",LocalDate.class));
					p.setDisabledTime(rs.getObject("disabledTime",LocalTime.class));
					
					products.add(p);
				}							
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		
		return products;
	}
	
	public Product getById(String id) {
		
		Product product = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select id,description,price,shippingIncluded,stock from product where id = ?");
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			
			if(rs != null) {				
				product = new Product();
				
				while(rs.next()) {
					product.setId(rs.getInt("id"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getDouble("price"));
					product.setShippingIncluded(rs.getBoolean("shippingIncluded"));
					product.setStock(rs.getInt("stock"));
					product.setDisabledOn(rs.getObject("disabledOn",LocalDateTime.class));
					product.setDisabledDate(rs.getObject("disabledDate",LocalDate.class));
					product.setDisabledTime(rs.getObject("disabledTime",LocalTime.class));
				}	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
			try {
				
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		
		return product;
		
	}
	
	public void add(Product p) {
		
		PreparedStatement stmt = null;
		
		try {			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
							"insert into product(description, price, shippingIncluded, stock, disabledOn, disabledDate, disabledTime) values (?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
			);
			
			stmt.setString(1, p.getDescription());
			stmt.setDouble(2, p.getPrice());
			stmt.setBoolean(3, p.isShippingIncluded());
			stmt.setInt(4, p.getStock());
			stmt.setTimestamp(5,Timestamp.valueOf(p.getDisabledOn()));
			stmt.setDate(6,Date.valueOf(p.getDisabledDate()));
			stmt.setTime(7,Time.valueOf(p.getDisabledTime()));
			
			stmt.executeUpdate();			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null) {
                	stmt.close();
                }
                
                DbConnector.getInstancia().releaseConn();
                                
            } catch (SQLException e) {
				// TODO Auto-generated catch block
            	e.printStackTrace();
            }
		}
    }
	
	public void update(Product product) {
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
							"UPDATE product SET description = ?, price = ?, shippingIncluded = ?, stock = ?, disabledOn = ?, disabledDate = ?, disabledTime = ? where id = ?"
			);
			
			stmt.setString(1, product.getDescription());
			stmt.setDouble(2, product.getPrice());
			stmt.setBoolean(3, product.isShippingIncluded());
			stmt.setInt(4, product.getStock());
			stmt.setTimestamp(5,Timestamp.valueOf(product.getDisabledOn()));
			stmt.setDate(6,Date.valueOf(product.getDisabledDate()));
			stmt.setTime(7,Time.valueOf(product.getDisabledTime()));
			stmt.setInt(8,product.getId());

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		} finally {
            try {
            	
                if(stmt!=null) {
                	stmt.close();
                }
                
				DbConnector.getInstancia().releaseConn();
                
            } catch (SQLException e) {
				// TODO Auto-generated catch block
            	e.printStackTrace();
            }
		}
	}
	
	public void delete(Product product) {
		
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
							"DELETE FROM product WHERE id = ?"
			);
			stmt.setInt(1, product.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		} finally {
            try {
            	
                if(stmt!=null) {
                	stmt.close();
                }
                
                DbConnector.getInstancia().releaseConn();
                
            } catch (SQLException e) {
				// TODO Auto-generated catch block
            	e.printStackTrace();
            }
		}		
		
	}

}
