package com.shopping.view;

import com.shopping.dao.Products;

/**
 * To modify the data of products in the table.
 * @author AswiniN
 *
 */
public class AlterProducts {
	 static Products products = new Products();
	/**
	 * To delete a product.
	 * @return
	 */
	public static Products getDeleteDetails() {
       
		
		System.out.println("Enter Product Name:");
		products.setProductName(LoginPortal.SCANNER.next());
		System.out.println("Enter Brand Name:");
		products.setBrandName(LoginPortal.SCANNER.next());
		return products;
	}
	
	/**
	 * To update a product.
	 * @return
	 */
	public static Products getUpdateDetails() {
		 System.out.println("Enter Product Name:");
		 products.setProductName(LoginPortal.SCANNER.next());
		 System.out.println("Update Criteria: 1. Price 2. Size 3. Quantity 4. All");
		 final int updateChoice = LoginPortal.SCANNER.nextInt();
		 
		 switch(updateChoice) {
		 case 1:
			 //System.out.println("name:"+products.getProductName());
			 products = AlterProducts.getPrice();
			 System.out.println(products.getPrice());
			 break;
		 }
		return products;
	}

	private static Products getPrice() {
		System.out.println("Enter Price");
		products.setPrice(LoginPortal.SCANNER.next());
		return products;	
	}
}
