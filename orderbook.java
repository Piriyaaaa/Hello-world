package okx;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.json.JSONObject;

public class orderbook {

	orderbook orderbook = new orderbook();
	String price = "message";
	private BigDecimal bids;
	private BigDecimal asks;

	public static void main(String[] args) {
		// generics
		ArrayList<BigDecimal> bid1 = new ArrayList<>();
		ArrayList<BigDecimal> ask1 = new ArrayList<>();

		System.out.println(bid1.get(0));
		System.out.println(ask1.get(0));

	}

}
