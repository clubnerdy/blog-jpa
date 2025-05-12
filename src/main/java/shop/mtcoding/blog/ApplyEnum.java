package shop.mtcoding.blog;

/*
    리스트 = [1,2,3] 가변
    튜플 = (1,2,3) 불변 => enum은 튜플과 비슷한 불변임
 */
public enum ApplyEnum { // 열거형
    PASS("합격"), FAIL("불합격");

    public String value;

    ApplyEnum(String value) { // enume도 이렇게 생성자를 만들 수 있다.
        this.value = value;
    }
}
