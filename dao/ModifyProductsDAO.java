package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * To modify the product table using SQL Queries.
 * @author AswiniN
 *
 */
public class ModifyProductsDAO {
	/**
	 * It insert new products to the table.
	 * @param products
	 * @return
	 */
	public boolean insertProduct(Products products) {
        final String INSERT_PRODUCT = "Insert into products(product_name, brand_name, price, size, user, quantity)values(?,?,?,?,?,?)";
		
        try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);) {
			  
			preparedStatement.setString(1, products.getProductName());
			preparedStatement.setString(2, products.getBrandName());
			preparedStatement.setString(3, products.getPrice());
			preparedStatement.setString(4, products.getSize());
			preparedStatement.setString(5, products.getUser());
			preparedStatement.setInt(6, products.getQuantity());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error occured while inserting product details.");
		}
		return true;
	}
    
	/**
	 * It deletes the product from table specified by the user.
	 * @param products
	 * @return
	 */
	public boolean deleteProduct(Products products) {
		final String DELETE_PRODUCT = "Delete from products where product_name = ? and brand_name =?";
		try (Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);) {
				
			preparedStatement.setString(1, products.getProductName());
			preparedStatement.setString(2, products.getBrandName());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error occured while deleting the product.");
			
		}
		return true;
	}
    
	/**
	 * It updates the record of the table.
	 * @param products
	 * @return
	 */
	public boolean updateProduct(Products products) {
		System.out.println("pdt"+products.getPrice());
		System.out.println("pdtin dao"+products.getProductName());
		final String UPDATE_PRODUCT = "Update products set price =? where product_name =?";
		
		try (Connection connection = DatabaseConnection.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
		    System.out.println("pdt"+products.getProductName());
		    
			preparedStatement.setString(1, products.getPrice());
			preparedStatement.setString(2, products.getProductName());
			
			return preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println("Update failure!");
		}		
		return false;
	}
}
