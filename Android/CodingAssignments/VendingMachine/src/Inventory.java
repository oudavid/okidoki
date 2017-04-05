import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Inventory {
	
	private HashMap<String, InventoryItem > inventoryMap;
	
	public Inventory(){	
		inventoryMap = new HashMap<String, InventoryItem>();
	}
	
	public int getInventory(String productBarcode){
		return inventoryMap.get(productBarcode).getQuantity();
	}
	
	// remove a String from inventory:
	public  void removeFromInventory(String barcode){
		
		if (inventoryMap.containsKey(barcode)){	
			InventoryItem inItem = inventoryMap.get(barcode);
			int quantity = inItem.getQuantity();
			
			if(quantity <= 1){
				// remove the String from inventory:
				inventoryMap.remove(barcode);
			}
			else 
			{
				inItem.reduceByOne();
			}	
		}
	}
	
	// insert Strings to the inventory:
	public  void insertToInventory(InventoryItem item){	
		String barcode = item.getProduct().getBarcode();
		
		// add to current inventory
		if (inventoryMap.containsKey(barcode)){	
			InventoryItem inItem = inventoryMap.get(barcode);		
			inItem.increaseByAmount(item.getQuantity());	
			
		}else
		{	
			// new item to add:
			inventoryMap.put(barcode, item);
		}
	}
	
	// return the available Strings:
	public String getAvailableProducts(){
		// return all the Strings name 
		StringBuilder builder = new StringBuilder();
		
		for (Map.Entry<String, InventoryItem> entry : inventoryMap.entrySet()) {
		    String barcode = entry.getKey();
		    InventoryItem item = entry.getValue();
		    
		    builder.append(item.getProduct().toString() + "\n");
		}
		return builder.toString();
	}
	
	// return the current inventory: 
	public String getInventory(){
		// return all the Strings name 
		StringBuilder builder = new StringBuilder();
		
		for (Map.Entry<String, InventoryItem> entry : inventoryMap.entrySet()) {
		    String barcode = entry.getKey();
		    InventoryItem item = entry.getValue();
		    
		    builder.append(item.getProduct().toString() + ": " + item.getQuantity() + "\n");
		}
		return builder.toString();
	}
	public InventoryItem getInventoryItem(String barcode){
		return inventoryMap.get(barcode);
	}
	public boolean isAvailable(String productBarcode){
		return inventoryMap.containsKey(productBarcode); 
	}
}
