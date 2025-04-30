package cua.integra.cajasuamc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UsuariosDetallesConfig {
    @Bean
    public InMemoryUserDetailsManager usuariosDetallesService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("pedro")
                .password(bCryptPasswordEncoder.encode("<pedro>"))
                .roles("USER")
                .build());
        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("<admin>"))
                .roles("ADMIN")
                .build());
        return manager;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
