package org;

import org.config.HibernateLibrary;
import org.dao.AccountRepository;
import org.dao.BookRepository;
import org.dao.GroupRepository;
import org.dao.daoi.IAccount;
import org.dao.daoi.IBook;
import org.dao.daoi.IGroup;
import org.entity.Account;
import org.entity.Book;
import org.entity.Group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by AMakas on 07.02.2017.
 */
public class Launcher {
    public static void main(String[] args) {
        IAccount accountRepository = new AccountRepository();
        IBook bookRepository = new BookRepository();
        IGroup groupRepository = new GroupRepository();

        Group group = groupRepository.getById(1);
        Account account = accountRepository.getById(1);


        Book book1 = new Book();
        book1.setTitle("Title000");
        book1.setAuthor("Author000");

        bookRepository.add(book1);

        /*
        Book book2 = new Book();
        book2.setTitle("Title222");
        book2.setAuthor("Author222");

        Book book3 = new Book();
        book3.setTitle("Title333");
        book3.setAuthor("Author333");

        Set<Account> allAccount = new HashSet<Account>();
        allAccount.add(account);

        book1.setAccounts(allAccount);
        bookRepository.add(book1);

        account = accountRepository.getById(2);
        allAccount.add(account);
        book2.setAccounts(allAccount);
        bookRepository.add(book2);

        account = accountRepository.getById(2);
        allAccount.add(account);
        book3.setAccounts(allAccount);
        bookRepository.add(book3);


        Group groupAdmin = new Group();
        groupAdmin.setTitle("Администратор");

        Group groupUser = new Group();
        groupUser.setTitle("Пользователь");

        Group groupGuest = new Group();
        groupGuest.setTitle("Гость");

        */
        /*
        Group group = groupRepository.getById(4);
        groupRepository.delete(group);

        List<Group> list =  groupRepository.getAll();
        for(Group item : list) {
            System.out.println( item.toString() );
        }
        */

/*
        List<Group> list = groupRepository.getByName("Администратор");
        if (list != null && list.size() > 0) {
            for(Group item : list) {
                System.out.println( item.toString() );
            }
        }
*/



/*
        List<Group> list =  groupRepository.getAll();
        for(Group item : list) {
            System.out.println( item.toString() );
        }
*/

        /* add or update
        groupRepository.add(groupAdmin);
        groupRepository.add(groupUser);
        groupRepository.add(groupGuest);

        Group group = groupRepository.getById(2);

        group.setTitle("Пользователь");
        groupRepository.add(group);
        group = groupRepository.getById(2);
        System.out.println( group.toString() );

        if (groupRepository.add(groupAdmin)) {
            System.out.println(groupAdmin.toString() + " Yes");
        } else {
            System.out.println(groupAdmin.toString() + " No. " + groupRepository.getError());
        }
        */
        Account account1 = new Account();
        account1.setEmail("email");
        account1.setLastname("haka");
        account1.setMiddlename("haka");
        account1.setName("torpedo");
        account1.setLogin("login");
        account1.setPassword("paka");
        account1.setPhone("dsdsd");
        account1.setGroup(group);


/*
        if (accountRepository.add(account1)) {
            System.out.println(account1.toString() + " Yes");
        } else {
            System.out.println(account1.toString() + " No. " + accountRepository.getError());
        }
*/
        /*List<Account> list =  accountRepository.getAll();
        for(Account account : list) {
            System.out.println( account.toString() );
        }*/




        HibernateLibrary.shutDown();


    }

}
