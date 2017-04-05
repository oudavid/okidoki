// Nickel (since 1866) - 5.000 g
// Dime (since 1965) - 2.268 g
// Quarter (since 1965) - 5.670 g


public class Currency {
    
    private final double NICKEL_WEIGHT = 5.000;
    private final double DIME_WEIGHT = 2.268;
    private final double QUARTER_WEIGHT = 5.670;
    
    public final double QUARTER_VALUE = 0.25;
    public final double NICKEL_VALUE = 0.05;
    public final double DIME_VALUE = 0.10;
    
    private int mNickels;
    private int mDimes;
    private int mQuarters;
    private double mTotal;
    
    public Currency() {
        this.mNickels = 0;
        this.mDimes = 0;
        this.mQuarters = 0;
        this.mTotal = 0;
    }
    
    public Currency(int nickels, int dimes, int quarters){
        this.mNickels = nickels;
        this.mDimes = dimes;
        this.mQuarters = quarters;
        reCalculateTotal();
    }
    
    
    // Determine which currency was added to the vending machine based on the weight
    public boolean addByWieght(double wieght){
        if (wieght == NICKEL_WEIGHT){
            mNickels += 1;
            reCalculateTotal();
            return true;
        }
        if (wieght == DIME_WEIGHT){
            mDimes += 1;
            reCalculateTotal();
            return true;
        }
        if (wieght == QUARTER_WEIGHT){
            mQuarters += 1;
            reCalculateTotal();
            return true;
        }
        else
            return false;
    }
    
    public void addByCurrency(Currency currency)
    {
        this.mNickels += currency.getNickels();
        this.mDimes += currency.getDimes();
        this.mQuarters += currency.getQuarters();
        reCalculateTotal();
    }
    
    
    public void removeByCurrency(Currency currency)
    {
        this.mNickels -= currency.getNickels();
        this.mDimes -= currency.getDimes();
        this.mQuarters -= currency.getQuarters();
        reCalculateTotal();
    }
    
    public boolean addByCoins(double coinAmount, int quantity){
        if (coinAmount == NICKEL_VALUE){
            mNickels += quantity;
            reCalculateTotal();
            return true;
        }
        if (coinAmount == DIME_VALUE){
            mDimes += quantity;
            reCalculateTotal();
            return true;
        }
        if (coinAmount == QUARTER_VALUE){
            mQuarters += quantity;
            reCalculateTotal();
            return true;
        }
        else
            return false;
    }
    
    public void reCalculateTotal()
    {
        mTotal = (mNickels * NICKEL_VALUE) + (mDimes * DIME_VALUE) + (mQuarters * QUARTER_VALUE);
    }
    
    public void clear(){
        this.mNickels = 0;
        this.mDimes = 0;
        this.mQuarters = 0;
        this.mTotal = 0;
    }
    
    // Getters & Setter methods for all fields
    public int getNickels() {
        return mNickels;
    }
    
    public void setNickels(int mNickels) {
        this.mNickels = mNickels;
    }
    
    
    public int getDimes() {
        return mDimes;
    }
    
    
    public void setDimes(int mDimes) {
        this.mDimes = mDimes;
    }
    
    
    public int getQuarters() {
        return mQuarters;
    }
    
    
    public void setQuarters(int mQuarters) {
        this.mQuarters = mQuarters;
    }
    
    
    public double getTotal() {
        return mTotal;
    }
    
    public String getTotalAmount(){
        return String.format("$" + mTotal);
    }
    
    public String getCurrencyBreakdown(){
        return "\n   Nickels: " + mNickels + "\n" + "   Dimes: " + mDimes + 
        		"\n" + "   Quarters: " + mQuarters;
    }
    
    
    public void setTotal(int mTotal) {
        this.mTotal = mTotal;
    }
    
    @Override
    public String toString() {
        return String.format("$" + mTotal);
    }
    
}
