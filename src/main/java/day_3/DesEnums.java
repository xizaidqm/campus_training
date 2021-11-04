package day_3;

/**
 * @author: qiming
 * @date: 2021/11/4 15:05
 * @description:
 */
public enum DesEnums {
    BASECOFFEE("基础咖啡", 10),
    PLAINSYRUP("原味糖浆", 1),
    VANILLASYRUP("香草糖浆", 2),
    HAZELNUMSYRUP("榛果糖浆", 3),
    BIGGERBOTTLE("大杯", 4),
    BIGGESSTBOTTLE("超大杯", 5);

    String name;
    double price;

    DesEnums(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
