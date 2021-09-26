package com.hotel.app.dao;

import com.hotel.app.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class RoomDAO {
    private static final Logger log = Logger.getLogger(RoomDAO.class.getName());
    private final static String user = "postgres";
    private final static String password = "266";
    private final static String url = "jdbc:postgresql://localhost:5432/hotel";
    private final DBManager dbManager = DBManager.getInstance();


    public List<Room> getRooms() {
        List<Room> list = Collections.emptyList();
        Statement statement;
        ResultSet resultSet;
        Connection connection = dbManager.getConnection();
        ;
        String sql;
        try {
            sql = "select * from room where hotelId='1' ";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            list = new ArrayList<>();
            while (resultSet.next()) {
                Room room = new Room.Builder()
                        .withId(resultSet.getLong("id"))
                        .withRoomClass(resultSet.getString("roomClass"))
                        .withCapacity(resultSet.getInt("capacity"))
                        .withPrice(resultSet.getDouble("price"))
                        .withStatus(resultSet.getString("status"))
                        .withHotelId(resultSet.getLong("hotelId")).build();

                list.add(room);
            }
        } catch (SQLException e) {
            log.severe(e.getMessage());
        } finally {
            dbManager.commit(connection);
        }
        return list;

    }

}
