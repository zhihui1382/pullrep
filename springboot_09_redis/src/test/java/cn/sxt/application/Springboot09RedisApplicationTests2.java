package cn.sxt.application;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.keyvalue.core.query.KeyValueQuery;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.Criteria;

import cn.sxt.application.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09RedisApplicationTests2 {

	@Test
	public void contextLoads() {
	}
	
	/*@Autowired
	private RedisTemplate redisTemplate;*/
	
	/***
	 * 添加用户信息
	 * 将用户信息序列化为字节数组，默认序列化方式
	 */
	/*@Test
	public void addUser() {
		User user=new User();
		user.setId(12741);
		user.setUname("小强");
		user.setAddress("bj");
		System.out.println(User.class.getName());
		BoundHashOperations hash=redisTemplate.boundHashOps("mps");
		hash.put(User.class.getName()+":"+user.getId(), user);
		//hash.get(member);
	}*/
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	/***
	 * 添加用户信息
	 * 将用户信息，序列化为字符串
	 */
	@Test
	public void addUser2() {
		User user=new User();
		user.setId(12748);
		user.setUname("甲乙丙");
		user.setAddress("北京");
		redisTemplate.boundHashOps("mps").put(User.class.getName()+":"+user.getId(), user);
		//redisTemplate.boundValueOps("user2").set(user);
	}
	
	
}
