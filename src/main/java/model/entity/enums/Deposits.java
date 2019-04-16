package model.entity.enums;

public enum  Deposits {

    STANDART("standart"),
    PRIVATE("private"),
    JUNIOR("junior");

    private String type;
    private int percent;

    Deposits(String type) {
        switch (type) {
            case "standart":
                percent = (int) (Math.random() * 100);
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
