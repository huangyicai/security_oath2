package cn.hoarfrost.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * 〈资源认证服务器〉
 * @time: 2019/7/23 15:00
 * @author: huangyicai
 * @descripe:
 * @version: 1.0
 */
@Configuration
@EnableResourceServer
@Order(3)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler hoarfrostAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler hoarfrostAuthenticationFailureHandler;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //UsernamePasswordAuthenticationFilter
        http.formLogin()
                .loginPage("/req")
                .loginProcessingUrl("/from")
                .successHandler(hoarfrostAuthenticationSuccessHandler)
                .failureHandler(hoarfrostAuthenticationFailureHandler);
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                //.requestMatchers().antMatchers("/api/**")
                //.and()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .httpBasic();
    }
}
