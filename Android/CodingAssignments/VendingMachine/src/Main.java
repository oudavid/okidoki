// Nickel (since 1866) - 5.000 g
// Dime (since 1965) - 2.268 g
// Quarter (since 1965) - 5.670 g


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Products
		Product dietCoke = new Product("Diet coke", 1.00, "123");
		Product tampon = new Product("Tampon", .50, "234");
		Product bubbleGum = new Product("Bubble Gum", 15, "345");
		
		//InventoryItems
		
		InventoryItem iDietCoke = new InventoryItem(dietCoke, 25);
		InventoryItem iTampon = new InventoryItem(tampon, 50);
		InventoryItem iBubbleGum = new InventoryItem(bubbleGum, 150);
	
		// Inventory 
		Inventory inventory = new Inventory();
		inventory.insertToInventory(iDietCoke);
		inventory.insertToInventory(iTampon);
		inventory.insertToInventory(iBubbleGum);
		
		// Currency
		Currency setOfCoins = new Currency();
		setOfCoins.addByCoins(.5,10);
		setOfCoins.addByCoins(.10,10);
		setOfCoins.addByCoins(.25,10);
		
		// Vending machine
		VendingMachine machine = new VendingMachine(setOfCoins);
		machine.replaceInventory(inventory);
		
		machine.checkDisplay();
		
		machine.insertCoinToMachine(1);
		machine.insertCoinToMachine(5);
		machine.insertCoinToMachine(5.67);
		machine.insertCoinToMachine(2.268);
		machine.insertCoinToMachine(5);
		
		machine.makeSelection("123");
		machine.makeSelection("234");
		
		machine.insertCoinToMachine(5);
		machine.insertCoinToMachine(2.268);
		machine.makeSelection("234");
		

		
		
	}

}
