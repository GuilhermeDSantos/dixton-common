package net.dixton.model.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.account.Account;

@Entity
@Getter
@Setter
@ToString
public class MainLobbyPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
