package net.dixton.services;

import net.dixton.exceptions.account.AccountNotFoundException;
import net.dixton.model.account.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);
    Account findById(Long id) throws AccountNotFoundException;
    List<Account> findAll();
    Account update(Long id, Account updatedAccount) throws AccountNotFoundException;

}
