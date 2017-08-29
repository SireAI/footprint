package db;

import com.sire.footprint.App;
import com.sire.footprint.UserModule.Dao.UserDao;
import com.sire.footprint.UserModule.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * ==================================================
 * All Right Reserved
 * Date:2017/8/7
 * Author:Sire
 * Description:
 * ==================================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class TestDB {
    @Autowired
    private UserDao userDao;
    @Before
    public void before() {
    }

    @Test
    public void testDB(){
        List<User> allUsers = userDao.findAllUsers();
        allUsers.stream().forEach(user -> System.out.println(user.toString()));
    }
}
