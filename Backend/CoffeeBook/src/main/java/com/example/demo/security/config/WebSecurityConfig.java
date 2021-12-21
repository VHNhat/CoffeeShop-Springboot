//package com.example.demo.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.example.demo.security.jwt.JwtAuthenticationFilter;
//import com.example.demo.security.service.CustomerDetailsServiceImpl;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    CustomerDetailsServiceImpl customerUserDetailsService;
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        // Get AuthenticationManager bean
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.userDetailsService(customerUserDetailsService) // Cung cáp userservice cho spring security
//            .passwordEncoder(passwordEncoder()); // cung cấp password encoder
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors(); // Ngăn chặn request từ một domain khác
//        http.csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/**").permitAll(); // Cho phép tất cả mọi người truy cập vào địa chỉ này
//                    //.anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập
//
//        // Thêm một lớp Filter kiểm tra jwt
//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//}
