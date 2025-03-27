package test_estoque.estoque;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test_estoque.estoque.application.dto.UserDTO;
import test_estoque.estoque.domain.entities.User;

@Configuration
public class ModelConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
            .setAmbiguityIgnored(true)
            .setPropertyCondition(context -> context.getSource() != null);

        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setLastName(source.getLastName());
            }
        });

        return modelMapper;
    }
}