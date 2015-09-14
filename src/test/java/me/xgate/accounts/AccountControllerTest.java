package me.xgate.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.xgate.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author cmoh on 2015. 9. 15..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
// 이거슨 => @ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@WebAppConfiguration
// @Transactional => 테스트에서는 자동 롤백 시킨다. (메서드 호출 후 데이터 정리)
public class AccountControllerTest {

    @Autowired
    WebApplicationContext wac; // from. @WebAppConfiguration

    @Autowired
    ObjectMapper objectMapper; // 자동으로 빈으로 등록되어있음. 걍 쓰면됨

    @Test
    public void createAccount() throws Exception {
        // given
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        AccountDto.Create createDto = new AccountDto.Create();
        createDto.setUsername("whiteboot");
        createDto.setPassword("password");

        // when
        ResultActions result = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)));

        // then
        result.andDo(print());
        result.andExpect(status().isCreated());
    }
}
