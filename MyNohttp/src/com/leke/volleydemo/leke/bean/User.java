package com.leke.volleydemo.leke.bean;

import com.leke.volleydemo.leke.JSonUtil;

import java.util.List;

/**
 * Created by xuyuqiang on 16/5/31.
 */
public class User extends BaseResponseBean{

    public int id;
    public String loginName;
    public int sex;
    public String photo;
    public String nick;
    public List<CurrentRoleData> roleList;
    public SchoolData currentSchool;

    public class CurrentRoleData {
        public int id;
    }

    public class SchoolData {
        public long id = 0L;
        public String name;
    }


    public static User getUser(String json){
        User user = (User) JSonUtil.getResposeBean(json , User.class , "user");
        return user ;
    }
}
