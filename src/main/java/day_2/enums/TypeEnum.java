package day_2.enums;

/**
 * @author: qiming
 * @date: 2021/11/3 18:47
 * @description:
 */
public enum TypeEnum {
    LAPTOP("笔记本电脑"),
    DESKTOP("台式机"),
    SERVER("服务器");

    String typeName;

    TypeEnum(String typeName) {
        this.typeName = typeName;
    }
}
