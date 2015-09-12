package me.xgate.accounts;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author cmoh on 2015. 9. 12..
 */
@Entity
@Data
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String loginId;

    private String password;

}
