package edu.ifsp.ltp.exemplo_springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().requiresChannel(
                channel -> channel.anyRequest().requiresSecure())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorize -> authorize.requestMatchers(HttpMethod.POST, "/criar").permitAll()
                                .requestMatchers(HttpMethod.GET, "/livre").permitAll())
                .authorizeHttpRequests(
                        authorize -> authorize.requestMatchers(HttpMethod.GET, "/conteudo").authenticated());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("usuario")
                .password("senha")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
