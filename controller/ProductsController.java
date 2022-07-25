package com.shopping.controller;

import java.util.List;

import com.shopping.dao.Products;
import com.shopping.service.ProductsService;
import com.shopping.service.ProductsServiceImpl;

/**
 * It controls the flow between view and service implementation for product table.
 * @author AswiniN
 *
 */
public class ProductsController {
    private static final ProductsService PRODUCTS_SERVICE = new ProductsServiceImpl();
	
    public List<Products> showProductDetails( ) {
		return PRODUCTS_SERVICE.showProductDetails();	
	}

    public  boolean insertProduct(Products products) {
		return PRODUCTS_SERVICE.insertProduct(products);
    }

	public boolean deleteProduct(Products products) {
		return PRODUCTS_SERVICE.deleteProducts(products);
	}

	public boolean updateProducts(Products products) {
		return PRODUCTS_SERVICE.updateProducts(products);
	}

	

}
