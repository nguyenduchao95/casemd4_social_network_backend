package com.case_social_network.configSercurity;

import com.case_social_network.service.IUserService;
import com.case_social_network.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    IUserService iUserService;
    @Autowired
    FilterAuthToken filterAuthToken;
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

 /*   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(iUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/
    // auth.userDetailsService(iUserService): Điều này yêu cầu hệ thống sử dụng iUserService
    // để lấy thông tin chi tiết về người dùng khi họ cố gắng đăng nhập.
    // Vì vậy, khi người dùng nhập thông tin chi tiết của họ để đăng nhập,
    // hệ thống sẽ kiểm tra xem iUserServicenhững chi tiết đó có chính xác hay không.
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/login", "/registers" , "/login/fail" , "/forgot-password/**").permitAll()
                .and().authorizeRequests().antMatchers("/users**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and().logout().permitAll()
                .and().csrf().disable();

        http.addFilterBefore(filterAuthToken, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }


    // phan nay ma hoa mat khau
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }

    @Bean
    protected DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


}
