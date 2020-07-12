import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidationUtil {

	CheckoutCart cart = new CheckoutCart();

	Scanner scanner = new Scanner(System.in);

	public String validateItemInput(String item, Boolean isValid) {
		while (isValid == false) {
			if (scanner.hasNext("[A-Z]")) {
				item = scanner.next("[A-Z]");
				isValid = true;
			} else {
				System.out.println("Invalid Item");
			}
			scanner.nextLine();
		}
		return item;
	}

	public int validateItemQuantityInput(int quantity, Boolean isValid) {
		while (isValid == false) {
			if (scanner.hasNext("[0-9]")) {
				quantity = scanner.nextInt();
				isValid = true;
			} else {
				System.out.println("Invalid Quantity");
			}
			scanner.nextLine();
		}
		return quantity;
	}

}
