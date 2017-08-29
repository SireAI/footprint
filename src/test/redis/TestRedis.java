package redis;

import com.sire.footprint.App;
import com.sire.footprint.ModuleEnvironment.Utils.SerializeUtil;
import com.sire.footprint.UserModule.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * ==================================================
 * All Right Reserved
 * Date:2017/8/11
 * Author:Sire
 * Description:
 * ==================================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class TestRedis {
    @Autowired
    JedisPool jedisPool;
    @Test
    public void testRedis(){
        Jedis resource = jedisPool.getResource();
        User user = new User();
        user.setName("sire");
        user.setPassword("ffdsf");
        user.setId(4);
        resource.set("kk".getBytes(), SerializeUtil.serialize(user));
        User unserializ = SerializeUtil.unserialize(resource.get("kk".getBytes()));

        System.out.println("++++"+unserializ.toString());
    }
}
