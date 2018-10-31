package progectx.demo.configs;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("ADMIN");
    }

//(sec + cntrl+j part2)

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//авторизовує всі реквести(запити)
                .antMatchers("/", "/home").permitAll()//на ці запити переходить будь хто
                .anyRequest().authenticated()//на всі інші тільки аутентифіковані
                .antMatchers("/admin/**").hasRole("ADMIN")//тільки адмін на такі
                .and()
                .formLogin()
                .loginPage("/login")//сторінка логінації
                .successForwardUrl("/successURL")//коли залогінюсь буде така урла handle with post mapping in controller
                .failureUrl("/login?error").permitAll()//якщо ні то помилка
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).//урла після того як я розлогінився
                logoutSuccessUrl("/login")
                .permitAll();
    }
}

