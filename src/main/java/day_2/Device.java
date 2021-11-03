package day_2;

/**
 * @author: qiming
 * @date: 2021/11/3 17:09
 * @description:
 */
public class Device {
    public String serialNumber;
    public double price;
    public DeviceSpec spec;

    public Device(String serialNumber, double price, DeviceSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public DeviceSpec getSpec() {
        return spec;
    }

    public void setPrice(float price){
        this.price=price;
    }

    @Override
    public String toString() {
        return "Device{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", spec=" + spec +
                '}';
    }
}
