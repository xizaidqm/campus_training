package day_2.enums;

/**
 * @author: qiming
 * @date: 2021/11/3 18:43
 * @description:
 */
public enum BrandEnum {
    HUAWEI("华为"),
    XIAOMI("小米");

    String brandName;

    BrandEnum(String brandName) {
        this.brandName = brandName;
    }
}
