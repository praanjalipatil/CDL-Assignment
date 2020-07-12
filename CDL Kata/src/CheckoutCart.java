import java.util.*;
import java.util.Map.Entry;

public class CheckoutCart {

	public HashMap<String, Integer> productList = new HashMap<String, Integer>();

	public void addProductToCart(String item, Integer quantity) {
		if (!productList.containsKey(item))
			productList.put(item, quantity);
		else
			productList.put(item, quantity + productList.get(item));
	}

	public void reviewCart() throws Exception {
		if (productList.isEmpty())
			throw new Exception("Your Cart is Empty");

		System.out.println("\nYour Cart ::");
		System.out.println("\n\tItem" + "\tQuantity" + "\tPrice Per Item" + "\t\tNet Total" + "\tOfferPrice");

		for (Map.Entry<String, Integer> entry : productList.entrySet()) {
			System.out.println("\t " + entry.getKey() + " \t " + entry.getValue() + "\t\t "
					+ ProductDetails.productPrice.get(entry.getKey()) + "\t\t\t "
					+ (ProductDetails.productPrice.get(entry.getKey()) * entry.getValue()) + "\t\t "
					+ calculateDiscountedPrice(entry));
		}
	}

	private double calculateDiscountedPrice(Entry<String, Integer> entry) {
		ProductDetails offer = ProductDetails.productOffer.get(entry.getKey());
		double discountedPrice = (entry.getValue() % offer.quantity) * ProductDetails.productPrice.get(entry.getKey())
				+ (entry.getValue() / offer.quantity) * offer.price;
		return discountedPrice;
	}

	public double calculateCartTotal(Map<String, Integer> productList) {
		double total = 0.0;

		for (Map.Entry<String, Integer> entry : productList.entrySet()) {
			if (ProductDetails.productOffer.containsKey(entry.getKey())) {
				total += calculateDiscountedPrice(entry);
			} else {
				total += (entry.getValue()) * ProductDetails.productPrice.get(entry.getKey());
			}

		}
		return total;
	}
}