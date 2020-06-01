package com.weather;

public class ForeCastRequestDetail {
    String gridX;
    String gridY;
    String forecastOffice;

    public ForeCastRequestDetail(String gridX, String gridY, String forecastOffice) {
        this.gridX = gridX;
        this.gridY = gridY;
        this.forecastOffice = forecastOffice;
    }

    public String getGridX() {
        return gridX;
    }

    public void setGridX(String gridX) {
        this.gridX = gridX;
    }

    public String getGridY() {
        return gridY;
    }

    public void setGridY(String gridY) {
        this.gridY = gridY;
    }

    @Override
    public String toString() {
        return "ForeCastDetail [forecastOffice=" + forecastOffice + ", gridX=" + gridX + ", gridY=" + gridY + "]";
    }

}
