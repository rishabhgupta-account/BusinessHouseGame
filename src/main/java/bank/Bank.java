package bank;

public class Bank {


    private long currentPrice;

    public Bank() {
        this.currentPrice = 5000;
    }

    public long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }
}
