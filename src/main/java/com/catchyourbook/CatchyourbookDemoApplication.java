package com.catchyourbook;

import java.nio.charset.Charset;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

@SpringBootApplication
//@MapperScan(value={""})
public class CatchyourbookDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatchyourbookDemoApplication.class, args);	
	}

	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		Resource[] rsm = new PathMatchingResourcePatternResolver().getResource("");
//		sessionFactory.setMapperLocations(rsm);
//		
//		return sessionFactory.getObject();
//	}
}
