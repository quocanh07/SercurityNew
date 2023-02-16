package com.example.springsercutiy.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Users")
public class Role {
    @Id
    @SequenceGenerator(name ="roles_sequence",sequenceName = "roles_sequence",allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "roles_sequence")
    private Long id;
    private String name;


   @ManyToMany(mappedBy = "roles")
   @Fetch(value = FetchMode.SELECT)
   @JsonIgnore
    private Set<User> user = new HashSet<>();
}
