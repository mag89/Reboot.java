package model;

public enum OrderByType {
    NONE(0), ASC(1), DESC(2);

    private final int orderNum;

    OrderByType(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
