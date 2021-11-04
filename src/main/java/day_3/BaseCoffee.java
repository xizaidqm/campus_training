package day_3;

/**
 * @author: qiming
 * @date: 2021/11/4 16:28
 * @description:
 */
public class BaseCoffee implements Beverage {

    DesEnums des;

    public BaseCoffee() {
        des = DesEnums.BASECOFFEE;
    }

    @Override
    public double cost() {
        return des.price;
    }

    @Override
    public String getDescription() {
        return des.name;
    }


}
