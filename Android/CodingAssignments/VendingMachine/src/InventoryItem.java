
public class InventoryItem {
	private Product mProduct;
	private int mQuantity;
	
	public InventoryItem(Product product){
		mProduct = product;
		mQuantity = 0;
	}
	
	public InventoryItem(Product product, int quantity){
		mProduct = product;
		mQuantity = quantity;
	}
	public void reduceByOne(){
		mQuantity--;
	}
	public void increaseByAmount(int amount){
		mQuantity += amount;
	}
	public void increaseByOne(){
		mQuantity++;
	}
	public Product getProduct() {
		return mProduct;
	}
	public void setProduct(Product mProduct) {
		this.mProduct = mProduct;
	}
	public int getQuantity() {
		return mQuantity;
	}
	public void setQuantity(int mQuantity) {
		this.mQuantity = mQuantity;
	}
	
	
	

}
