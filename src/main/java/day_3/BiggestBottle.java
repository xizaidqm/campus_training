package day_3;

/**
 * @author: qiming
 * @date: 2021/11/4 16:02
 * @description:
 */
public class BiggestBottle extends Decorator {
    Beverage beverage;
    DesEnums des;

    public BiggestBottle(Beverage beverage) {
        this.beverage = beverage;
        des = DesEnums.BIGGESSTBOTTLE;
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
        return beverage.cost() + des.price;
    }


}
