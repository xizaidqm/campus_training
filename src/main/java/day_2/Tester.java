package day_2;

import day_2.enums.BrandEnum;
import day_2.enums.CPUEnum;
import day_2.enums.TypeEnum;

import java.util.List;

/**
 * @author: qiming
 * @date: 2021/11/3 19:01
 * @description:
 */
public class Tester {
    public static void main(String[] args){
       Inventory inventory = initInventory();

        //设置搜索条件
        DeviceSpec searchAttrs = new DeviceSpec()
                .setBrandAttr(BrandEnum.HUAWEI)
                .setTypeAttr(TypeEnum.DESKTOP);

        //搜索
        List<Device> results = inventory.search(searchAttrs);

        System.out.println(results);
    }

    private static Inventory initInventory(){
        Inventory inventory = new Inventory();

        DeviceSpec dev1 = new DeviceSpec()
                .setTypeAttr(TypeEnum.DESKTOP)
                .setBrandAttr(BrandEnum.HUAWEI)
                .setCPUdAttr(CPUEnum.AMD);

        inventory.addDevice("888", 2000, dev1);

        DeviceSpec dev2 = new DeviceSpec()
                .setTypeAttr(TypeEnum.SERVER)
                .setBrandAttr(BrandEnum.XIAOMI)
                .setCPUdAttr(CPUEnum.COREI7);

        inventory.addDevice("666", 10000, dev2);
        return inventory;
    }


}
