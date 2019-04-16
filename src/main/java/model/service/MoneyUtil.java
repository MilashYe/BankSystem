package model.service;

public class MoneyUtil {
    public double convertUp(long money) {
        return money / 100;
    }

    public long convertDown(double money) {
        return (long) (money * 100);
    }
}
