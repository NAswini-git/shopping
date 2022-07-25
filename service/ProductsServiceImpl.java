package com.shopping.service;

import java.util.List;

import com.shopping.dao.ModifyProductsDAO;
import com.shopping.dao.Products;
import com.shopping.dao.ProductsDAO;

/**
 * Implementing class for data modification in product table.
 * @author AswiniN
 *
 */
public class ProductsServiceImpl implements ProductsService {
	private static final ProductsDAO PRODUCTS_DAO = new ProductsDAO();
	private static final ModifyProductsDAO  MODIFY_PRODUCTS_DAO = new ModifyProductsDAO();
	
	/**
	 * To show the products available. 
	 */
	public List<Products> showProductDetails() {
		System.out.println("Products Available:");
		List<Products> productsList = PRODUCTS_DAO.selectAllProducts();
		System.out.println(productsList);
		return productsList;
	}
    
	/**
	 * To insert product.
	 */
	public boolean insertProduct(Products products) {
		return MODIFY_PRODUCTS_DAO.insertProduct(products);
	}
	
	/**
	 * To delete product.
	 */
	public boolean deleteProducts(Products products) {
		return MODIFY_PRODUCTS_DAO.deleteProduct(products);
	}
    
	/**
	 * To update product.
	 */
	public boolean updateProducts(Products products) {
		System.out.println("pricein impl"+products.getPrice());
		return MODIFY_PRODUCTS_DAO.updateProduct(products);
	}

}
