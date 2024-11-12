package net.dixton.model.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.account.Account;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class Player {

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
