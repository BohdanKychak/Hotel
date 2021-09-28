package com.hotel.app.servlet;

import com.hotel.app.dao.RoomDAO;
import com.hotel.app.model.Room;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;;
import java.util.List;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // toDo add position and limit
        String pageNumber = request.getParameter("pageNumber");
        RoomDAO roomDAO = new RoomDAO();
        List<Room> list = roomDAO.getRooms();

        request.setAttribute("list", list);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/room.jsp");
        dispatcher.forward(request, response);
    }

}
