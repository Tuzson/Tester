public class Pálinka {
    private double portion = 0.5;
    private int price;
    private double alcoholRate = 0.5;
    private int purchasePrice = 300;

    public Pálinka() {
    }

    public double totalAlcoholRate (){
        return portion * alcoholRate;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getAlcoholRate() {
        return alcoholRate;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
