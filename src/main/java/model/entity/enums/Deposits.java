package model.entity.enums;

import java.util.Random;

public enum  Deposits {

    STANDART("standart"),
    PRIVATE("private"),
    JUNIOR("junior");

    private String type;
    private int percent;

    Deposits(String type) {
        switch (type) {
            case "standart":
                Random rnd = new Random(System.currentTimeMillis());
                percent = (rnd.nextInt(6)+9);
                break;
            case "private":
                percent = 7;
                break;
            case "junior":
                percent = 16;
                break;
        }

        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPercent() {
        return percent;
    }
}
