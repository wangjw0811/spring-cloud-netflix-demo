package com.example.api;

import com.example.api.dto.PostUser;
import com.example.api.dto.PutUser;
import com.example.api.vo.UserVO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserFallBackFactory implements FallbackFactory<UserApi> {
    @Override
    public UserApi create(Throwable throwable) {
        return new UserApi() {
            @Override
            public Integer createUser(PostUser user) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }

            @Override
            public UserVO getUser(int id) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }

            @Override
            public Integer updateUser(PutUser user) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }

            @Override
            public Boolean deleteUser(int id) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return false;
            }

            @Override
            public List<UserVO> getUsers(int current, int size) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }
        };
    }
}
