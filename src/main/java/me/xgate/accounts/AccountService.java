package me.xgate.accounts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author cmoh on 2015. 9. 15..
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) {
        Account account = modelMapper.map(dto, Account.class);
        // TODO 유효한 username 판단
        // TODO password 암호화
        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);
        // 저장 후 돌려준다. 넣은 녀석과는 다른 객체
        return repository.save(account);
    }
}
