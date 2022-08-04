package hello.practicespring.controller;

//name을 입력하면 setName 호출을 통해 private에 접근하여 name을 넣어주고 getName을 통해 name을 꺼냄
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
