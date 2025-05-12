package shop.mtcoding.blog;

import lombok.Getter;

@Getter
public class Apply {
    private Integer id; // 지원번호
    private String name; // 지원자명
    private Integer comId; // 회사아이디
    private String status;
    // 디비 관점에서 볼 때의 도메인 = (데이터)범주
    // 객체지향 프로그램 관점의 도메인 = (오브젝트, 비지니스)범주
    // => 상세히 정리해보기


    public Apply(Integer id, String name, Integer comId, ApplyEnum status) {
        this.id = id;
        this.name = name;
        this.comId = comId;
        this.status = status.value;
    }
}
