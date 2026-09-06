package okx;

import com.neovisionaries.ws.client.*;
import org.json.JSONObject;
import org.json.JSONArray;
import java.math.BigDecimal;

public class WebSocketDemo {

	public static void main(String[] args) {
		System.out.println("Program start");

		try {
			WebSocket ws = new WebSocketFactory().createSocket("wss://ws.okx.com:8443/ws/v5/public");
			ws.addListener(new WebSocketAdapter() {

				public void onTextMessage(WebSocket websocket, String message) throws Exception {
					JSONObject json = new JSONObject(message);
					JSONArray data = json.getJSONArray("data");
					JSONObject ticker = data.getJSONObject(0);
					String priceStr = ticker.getString("last");
					BigDecimal price = new BigDecimal(priceStr);

					System.out.println("Price String = " + priceStr);
					System.out.println("BigDecimal Price =" + price);

				}
			});

			ws.connect();
			while (true) {
				System.out.println("tick");
				Thread.sleep(1000L);
				String a = "{\"op\":\"subscribe\",\"args\":[{\"channel\":\"tickers\",\"instId\":\"BTC-USDT\"}]}";

				ws.sendText(a);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
