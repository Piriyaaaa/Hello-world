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

		bid1.add(new BigDecimal("80408.9"));
		ask1.add(new BigDecimal("80409"));
		
		
		System.out.println(bid1.getLast());
		System.out.println(ask1.getLast());
		

	}

}
