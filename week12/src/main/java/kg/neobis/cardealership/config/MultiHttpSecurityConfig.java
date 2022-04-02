package kg.neobis.cardealership.config;

import kg.neobis.cardealership.jwt.JwtFilter;
import kg.neobis.cardealership.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private JwtFilter jwtFilter;

        @Autowired
        private MyUserDetailsService myUserDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic().disable()
                        .csrf().disable()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                        .authorizeRequests()
                        .antMatchers("/api/v1/auth", "/api/v1/registration", "/api/v1/role").permitAll()
                        .antMatchers("/api/v1/admin/**").hasAuthority("ROLE_ADMIN")
                        .antMatchers("/api/v1/user/**").hasAuthority("ROLE_USER")
                        .anyRequest().authenticated()
                    .and()
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private MyUserDetailsService myUserDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/", "/login", "/registration", "/api/v1/role").permitAll()
                        .antMatchers("/foradmin/**", "/foruser/**").hasAuthority("ROLE_ADMIN")
                        .antMatchers("/foruser/**").hasAuthority("ROLE_USER")
                        .anyRequest().authenticated()
                    .and()
                        .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                    .and()
                        .logout()
                        .permitAll()
                        .logoutSuccessUrl("/")
                    .and()
                        .rememberMe()
                        .key("secretkey")
            ;
        }
    }
}
