import java.text.DecimalFormat;
import java.text.NumberFormat;


public class VendingMachine {
    public final int MAX_DEFAULT_INVENTORY = 50;
    public final double QUARTER_VALUE = 0.25;
    public final double NICKEL_VALUE = 0.05;
    public final double DIME_VALUE = 0.10;
    
    private Currency TotalMachineBalance;
    private Currency CurrentBalance;
    private Inventory VMInventory;
    public int MaxInventoryAmount;
    //public boolean checkDisplay = false;
    NumberFormat formatter = new DecimalFormat("#0.00");
    
    // Constructors:
    public VendingMachine(){
        TotalMachineBalance = new Currency();
        CurrentBalance = new Currency();
        VMInventory = new Inventory();
        MaxInventoryAmount = MAX_DEFAULT_INVENTORY;
    }
    
    public VendingMachine(Currency totalBal){
        TotalMachineBalance = totalBal;
        CurrentBalance = new Currency();
        VMInventory = new Inventory();
        MaxInventoryAmount = MAX_DEFAULT_INVENTORY;
    }
    
    
    // -----------------------------------------------------------------------------------------
    // user:
    // 1. insert coins
    // 2. make a selection
    // 3. receive product
    // 4. dispense change if applies
    // ----------------------------------------------------------------------------------------
    
    public void checkDisplay()
    {
        displayAvailableProducts();
        displayInsertMessage();
        displayCurBal();
    }
    
    //1. insert coins, update new balance:
    public void insertCoinToMachine(double weight){
        
        if(CurrentBalance.addByWieght(weight)){
            
        }else{
            // display invalid:
            System.out.println("ERROR: invalid coin inserted");
            System.out.println("COIN RETURNED");
            return;
        }
        displayCurBal();
    }
    
    // 2. make a selection:
    public void makeSelection(String barcode){
        
        InventoryItem item = VMInventory.getInventoryItem(barcode);
        Product product = item.getProduct();
        double productPrice = product.getPrice();
        
        // check inventory for product
        if (!VMInventory.isAvailable(barcode)){
            System.out.println("SOLD OUT: Product is not available");
            return;
        }
        // is the balance enough
        if (CurrentBalance.getTotal() < productPrice){
            System.out.println("ERROR: Balance is short,"+" PRICE: $" + formatter.format(productPrice));
            displayInsertMessage();
            return;
        }
        else{
            // check if the balance is enough
            if (CurrentBalance.getTotal() < product.mPrice){
                // show error
                System.out.println("ERROR: Balance is short");
                displayInsertMessage();
            }
            else{
                // add to total balance
                TotalMachineBalance.addByCurrency(CurrentBalance);
                
                // calculate and dispense change
                Currency change = dispenseChange(productPrice, CurrentBalance.getTotal());
                
                if (change != null){
                    System.out.println("RETURN: " + change.getCurrencyBreakdown());
                    
                    // remove change from total
                    TotalMachineBalance.removeByCurrency(change);
                    
                    // remove from inventory
                    VMInventory.removeFromInventory(barcode);
                    
                    // display:
                    displayThankYouMessage();
                    CurrentBalance.clear();
                    //checkDisplay = false;
                }
                else {
                    System.out.println("ERROR: unable to dispense change");
                }
            }
        }
    }
    
    // 4. dispense change:
    public Currency dispenseChange(double itemAmount, double currBal){
        double total = currBal - itemAmount;
        
        int quarters = (int) (total/QUARTER_VALUE);
        total = total % QUARTER_VALUE;
        int dimes = (int) (total/DIME_VALUE);
        total = total % DIME_VALUE;
        int nickels = (int) (total/NICKEL_VALUE);
        total = total % NICKEL_VALUE;
        
        return new Currency(quarters, dimes, nickels);
    }
    
    public void returnCoins(){
        System.out.println("RETURN: " + CurrentBalance.getCurrencyBreakdown());
        CurrentBalance.clear();
    }
    
    
    // Display methods---------------------------------------------------------------------
    public void displayAvailableProducts(){
        System.out.println("\nThese are the available products to choose from:");
        System.out.println(VMInventory.getAvailableProducts());
    }
    
    public String displayCurBal(){
        double bal = CurrentBalance.getTotal();
        System.out.println("  BALANCE: $" + formatter.format(bal));
        return CurrentBalance.toString();
    }
    
    public void displayInsertMessage(){
        System.out.println("INSERT COIN.");
    }
    
    public void displayThankYouMessage(){
        System.out.println("THANK YOU.");
        System.out.println();
    }
    
    // Getters & Setters methods------------------------------------------------------------
    public void replaceTotalBalance(Currency newBal){
        TotalMachineBalance = newBal;
    }
    
    public void replaceInventory(Inventory inventory)
    {
        VMInventory = inventory;
    }
    
    public Currency getTotalMachineBalance() {
        return TotalMachineBalance;
    }
    
    
    public Currency getCurrentBalance() {
        return CurrentBalance;
    }
    
    
    public Inventory getVMInventory() {
        return VMInventory;
    }
    
}
