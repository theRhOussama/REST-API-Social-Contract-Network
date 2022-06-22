package backEnd.demo.security;

import backEnd.demo.security.filter.JWTAuthenticationFilter;
import backEnd.demo.security.filter.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import backEnd.demo.entity.UserApp;
import backEnd.demo.service.AccountService;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Autowired
 private AccountService accountService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserApp userApp = accountService.loadUserByUserName(username);
                Collection<GrantedAuthority> authorities= new ArrayList<>();
                userApp.getRoles().forEach(
                        r->{
                            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                        }
                );
                return new User(userApp.getUsername(),userApp.getPassword(),authorities);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.csrf().disable(); //On veut utiliser un JWT
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Authentification stateless
       http.headers().frameOptions();


        http.authorizeRequests().antMatchers(HttpMethod.POST,"/addUser/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasAuthority("USER");

        http.authorizeRequests().antMatchers(HttpMethod.POST,"/register/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/accepter/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/notificationemp/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/listerinv/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/inviter/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/inviter/**").hasAuthority("USER");

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/getEmployee/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/login").permitAll();
        //  http.formLogin(); //formulaire d'authentification si un utilisateur n'a pas le droit (on a plus besoin dans notre backend on va gerer ca coté front)
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManagerBean()));
        //We added authenticationManagerBean
        http.cors();
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
