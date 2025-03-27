package test_estoque.estoque.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @JsonProperty("id")
    private UUID Id;
    @JsonProperty("name")
    private String Name;
    @JsonProperty("lastName")
    private String LastName;

    public UserDTO(UUID id, String name, String lastName) {
        Id = id;
        Name = name;
        LastName = lastName;
    }

    public UserDTO() {
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
