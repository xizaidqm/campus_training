package day_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: qiming
 * @date: 2021/11/3 17:08
 * @description:
 */
public class Inventory {
    public List<Device> items = new ArrayList<>();

    public void addDevice(String serialNumber, double price, DeviceSpec spec){
        Device device = new Device(serialNumber,price,spec);
        items.add(device);
    }

    public Device getDevice(String serialNumber){
        for (Device device : items) {
            if (device.getSerialNumber().equals(serialNumber)) {
                return device;
            }
        }
        return null;
    }

    public List<Device> search(DeviceSpec spec){
        List<Device> ans = new ArrayList<>();
        for(Device device: items){
            if(device.getSpec().matches(spec)){
                ans.add(device);
            }
        }
        return ans;
    }
}
