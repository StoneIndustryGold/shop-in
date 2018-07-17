package shopIn.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration//����������
@ComponentScan(basePackages="shopIn")//ɨ�趥���
@EnableWebMvc //����web mvc������ʩ֧��
@MapperScan("shopIn.mapper")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement // ����spring����֧��
public class AppConfig extends WebMvcConfigurerAdapter{
	@Override//重写    
	//重写 configigureVieweRsolvers方法
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");//配置前jsp路劲的前缀和后缀
	}
	
	@Override//如静态页面css
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    // 当springmvc遇到没有控制器映射的路径时（如webapp下的静态资源），交给默认的servlet处理
	    configurer.enable(); 
	}
	
	@Bean
	public DataSource dataSource(Environment env) {
		DriverManagerDataSource dmd=new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password"));
		dmd.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return dmd;
	}
	@Bean
	public SqlSessionFactoryBean bean(DataSource dataSource) {
		SqlSessionFactoryBean sqlbean=new SqlSessionFactoryBean();
		sqlbean.setConfigLocation(new ClassPathResource("shopIn/mybatis-config.xml"));
		sqlbean.setDataSource(dataSource);
		return sqlbean;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return	 new BCryptPasswordEncoder();
		 
	}
	// spring事务需要事务管理器组件（开事务、提交或回滚事务）
		@Bean
		public PlatformTransactionManager transactionManager(DataSource dataSource) {
		    // 以下是能与mybatis协作的实现类，如用的是hibernate或JPA，那么实现类不一样
		    return new DataSourceTransactionManager(dataSource);
		}

}
