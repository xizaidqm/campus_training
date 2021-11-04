package day_3;

/**
 * @author: qiming
 * @date: 2021/11/4 16:00
 * @description:
 */
public class VanillaSyrup extends Decorator {
    Beverage beverage;
    DesEnums des;
    int num;

    public VanillaSyrup(Beverage beverage, int num) {
        this.beverage = beverage;
        des = DesEnums.VANILLASYRUP;
        this.num = num;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " add " + this.num + "份" + des.name;
    }

    @Override
    public double getUnitPrice() {
        return des.price;
    }

    @Override
    public double cost() {
        return beverage.cost()+ getUnitPrice() * this.num;
    }


}
