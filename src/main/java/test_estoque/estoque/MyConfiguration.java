package test_estoque.estoque;

//@Configuration
//public class MyConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")  // Aplica CORS a todas as rotas
//                .allowedOrigins("https://project-estoque-test-production.up.railway.app/5052")  // URL do seu frontend
//                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
//                .allowedHeaders("*")  // Permite todos os headers
//                .allowCredentials(false);  // Se você precisar de cookies ou credenciais
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}