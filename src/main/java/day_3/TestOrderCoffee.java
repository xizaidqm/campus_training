package day_3;

import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * @author: qiming
 * @date: 2021/11/4 17:23
 * @description:
 */
public class TestOrderCoffee {
    public static void main(String[] args) {
        System.out.println("欢迎来到我的咖啡店！");
        System.out.println("请问需要来一杯咖啡吗？1表示需要，0表示不需要");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            System.out.println("很抱歉没有您满意的品种！我们会继续努力！欢迎下次光临！");
        } else if (choice == 1) {
            System.out.println("好的！请选择您需要的杯型！~0表示默认杯型，1表示大杯，2表示超大杯");
            int bottleSize = scanner.nextInt();
            //创建默认杯型
            Beverage beverage = new BaseCoffee();
            //设置杯型大小
            if (bottleSize == 1) {
                beverage = new BiggerBottle(beverage);
                System.out.println("好的，您选择了一杯大杯咖啡！");
            } else if (bottleSize == 2) {
                beverage = new BiggestBottle(beverage);
                System.out.println("好的，您选择了一杯超大杯咖啡！");
            } else {
                System.out.println("好的，您选择了一杯默认杯型的咖啡！");
            }
            System.out.println("请问您需要加料吗？加糖浆更好喝哦~");

            //加料结束标志位
            boolean flag = false;
            do {
                System.out.println("0表示不额外加任何辅料，1表示原味糖浆（一份1元），2表示香草糖浆（一份2元），3表示榛果糖浆（一份3元）");

                int syrup = scanner.nextInt();
                if (syrup == 1) {
                    System.out.println("好的~那您选择添加几份 原味糖浆 呢？");

                    int number = scanner.nextInt();
                    System.out.println("好的~您选择添加了" + number + "份原味糖浆");
                    beverage = addSpecificSyrups(beverage, number, PlainSyrup.class);

                    System.out.println("请问您还要添加其他辅料吗？还可以继续添加本品种哦~ 0表示不需要，1表示需要");

                    int isEnd = scanner.nextInt();
                    flag = ifEndSyrups(isEnd);
                } else if (syrup == 2) {
                    System.out.println("好的~那您选择添加几份 香草糖浆 呢？");

                    int number = scanner.nextInt();
                    System.out.println("好的~您选择添加了" + number + "份香草糖浆");
                    beverage = addSpecificSyrups(beverage, number, VanillaSyrup.class);

                    System.out.println("请问您还要添加其他辅料吗？还可以继续添加本品种哦~ 0表示不需要，1表示需要");
                    int isEnd = scanner.nextInt();
                    flag = ifEndSyrups(isEnd);
                } else if (syrup == 3) {
                    System.out.println("好的~那您选择添加几份 榛果糖浆 呢？");
                    int number = scanner.nextInt();
                    System.out.println("好的~您选择添加了" + number + "份榛果糖浆");

                    beverage = addSpecificSyrups(beverage, number, HazelnutSyrup.class);

                    System.out.println("请问您还要添加其他辅料吗？还可以继续添加本品种哦~ 0表示不需要，1表示需要");

                    int isEnd = scanner.nextInt();
                    flag = ifEndSyrups(isEnd);
                } else {
                    //退出加糖浆流程
                    flag = true;
                }
            } while (!flag);
            System.out.println("好的~现在为您制作...");

            System.out.println("您的咖啡已制作完成~您一共消费" + beverage.cost() + "元！");
            System.out.println("请问是否需要打印饮品原料？0表示不需要，1表示需要");

            int ifPrint = scanner.nextInt();
            if (ifPrint == 0) {
                System.out.println("您选择了不打印原料~欢迎下次光临！");
            } else {
                System.out.println("您点的饮品的原料为：" + beverage.getDescription());
                System.out.println("本次服务已结束~欢迎您下次光临！");
            }

        } else {
            System.out.println("恭喜您触发彩蛋，正在为您制作本店特色招牌饮品！~请稍后结账！");
            Beverage beverage = makeSpecificDrinks();
            System.out.println("制作完成！您一共需要付" + beverage.cost() + "元！欢迎下次光临~");
            System.out.println("该饮品的原料为：" + beverage.getDescription());
        }
    }

    /**
     * 制作本店特色招牌饮品
     *
     * @return
     */
    public static Beverage makeSpecificDrinks() {
        Beverage beverage = new BaseCoffee();
        //选择杯型
        beverage = new BiggestBottle(beverage);
        //添加辅料糖浆
        beverage = new PlainSyrup(beverage, 1);
        beverage = new VanillaSyrup(beverage, 2);
        beverage = new HazelnutSyrup(beverage, 3);

        return beverage;
    }


    /**
     * 为咖啡添加特定辅料
     *
     * @param beverage
     * @param num
     * @param clazz    具体的辅料类型
     * @return
     */
    public static Beverage addSpecificSyrups(Beverage beverage, int num, Class clazz) {
        try {
            Constructor constructor = clazz.getConstructor(Beverage.class, int.class);
            beverage = (Beverage) constructor.newInstance(beverage, num);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return beverage;
    }

    /**
     * 判断是否结束加辅料流程
     *
     * @param flag
     * @return
     */
    public static boolean ifEndSyrups(int flag) {
        if (flag == 0) {
            return true;
        } else {
            return false;
        }
    }
}
