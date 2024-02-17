public class Human extends Actor {

    public Human(String name){
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }
}
