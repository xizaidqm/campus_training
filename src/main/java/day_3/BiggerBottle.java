package day_3;

/**
 * @author: qiming
 * @date: 2021/11/4 16:02
 * @description:
 */
public class BiggerBottle extends Decorator {
    Beverage beverage;
    DesEnums des;

    public BiggerBottle(Beverage beverage) {
        this.beverage = beverage;
        des = DesEnums.BIGGERBOTTLE;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " add " + des.name;
    }

    @Override
    public double getUnitPrice() {
        return des.price;
    }

    @Override
    public double cost() {
        return beverage.cost() + getUnitPrice();
    }


}
