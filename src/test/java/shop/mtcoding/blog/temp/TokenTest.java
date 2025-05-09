package shop.mtcoding.blog.temp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import shop.mtcoding.blog.user.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class TokenTest {

    @Test
    public void create_test() {
        User user = User.builder()
                .id(1)
                .username("ssar")
                .password("$2a$10$K8qAwkoyXVCu8MFWyyrvjurGOS99XxJv0GPAL5RdvY/ih4colqpu6")
                .email("ssar@nate.com")
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        String jwt = JWT.create()
                .withSubject("blogv3") // 무조건 들어가긴 하는데 크게 의미없어서 아무거나 적어도 상관없음
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 현재시간 -> 나중에 배포할 때 시간에 대한 수업 진행 예정
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .sign(Algorithm.HMAC256("metacoding"));

        // 패스워드가 들어가지 않는 이유 민감한 정보라서
        // 여기는 payload에 대당하는 부분이라 사용자를 식별할 수 있는 값만 넣으면 된다.

        // 198 156 236 87 42 53 186 254 56 151 169 7 107 178 5 197 147 172 56 100 145 97 133 14 17 46 135 193 73 199 201 144
        // xpzsVyo1uv44l6kHa7IFxZOsOGSRYYUOES6HwUnHyZA
        System.out.println(jwt);
    }

    @Test
    public void verify_test() {
        // 2025.05.09.11.50분까지 유효
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJibG9ndjMiLCJpZCI6MSwiZXhwIjoxNzQ2NzU5MDMxLCJ1c2VybmFtZSI6InNzYXIifQ.N-4ao6z_bt2IDijZgWXzYO9s6doH18sWdMtihf1i7AY";

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("metacoding")).build().verify(jwt);
        Integer id = decodedJWT.getClaim("id").asInt();
        String username = decodedJWT.getClaim("username").asString();

        System.out.println(id);
        System.out.println(username);

        User user = User.builder()
                .id(id)
                .username(username)
                .build();
    }
}
