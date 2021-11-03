package day_2;

import day_2.enums.BrandEnum;
import day_2.enums.CPUEnum;
import day_2.enums.TypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiming
 * @date: 2021/11/3 17:10
 * @description:
 */
public class DeviceSpec {
    private Map<String, Object> attributes = new HashMap<>();

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Object getAttributes(String attr) {

        return attributes.get(attr);

    }

    public boolean matches(DeviceSpec deviceSpec) {
        for (String attr : deviceSpec.getAttributes().keySet()) {
            if (!deviceSpec.getAttributes(attr).equals(this.getAttributes(attr))) {
                return false;
            }
        }
        return true;
    }

    public DeviceSpec setBrandAttr(BrandEnum brandEnum) {
        attributes.put("Brand", brandEnum);
        return this;
    }

    public DeviceSpec setCPUdAttr(CPUEnum cpuEnum) {
        attributes.put("CPU", cpuEnum);
        return this;
    }

    public DeviceSpec setTypeAttr(TypeEnum typeAttr) {
        attributes.put("Type", typeAttr);
        return this;
    }

    @Override
    public String toString() {
        return "DeviceSpec{" +
                "attributes=" + attributes +
                '}';
    }
}
