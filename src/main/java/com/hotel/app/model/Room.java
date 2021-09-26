package com.hotel.app.model;

public class Room {
    private long id;
    private String roomClass;
    private int capacity;
    private double price;
    private String status;
    private long hotelId;

    public long getId() {
        return id;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public long getHotelId() {
        return hotelId;
    }

    public static class Builder{
        private final Room newRoom;

        public Builder() {
            newRoom = new Room();
        }

        public Builder withId(long id){
            newRoom.id = id;
            return this;
        }
        public Builder withRoomClass(String roomClass){
            newRoom.roomClass = roomClass;
            return this;
        }
        public Builder withCapacity(int capacity){
            newRoom.capacity = capacity;
            return this;
        }
        public Builder withPrice(double price){
            newRoom.price = price;
            return this;
        }
        public Builder withStatus(String status){
            newRoom.status = status;
            return this;
        }
        public Builder withHotelId(long hotelId){
            newRoom.hotelId = hotelId;
            return this;
        }

        public Room build(){
            return newRoom;
        }

    }
}
