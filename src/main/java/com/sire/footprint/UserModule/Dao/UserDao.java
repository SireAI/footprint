package com.sire.footprint.UserModule.Dao;

import com.sire.footprint.UserModule.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * ==================================================
 * All Right Reserved
 * Date:2017/8/7
 * Author:Sire
 * Description:
 * ==================================================
 */
@Repository()
public interface UserDao {
    List<User> findAllUsers();
}
