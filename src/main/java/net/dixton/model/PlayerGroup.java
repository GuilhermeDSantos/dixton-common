package net.dixton.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.server.Server;

import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
public class PlayerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    public boolean isGroupActive() {
        return Instant.now().isBefore(expirationDate);
    }
}
