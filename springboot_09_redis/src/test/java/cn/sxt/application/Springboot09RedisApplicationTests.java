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
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.Criteria;

import cn.sxt.application.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09RedisApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	//RedisKeyValueTemplate对象，spring已经进行了实例化
	@Autowired
	private RedisKeyValueTemplate keyValue;
	/***
	 * 保存用户信息
	 * 保存的对象对应的实体类中必须有id属性
	 */
	@Test
	public void addUser() {
		User user=new User();
		user.setId(12777);
		user.setUname("王五");
		user.setAddress("bj");
		keyValue.insert(user);
		//keyValue.insert(user.getId(), user);
	}
	
	/***
	 * 查询用户信息
	 */
	@Test
	public void loadUser() {
		//查询指定类型的数据
		Iterable<User> it = keyValue.findAll(User.class); 
		
		//创建Sort对象
		Sort sort=new Sort(Direction.DESC,"address");
		/*Iterable<User> it = keyValue.findAll(sort, User.class);*/
		
		//进行分页查询
		/*Iterable<User> it = keyValue.findInRange(0, 2, User.class);*/
		
		
		/*KeyValueQuery<Criteria> query=new KeyValueQuery<Criteria>();
		query.setSort(sort);
		Criteria criteria=query.getCriteria();
		criteria.where("id").equals(12779);
		
		Iterable<User> it = keyValue.find(query, User.class);*/
		
		
		/*List<User> it = keyValue.find(new RedisCallback() {

			@Override
			public Object doInRedis(RedisConnection 
					connection) throws DataAccessException {
				//原始jedis提供的对象
				String skey="cn.sxt.application.pojo.User";
				Set<byte[]> sMembers = connection.sMembers(skey.getBytes());
				for(byte[] bs:sMembers) {
					System.out.println(new String(bs)); //12777  12778  12779
				}
				
				return sMembers;
			}
			
		}, User.class);*/
		
		
		//遍历
		Iterator<User> iterator = it.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user.getId()+"----"+user.getUname());
		}
	}
	
	/***
	 * 更新用户信息
	 */
	@Test
	public void updateUser() {
		User user=new User();
		user.setId(12777);
		user.setUname("旺财");
		user.setAddress("上海");
		keyValue.update(user);
		
	}
	
	/***
	 * 删除用户信息
	 */
	@Test
	public void deleteUser() {
		keyValue.delete(12779, User.class);
	}
	
}
