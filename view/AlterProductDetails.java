package com.shopping.view;

import com.shopping.controller.ProductsController;
import com.shopping.dao.Products;

/**
 * It is meant to get the choice of modification by the admin.
 * @author AswiniN
 *
 */
public class AlterProductDetails {

	/**
	 * It gets the choice from admin.
	 */
	public static void getAdminChoice() {
		final ProductsController productController = new ProductsController();
		Products products = new Products();
		System.out.println("1. INSERT  2. VIEW  3. UPDATE  4. DELETE ");
		int adminChoice = LoginPortal.SCANNER.nextInt();
		
		switch(adminChoice) {
		case 1: 
			products = InsertProducts.getProductDetails();
			boolean insertStatus = productController.insertProduct(products);
			
			if(insertStatus) {
				System.out.println("Successfully inserted");
			} else {
			    System.out.println("Insertion failed!! Try again.");
			    products = InsertProducts.getProductDetails();
			}
			AlterProductDetails.getAdminChoice();
		    break;
		
		case 2:
			productController.showProductDetails();
			break;
		
		case 3:
			products = AlterProducts.getUpdateDetails();
			boolean updateStatus = productController.updateProducts(products);
			if (!updateStatus) {
				System.out.println("Successful !!");
			} else {
				System.out.println("Failed");
				products = AlterProducts.getUpdateDetails();
				
			}
			AlterProductDetails.getAdminChoice();
			break;
		
		case 4:
			products = AlterProducts.getDeleteDetails();
			boolean deleteStatus = productController.deleteProduct(products);
			if(deleteStatus) {
				System.out.println("Product Deleted Successfully");
			} else {
				System.out.println("Deletion failed!! Try again");
				products = AlterProducts.getDeleteDetails();
			}
			AlterProductDetails.getAdminChoice();
			break;
		default:
			System.out.println("Enter choice 1 to 4.");
			AlterProductDetails.getAdminChoice();
		}
	}

}
