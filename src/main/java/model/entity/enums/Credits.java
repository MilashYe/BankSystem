package model.entity.enums;

public enum Credits {
    CREDIT_CARD("credit_card"),
    HYPOTHEC("hypothec"),
    INSTALLMENT_PLAN("installment_plan");

    private String type;
    private int percent;

    Credits(String type) {
        if (type.equals("credit_card")) {
            percent = 4;
        }
        if (type.equals("hypothec")) {
            percent = 12 ;
        }
        if (type.equals("installment_plan")) {
            percent = 1;
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
