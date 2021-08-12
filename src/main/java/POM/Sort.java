package POM;

import java.util.Comparator;

///print $ verify compare list

public class Sort  implements Comparator<Product>{
	public int compare(Product B1, Product B2) {
		return (int) (Double.parseDouble(B1.price)-Double.parseDouble(B2.price));
	}
}

