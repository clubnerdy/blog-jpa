package shop.mtcoding.blog.temp;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

// $2a$10$K8qAwkoyXVCu8MFWyyrvjurGOS99XxJv0GPAL5RdvY/ih4colqpu6
// $2a$10$t0s5jxFRYfnT8HASsuCeu.L3JL829tYB9zArGhOCOVzXWyKvzaKpa
public class HashTest {

    @Test
    public void encode_test() {
        String password = "1234";

        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(encPassword);
    }

    @Test
    public void decode_test() {
        // $2a$10$K8qAwkoyXVCu8MFWyyrvjurGOS99XxJv0GPAL5RdvY/ih4colqpu6
        // $2a$10$t0s5jxFRYfnT8HASsuCeu.L3JL829tYB9zArGhOCOVzXWyKvzaKpa
        String dbPassword = "$2a$10$K8qAwkoyXVCu8MFWyyrvjurGOS99XxJv0GPAL5RdvY/ih4colqpu6";
        String password = "1234";

        String decPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        if (decPassword.equals(dbPassword)) {
            System.out.println("비밀번호가 같아요");
        } else {
            System.out.println("비밀번호가 달라요");
        }
    }

    @Test
    public void decodev2_test() {
        // $2a$10$K8qAwkoyXVCu8MFWyyrvjurGOS99XxJv0GPAL5RdvY/ih4colqpu6
        // $2a$10$t0s5jxFRYfnT8HASsuCeu.L3JL829tYB9zArGhOCOVzXWyKvzaKpa
        String dbPassword = "$2a$10$K8qAwkoyXVCu8MFWyyrvjurGOS99XxJv0GPAL5RdvY/ih4colqpu6";
        String password = "1234";

        Boolean isSame = BCrypt.checkpw(password, dbPassword);
        System.out.println(isSame);
    }
}
