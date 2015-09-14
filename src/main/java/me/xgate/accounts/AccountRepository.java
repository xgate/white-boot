package me.xgate.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cmoh on 2015. 9. 15..
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
