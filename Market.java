import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehavior, MarketBehavior {
    private List<Actor> actorList = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors){
            System.out.println(actor.getName() + " вышел из магазина");
            actorList.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        for(int i = 0; i < 1000000000; i++);

        giveOrders();

        for(int i = 0; i < 1000000000; i++);

        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        actorList.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : actorList) {
            if (!actor.isMakeOrder) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : actorList) {
            if (actor.isMakeOrder) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }
    @Override
    public void releaseFromQueue () {
         List<Actor> releasedActors = new ArrayList<>();
         for (Actor actor : actorList) {
             if (actor.isTakeOrder()) {
                 releasedActors.add(actor);
                 System.out.println(actor.getName() + " вышел из очереди");
             }
         }
         releaseFromMarket(releasedActors);
    }
}


