package com.company.connect;

public class HistoryModel {
    private final String device_name;
    private final String mac_address;
    private final String date_time;
    private final String status;
    private final int imageView;

    public HistoryModel(String device_name, String mac_address, String date_time, String status, int imageView) {
        this.device_name = device_name;
        this.mac_address = mac_address;
        this.date_time = date_time;
        this.status = status;
        this.imageView = imageView;
    }

    public String getDevice_name() {
        return device_name;
    }

    public String getMac_address() {
        return mac_address;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getStatus() {
        return status;
    }

    public int getImageView() {
        return imageView;
    }
}
