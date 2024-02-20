package project.vo;

//Vo : value object  : 데이터 형식을 정의하는 클래스 
//                      private필드, 커스텀생성자(값초기화),getter,toString, hashcode,equals 를 한것
//                      객체 생성시 값을 초기화 한 후 변경할수 없으며, 필드값이 같으면 같은 값으로 처리되는 객체
//단축키 : 컨트롤 점 
import java.sql.Date;

public class CustomerVo { // --> tbl_custom테이블과 1:1 대응되는 변수로 만들었다.
    private String customId;
    private String name;
    private String email; // 불변값으로 설정해보자
    private int age; // 불변값으로 설정해보자
    private Date reg_data;

    // 생성자
    public CustomerVo(String customId, String name, String email, int age, Date reg_data) {
        this.customId = customId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.reg_data = reg_data;
    }

    // getter
    public String getCustomId() {
        return customId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Date getReg_data() {
        return reg_data;
    }

    // toString
    @Override
    public String toString() {
        return "BuyVo [customId=" + customId + ", name=" + name + ", email=" + email + ", age=" + age + ", reg_data="
                + reg_data + "]";
    }

    // 참고: 아래 2개의 메소드가 재정의 되어야 진짜 VO이다.
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customId == null) ? 0 : customId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + age;
        result = prime * result + ((reg_data == null) ? 0 : reg_data.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerVo other = (CustomerVo) obj;
        if (customId == null) {
            if (other.customId != null)
                return false;
        } else if (!customId.equals(other.customId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (age != other.age)
            return false;
        if (reg_data == null) {
            if (other.reg_data != null)
                return false;
        } else if (!reg_data.equals(other.reg_data))
            return false;
        return true;
    }

}
