package test_estoque.estoque.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users", schema = "public")
public class User implements UserDetails {
    @jakarta.persistence.Id
    @Column(name = "user_id")
    @JsonProperty("id")
    private UUID Id;
    @Column(name = "name")
    @JsonProperty("name")
    private String Name;
    @Column(name = "last_name")
    @JsonProperty("lastName")
    private String LastName;

    public User(UUID id, String name, String lastName) {
        Id = id;
        Name = name;
        LastName = lastName;
    }

    public User() {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return Name;
    }

    @Override
    public String getUsername() {
        return Name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void SetValueUserAddress(String name, String lastName){
        Name = name;
        LastName = lastName;
    }
}
