public class Person {
    private int favoriteDrink;
    private boolean hasFavoriteDrink;
    private boolean isThirsty;
    private int spendTime;
    private boolean angry;
    private boolean isAngryType;
    private int failOrder;
    private double drunkRate;
    private double breakPoint;

    public Person() {
        int rand1 = (int) (Math.random() * 2);
        if (rand1 == 1) {
            hasFavoriteDrink = true;
        }
        favoriteDrink = (int) ((Math.random() * 3)) + 1;
        isThirsty = true;
        spendTime = (int) ((Math.random() * 20) + 1);

        int rand2 = (int) (Math.random() * 2);
        if (rand2 == 1) {
            isAngryType = true;
        }
        breakPoint = (Math.random());
    }
    public void isThirstyAgain() {
        int rand1 = (int) (Math.random() * 2);
        isThirsty = rand1 == 1;
    }

    public void drink(double alcoholLevel) {
        drunkRate += alcoholLevel;
    }

    public void cantOrder() {
        failOrder++;
        double angryLevel = failOrder* drunkRate;
        if (isAngryType && angryLevel>=breakPoint){
            angry =true;
        }
    }

    public int getFavoriteDrink() {
        return favoriteDrink;
    }

    public boolean isHasFavoriteDrink() {
        return hasFavoriteDrink;
    }

    public boolean isThirsty() {
        return isThirsty;
    }

    public int getSpendTime() {
        return spendTime;
    }

    public boolean isAngry() {
        return angry;
    }

    public boolean isAngryType() {
        return isAngryType;
    }

    public int getFailOrder() {
        return failOrder;
    }

    public double getDrunkRate() {
        return drunkRate;
    }

    public double getBreakPoint() {
        return breakPoint;
    }

    public void setSpendTime() {
        spendTime--;
    }

    public void setFavoriteDrink(int favoriteDrink) {
        this.favoriteDrink = favoriteDrink;
    }

    public void setHasFavoriteDrink(boolean hasFavoriteDrink) {
        this.hasFavoriteDrink = hasFavoriteDrink;
    }

    public void setThirsty(boolean thirsty) {
        isThirsty = thirsty;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    public void setAngryType(boolean angryType) {
        isAngryType = angryType;
    }

    public void setFailOrder(int failOrder) {
        this.failOrder = failOrder;
    }

    public void setDrunkRate(double drunkRate) {
        this.drunkRate = drunkRate;
    }

    public void setBreakPoint(double breakPoint) {
        this.breakPoint = breakPoint;
    }
}