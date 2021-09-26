package com.hotel.app.dao;

import java.util.HashMap;
import java.util.Map;

import com.hotel.app.config.SecurityConfig;
import com.hotel.app.bean.UserAccount;

public class DataDAO {

    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

    static {
        initUsers();
    }

    private static void initUsers() {

        // This user has a role as EMPLOYEE.
        UserAccount emp = new UserAccount("user", "123", //
                SecurityConfig.ROLE_EMPLOYEE);

        // This user has 2 roles EMPLOYEE and MANAGER.
        UserAccount mng = new UserAccount("admin", "789", //
                SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
    }

    // Find a User by userName and password.
    public static UserAccount findUser(String userName, String password) {
        UserAccount u = mapUsers.get(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

}
