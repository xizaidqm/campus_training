package day_2.enums;

/**
 * @author: qiming
 * @date: 2021/11/3 18:48
 * @description:
 */
public enum CPUEnum {
    COREI7("酷睿i7"),
    COREI5("酷睿i5"),
    AMD("AMD");

    String CPUName;

    CPUEnum(String CPUName) {
        this.CPUName = CPUName;
    }
}
