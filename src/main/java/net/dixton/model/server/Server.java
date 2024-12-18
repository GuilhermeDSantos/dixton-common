package net.dixton.model.server;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.enums.ServerStatus;
import net.dixton.enums.ServerType;
import net.dixton.model.Role;

@Entity
@Getter
@Setter
@ToString
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer port, maxPlayers;

    @Column(nullable = false)
    private Integer minimumMemory, maximumMemory;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean whitelisted, autoStart;

    @ManyToOne
    @JoinColumn(name = "default_role_id")
    private Role defaultRole;

    @ManyToOne
    @JoinColumn(name = "needed_role_id")
    private Role neededRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServerType type;

    private ServerStatus status;
}
