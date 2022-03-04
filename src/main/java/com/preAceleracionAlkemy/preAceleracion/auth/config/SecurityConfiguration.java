package com.preAceleracionAlkemy.preAceleracion.auth.config;

import com.preAceleracionAlkemy.preAceleracion.auth.filter.JwtRequestFilter;
import com.preAceleracionAlkemy.preAceleracion.auth.service.UserDetailsCustomService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfiguration(@Lazy JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsCustomService).passwordEncoder(passwordEncoder());

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().
                authorizeHttpRequests()
                .antMatchers("/auth/*",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/webjars/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//Autentificacion Nueva para cada logueo

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);//Existe un filtro para tomar los datos y comprobar que sean los correspondientes

        //Le estamos diciendo que primero tome nuestro filto y luego el de springSecurity por defecto.
        //Primero se ejecutan todos los filtros y luego la accion previa a estos de confirmarse.
    }

}
