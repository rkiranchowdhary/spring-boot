package hello;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.csrf().disable();;
    	
    	http
         .authorizeRequests()
         .antMatchers("/index**").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
             .usernameParameter("j_username")
             .passwordParameter("j_password")
             .loginPage("/login")
             .defaultSuccessUrl("/", true)
             .permitAll()
         .and()
             .logout()
             .logoutUrl("/logout")
             .invalidateHttpSession(true)
             .logoutSuccessUrl("/")
             .deleteCookies("JSESSIONID")
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         ;
    }
  
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
       // auth.userDetailsService(userDetailsService());
    }
}