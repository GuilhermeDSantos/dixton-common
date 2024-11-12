package net.dixton.model.server;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.Role;

@Entity
@Getter
@Setter
@ToString
public class Server {

    @Id
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer port, maxPlayers;

    private Boolean whitelisted;

    @ManyToOne
    @JoinColumn(name = "default_role_id")
    private Role defaultRole;

    @ManyToOne
    @JoinColumn(name = "needed_role_id")
    private Role neededRole;
}
