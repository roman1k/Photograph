package progectx.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userlogServiceImpl")
    private UserDetailsService userDetailsService;



//(sec + cntrl+j part2)

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//авторизовує всі реквести(запити)
                .antMatchers("/","main", "/home", "/saveCustomer", "/savePhotographer",  "/login/**", "/css/**" , "/images/**").permitAll()//на ці запити переходить будь хто
                .anyRequest().authenticated()//на всі інші тільки аутентифіковані
                .antMatchers("/admin/**").hasRole("ADMIN")//тільки адмін на такі
                .and()
                .formLogin()
                .loginPage("/login")//сторінка логінації
                .successForwardUrl("/successURL")//коли залогінюсь буде така урла handle with post mapping in controller
                .failureUrl("/login?error").permitAll()//якщо ні то помилка postmapping
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).//урла після того як я розлогінився
                logoutSuccessUrl("/login")
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }



}

