package me.xgate.accounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author cmoh on 2015. 9. 12..
 */
public class AccountTest {

    @Test
    public void getterSetter() {
        Account account = new Account();
        account.setUsername("whiteboot");
        account.setPassword("password");
        assertThat(account.getUsername(), is("whiteboot"));
    }
}