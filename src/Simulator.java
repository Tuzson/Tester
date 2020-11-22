import java.util.Scanner;

public class Simulator {

    public Simulator(Pub pub, int days) throws InterruptedException {
        int sumNoOrders = 0;
        int dailyNoOrder = 0;
        int i = 1;
        while (i <= days && pub.getIncomes() > 0) {
            Scanner sc = new Scanner(System.in);
            if (i % 10 == 0) {
                System.out.println("Az előző napi adatok:\n" + "napi zárás: " + pub.getDailyIncome() + "\n" + "Sör " + pub.getBeerCapacity() + "\n Bor: " + pub.getWineCapacity() + "\n Pálinka: " + pub.getPálinkaCapacity() + "\n Ki nem szolgált vendég összesen: " + dailyNoOrder);
                pub.setDailyIncome(0);
                dailyNoOrder = 0;
                System.out.println("Ha szeretnéd bővíteni a helyet, írd be, hogy hány fő férjen még be" +  "( vagyon: " + pub.getIncomes()+" )");
                pub.setMaxPeopleCapacity(sc.nextInt());
                sc = new Scanner(System.in);
                System.out.println("Add le a napi rendelésed!");
                System.out.println("Mennyi sört rendelsz ma? (100Ft/0.5L (1 üveg). Rendelkezésre álló összeg:" + pub.getIncomes());
                int beerOrder = sc.nextInt();
                pub.beerOrder(beerOrder);
                System.out.println("Mennyi legyen ma az eladási ára?");
                sc = new Scanner(System.in);
                pub.dreher.setPrice(sc.nextInt());
                sc = new Scanner(System.in);
                System.out.println("Mennyi bort rendelsz ma? (200Ft/2dl (800Ft/üveg --> 4db). Rendelkezésre álló összeg:" + pub.getIncomes());
                int wineOrder = sc.nextInt();
                pub.wineOrder(wineOrder);
                System.out.println("Mennyi legyen ma az eladási ára?");
                sc = new Scanner(System.in);
                pub.nyakas.setPrice(sc.nextInt());
                sc = new Scanner(System.in);
                System.out.println("Mennyi pálinkát rendelsz ma? (300Ft/5dl) (3000/üveg) --> 10db. Rendelkezésre álló összeg:" + pub.getIncomes());
                int pálinkaOrder = sc.nextInt();
                pub.pálinkaOrder(pálinkaOrder);
            }
            else {
                System.out.println("Az előző napi adatok:\n" + "napi zárás: " + pub.getDailyIncome() + "\n" + "Sör " + pub.getBeerCapacity() + "\n Bor: " + pub.getWineCapacity() + "\n Pálinka: " + pub.getPálinkaCapacity() + "\n Ki nem szolgált vendég összesen: " + sumNoOrders);
                pub.setDailyIncome(0);
                System.out.println("Add le a napi rendelésed!");
                System.out.println("Mennyi sört rendelsz ma? (100Ft/0.5L (1 üveg). Rendelkezésre álló összeg:" + pub.getIncomes());
                int beerOrder = sc.nextInt();
                pub.beerOrder(beerOrder);
                System.out.println("Mennyi legyen ma az eladási ára?");
                sc = new Scanner(System.in);
                pub.dreher.setPrice(sc.nextInt());
                sc = new Scanner(System.in);
                System.out.println("Mennyi bort rendelsz ma? (200Ft/2dl (800Ft/üveg --> 4db). Rendelkezésre álló összeg:" + pub.getIncomes());
                int wineOrder = sc.nextInt();
                pub.wineOrder(wineOrder);
                System.out.println("Mennyi legyen ma az eladási ára?");
                sc = new Scanner(System.in);
                pub.nyakas.setPrice(sc.nextInt());
                sc = new Scanner(System.in);
                System.out.println("Mennyi pálinkát rendelsz ma? (300Ft/5dl) (3000/üveg) --> 10db. Rendelkezésre álló összeg:" + pub.getIncomes());
                int pálinkaOrder = sc.nextInt();
                pub.pálinkaOrder(pálinkaOrder);
            }
            System.out.println("Mennyi legyen ma az eladási ára?");
            sc = new Scanner(System.in);
            pub.bolyhos.setPrice(sc.nextInt());
            for (int j = 0; j < pub.getOpeningHours() * 2; j++) {
                pub.arrive();
                for (int k = 0; k < pub.people.size(); k++) {
                    pub.order(pub.people.get(k));
                    dailyNoOrder += pub.people.get(k).getFailOrder();
                    pub.leave(pub.people.get(k), k);

                }
            }
            pub.people.clear();
            pub.setIncomes(pub.getDailyIncome());
            sumNoOrders+=dailyNoOrder;
            i++;
        }
        if (pub.getIncomes() > 0) {

            System.out.println("A kocsma teljes vagyona: " + pub.getIncomes());
        } else {
            System.out.println("A kocsma tönkre ment. VÉGE A JÁTÉKNAK");
        }
    }
}
