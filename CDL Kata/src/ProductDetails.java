import java.util.*;

public class ProductDetails {

	public String name;
	public Integer quantity;
	public Double price;

	public ProductDetails(String name, Integer quantity, Double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public static HashMap<String, Double> productPrice = new HashMap<String, Double>();
	static {
		productPrice.put("A", 50.0);
		productPrice.put("B", 30.0);
		productPrice.put("C", 20.0);
		productPrice.put("D", 15.0);
	}

	public static HashMap<String, ProductDetails> productOffer = new HashMap<String, ProductDetails>();
	static {
		productOffer.put("A", new ProductDetails("A", 3, 130.0));
		productOffer.put("B", new ProductDetails("B", 2, 45.0));
		productOffer.put("C", new ProductDetails("C", 1, 20.0));
		productOffer.put("D", new ProductDetails("D", 1, 15.0));
	}

}