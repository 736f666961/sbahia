package ma.youcode.sbahia.dao;

import java.util.List;

import ma.youcode.sbahia.models.Product;

public interface ProductDao {
	
	/**
	 * Add new product
	 * @param id
	 * @param productImage
	 * @param productName
	 * @param ProductDescription
	 * @return
	 */
	int addProduct(String productImage, String productName, String ProductDescription);
	
	/**
	 * Edit an existing product
	 * @param id
	 * @param productImage
	 * @param productName
	 * @param ProductDescription
	 * @return
	 */
	int editProduct(int id, String productImage, String productName, String ProductDescription);
	
	/**
	 * Delete a product
	 * @param id
	 * @return
	 */
	int deleteProduct(int id);
    
	/**
	 * Get all products
	 * @return a list of all products
	 */
	List<Product> getAllProducts();
	
    /**
     * Get product by an id
     * @param productID
     * @return an article by passing its id
     */
    List<Product> getProductById(int productID);
	
	/**
	 * Like the product
	 * @param id - Id of product
	 */
	void like(int id);
	
	/**
	 * Dislike the product
	 * @param id - Id of product
	 */
	void dislike(int id);
}
