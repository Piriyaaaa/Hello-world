package Intermediate;
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveElementArrayList {
    public static void main(String[] args) {
    	ArrayList<String> carBrand = new ArrayList<>();
    	carBrand.add("Ford");
    	carBrand.add("Valkswagen");
    	carBrand.add("Chrysler");
    	carBrand.add("Toyota");
    	carBrand.add("Honda");
    	
    	System.out.println("Original ArrayList:" + carBrand);
    	
    	Iterator <String> iterator = carBrand.iterator();
    	while (iterator.hasNext()) {
    		String brand = iterator.next();
    		
    		if (!brand.equals("Ford")) {
    		iterator.remove();
    	}
    	
    }
    System.out.println("Modified ArrayList:" + carBrand);
}
}


