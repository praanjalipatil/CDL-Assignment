import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupermarketBillingSystem {

	public static void main(String[] args) {

		CheckoutCart cart = new CheckoutCart();
		ValidationUtil validate = new ValidationUtil();
		Scanner scanner = new Scanner(System.in);
		do {

			String item = "";
			int quantity = 0;

			System.out.println("\nEnter Item: (Input must be - A/B/C/D )");
			item = validate.validateItemInput(item, false);

			System.out.println("Quantity of item " + item + ":");
			quantity = validate.validateItemQuantityInput(quantity, false);

			cart.addProductToCart(item, quantity);

			try {
				cart.reviewCart();
			} catch (Exception error) {
				System.out.println(error.getLocalizedMessage());
			}

			System.out.println("\n\t\t\t\t\t\t\t    Total Price: " + cart.calculateCartTotal(cart.productList));

		} while (true);

	}

}