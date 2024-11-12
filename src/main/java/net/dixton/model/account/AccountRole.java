package net.dixton.model.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.Role;
import net.dixton.model.server.Server;

import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    public boolean isGroupActive() {
        return Instant.now().isBefore(expirationDate);
    }
}
