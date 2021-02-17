package ma.youcode.sbahia.models;

public class Product {
	private int id;
	private String productImage;
	private String productName;
	private String productDescription;
	private int productLikes;
	private int productDislikes;
	private boolean isInteracted;
	
	public Product() {
		super();
	}
	
	public Product(int id, String productImage, String productName, String productDescription) {
		super();
		this.id = id;
		this.productImage = productImage;
		this.productName = productName;
		this.productDescription = productDescription;
	}
	
	/**
	 * @return the isInteracted
	 */
	public boolean isInteracted() {
		return isInteracted;
	}

	/**
	 * @param isInteracted the isInteracted to set
	 */
	public void setInteracted(boolean isInteracted) {
		this.isInteracted = isInteracted;
	}

	public Product(int id, String productImage, String productName, String productDescription, int productLikes, int productDislikes, boolean isInteracted) {
		super();
		this.id = id;
		this.productImage = productImage;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productLikes = productLikes;
		this.productDislikes = productDislikes;
		this.isInteracted = isInteracted;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the productImage
	 */
	public String getProductImage() {
		return productImage;
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * @return the productDescription
	 */
	public String getproductDescription() {
		return productDescription;
	}

	/**
	 * @return the productLikes
	 */
	public int getProductLikes() {
		return productLikes;
	}
	
	/**
	 * @return the productDislikes
	 */
	public int getProductDislikes() {
		return productDislikes;
	}

}
