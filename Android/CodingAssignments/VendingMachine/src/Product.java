import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product {
	public String mName;
	public double mPrice;
	public String mBarcode;
	NumberFormat formatter = new DecimalFormat("#0.00");  
	
	// Constructors:
	public Product()
	{
		mName = "";
		mPrice = 0;
		mBarcode = "";
	}
	
	public Product(String name, double price, String id){
		mName = name;
		mPrice = price;
		mBarcode = id;
	}
	
	// Getters and Setters of all fields :
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		mName = mName;
	}
	public double getPrice() {
		return mPrice;
	}
	public void setPrice(double mPrice) {
		mPrice = mPrice;
	}
	public String getBarcode() {
		return mBarcode;
	}
	public void setBarcode(String id) {
		mBarcode = id;
	}
	@Override
	public String toString() {
		return "  - " + mName + ": $" + formatter.format(mPrice);
	} 
}
