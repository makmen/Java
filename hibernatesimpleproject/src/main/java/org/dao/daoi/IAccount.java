package org.dao.daoi;

import org.entity.Account;

import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public interface IAccount {
    public boolean add(Account account);

    public void delete(Account account);

    public void update(Account account);

    public List<Account> getAll();

    public Account getById(int id);

    public List<Account> getByName(String string);

    public String getError();
}
