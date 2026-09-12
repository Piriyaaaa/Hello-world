package okx;

import com.neovisionaries.ws.client.*;
 //first I imported BigDecimal class because we use it in financial numbers and also it's exact.
import java.math.BigDecimal;

//I made an order class
public class Order {
    //I'm not sure for public or private!
	public String BuyOrSell;
	public BigDecimal price;
	public BigDecimal quantity;
    
	
	//used it to make an object for execution
	public void order(String BuyOrSell, BigDecimal price, BigDecimal quality) {
		String BuyOrSell1= BuyOrSell;
		BigDecimal price1 = price;
		BigDecimal quantity1 = quantity;
		
		
// I had some errors so Java and quide helped me to make them correct
		System.out.println(Order.getBuyOrSell());
		System.out.println(Order.getPrice());
		System.out.println(Order.getQuantity());

	}

	

	private static char[] getBuyOrSell() {
		// TODO Auto-generated method stub
		return null;
	}



	private static char[] getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}



	private static char[] getPrice() {
		// TODO Auto-generated method stub
		return null;
	}



	public static class WebSocketDemo {
		public static void main(String[] args) {
			
			//connect to OKX

		}
	}
}
