package com.example.domain;

/**
 * ホテルの一部屋を表すドメイン.
 */
public class Room {
    /** 部屋ID */
    private Integer id;
    /** ホテルID */
    private Integer hotelId;
    /** 部屋名 */
    private String name;
    /** 最大人数 */
    private Integer capacity;
    /** 価格 */
    private Integer price;
    /** 説明 */
    private String description;
    /** 画像パス */
    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}