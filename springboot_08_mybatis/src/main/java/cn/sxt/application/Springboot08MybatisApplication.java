package cn.sxt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//加载自己扩展的xml文件
@ImportResource(locations= {"classpath:application-tx.xml"})
public class Springboot08MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot08MybatisApplication.class, args);
	}

}
