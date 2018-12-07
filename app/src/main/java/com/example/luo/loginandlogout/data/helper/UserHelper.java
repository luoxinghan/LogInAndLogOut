package com.example.luo.loginandlogout.data.helper;

import com.example.luo.loginandlogout.data.modules.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserHelper {

    /**
     * Create number Users
     * @param number
     * @return
     */
    public static List<User> createUserList(int number){
        List<User> list = new ArrayList<User>();
        for(int i = 0; i < number; i++) {
            list.add(new User("name" + i,"icon" + (i % 3 + 1),
                    i > 99 ? (byte)(new Random().nextInt(100)) : (byte)i, "user" + i + "@grsu.by" ));
        }
        return list;
    }
}
