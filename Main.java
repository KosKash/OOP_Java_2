import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human ivan = new Human("Ivan");


        market.acceptToMarket(ivan);
        market.update();




    }
}


