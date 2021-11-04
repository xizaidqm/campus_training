package day_3;

/**
 * @author: qiming
 * @date: 2021/11/4 16:36
 * @description:
 */
public class PlainSyrup extends Decorator {
    Beverage beverage;
    DesEnums des;
    int number;

    public PlainSyrup(Beverage beverage, int number) {
        this.beverage = beverage;
        des = DesEnums.PLAINSYRUP;
        this.number = number;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " add " + this.number + "份" + des.name;
    }

    @Override
    public double getUnitPrice() {
        return des.price;
    }

    @Override
    public double cost() {
        return beverage.cost() + getUnitPrice() * this.number;
    }
}
