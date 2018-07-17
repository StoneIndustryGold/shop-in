package shopIn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity// 获得了springSecurityFilterChain组件
@EnableGlobalMethodSecurity(prePostEnabled = true)// 开启方法级别权限检查支持（@PreAuthorize）
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	@Bean
//    public UserDetailsService userDetailsService() {
//        // 提供用户详情，用于检查登录的用户名和密码
//        InMemoryUserDetailsManager um = new InMemoryUserDetailsManager();
//        um.createUser(User
//                .withUsername("zs")//加密文123456
//                .password("$2a$10$pyhoz7k3QLux1jrJmuE.ZOenAbfrGpa8cSMYa4xs9reYaDsUyXsfG")
//                .authorities("图书管理员").build());
//        um.createUser(User
//                .withUsername("ls")
//                .password("$2a$10$pyhoz7k3QLux1jrJmuE.ZOenAbfrGpa8cSMYa4xs9reYaDsUyXsfG")
//                .authorities("管理参观者").build());
//        return um;
//    }

}
