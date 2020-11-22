import java.util.ArrayList;
import java.util.HashMap;

public class Pub {
    double beerCapacity;
    double wineCapacity;
    double pálinkaCapacity;
    int incomes = 100000;
    int dailyIncome;
    int openingHours;
    ArrayList<Person> people;
    int maxPeopleCapacity = 50;
    Beer dreher= new Beer();
    Wine nyakas = new Wine();
    Pálinka bolyhos = new Pálinka();

    public Pub(int openingHours) {
        people = new ArrayList<>();
        int start = (int) ((Math.random() * 10) + 1);
        for (int i = 0; i < start; i++) {
            people.add(new Person());
        }
        this.openingHours = openingHours;
    }


    public double getBeerCapacity() {
        return beerCapacity;
    }

    public void setBeerCapacity(double beerCapacity) {
        this.beerCapacity = beerCapacity;
    }

    public double getWineCapacity() {
        return wineCapacity;
    }

    public void setWineCapacity(double wineCapacity) {
        this.wineCapacity = wineCapacity;
    }

    public double getPálinkaCapacity() {
        return pálinkaCapacity;
    }

    public void setPálinkaCapacity(double pálinkaCapacity) {
        this.pálinkaCapacity = pálinkaCapacity;
    }

    public int getIncomes() {
        return incomes;
    }

    public void setIncomes(int incomes) {
        this.incomes += incomes;
    }

    public int getOpeningHours() {
        return openingHours;
    }

    public int getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(int dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public void setDreher(Beer dreher) {
        this.dreher = dreher;
    }

    public void setNyakas(Wine nyakas) {
        this.nyakas = nyakas;
    }

    public void setBolyhos(Pálinka bolyhos) {
        this.bolyhos = bolyhos;
    }

    public void setMaxPeopleCapacity(int maxPeopleCapacity) {
        this.maxPeopleCapacity += maxPeopleCapacity;
    }

    public void order(Person person) {
        int favoriteDrink = person.getFavoriteDrink();
        HashMap<Integer, String> drinks = new HashMap<>();
        drinks.put(1, "Sör");
        drinks.put(2, "Bor");
        drinks.put(3, "Pálinka");
        if (favoriteDrink == 0) {
            Water water = new Water();
            dailyIncome += (water.getPrice());
            System.out.println("Víz rendelés, kocsma vagyona: " + dailyIncome);
        }
        if (isAvailable(favoriteDrink)) {
            if (favoriteDrink == 1) {
                beerCapacity -= dreher.getPortion();
                dailyIncome += (dreher.getPrice());
                person.drink(dreher.getAlcoholRate() * dreher.getPortion());
                person.isThirstyAgain();
                System.out.println("Sör rendelés, kocsma vagyona: " + dailyIncome);

            } else if (favoriteDrink == 2) {
                wineCapacity -= nyakas.getPortion();
                dailyIncome += (nyakas.getPrice());
                person.drink(nyakas.getAlcoholRate() * nyakas.getPortion());
                person.isThirstyAgain();
                System.out.println("Bor rendelés, kocsma vagyona: " + dailyIncome + " Ft");
            } else {
                pálinkaCapacity -= bolyhos.getPortion();
                dailyIncome += (bolyhos.getPrice());
                person.drink(bolyhos.getAlcoholRate() * bolyhos.getPortion());
                person.isThirstyAgain();
                System.out.println("Pálinka rendelés, kocsma vagyona: " + dailyIncome + " Ft");
            }
        } else {
            person.cantOrder();
            angryCheck(person);
            if (!person.isHasFavoriteDrink()) {
                System.out.println("A " + drinks.get(favoriteDrink) + " elfogyott. Választhatod helyette a következőket: ");
                for (int i = 1; i <= drinks.size(); i++) {
                    if (isAvailable(i)) {
                        System.out.println(drinks.get(i));
                        person.setFavoriteDrink(i);
                        order(person);
                    }
                }

            }

        }
        person.setSpendTime();
    }

    public boolean isAvailable(int nr) {
        if (nr == 1 && beerCapacity > 0) {
            return true;
        } else if (nr == 2 && wineCapacity > 0) {
            return true;
        } else if (nr == 3 && pálinkaCapacity > 0) {
            return true;
        }
        return false;
    }

    public void angryCheck(Person person) {
        if (person.isAngry()) {
            int damage = (int) ((Math.random() * 50000) + 1);
            incomes -= damage;
            System.out.println("Az egyik vendég ideges lett. Okozott kár: " + damage);
            person.setAngry(false);
            person.setFailOrder(0);
        }
    }

    public void leave(Person person, int nr) {
        if (person.getSpendTime() >= 0) {
            people.remove(nr);
            System.out.println("Egy ember elment a kocsmából");
        }

    }

    public void arrive() {
        if (people.size() < maxPeopleCapacity) {
            int newPeople = (int) (Math.random() * maxPeopleCapacity*0.3);
            if (newPeople + people.size() > maxPeopleCapacity) {
                newPeople = maxPeopleCapacity - people.size();
            }
            for (int i = 0; i < newPeople; i++) {
                people.add(new Person());
            }
            System.out.println(newPeople + " új ember érkezett.");
        }
    }

    public void beerOrder(int nr) {
        beerCapacity += nr * dreher.getPortion();
        incomes -= dreher.getPurchasePrice() * nr;
    }

    public void wineOrder(int nr) {
        wineCapacity += nr * nyakas.getPortion();
        incomes -= nyakas.getPurchasePrice() * nr;

    }

    public void pálinkaOrder(int nr) {
        pálinkaCapacity += nr*(bolyhos.getPortion() *10);
        incomes -= bolyhos.getPurchasePrice() * nr;
    }

}
