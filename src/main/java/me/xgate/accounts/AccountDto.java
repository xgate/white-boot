package me.xgate.accounts;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author cmoh on 2015. 9. 15..
 */
public class AccountDto {

    /**
     * 이렇게 해주면, Account 모델 객체를 controller에서 바로 사용하지 않아도 된다.
     * 특장점은 Account 객체에 어떤 값들이 셋팅되고, 안되는지를 신경쓸 필요가 없다는 것.
     * 명시적이다.
     */
    @Data
    public static class Create {
        @NotBlank
        @Size(min = 5)
        private String username;

        @NotBlank
        @Size(min = 5)
        private String password;
    }

    @Data
    public static class Response {
        private Long id;
        private String username;
        private String fullName;
        private Date joined;
        private Date updated;
    }
}
