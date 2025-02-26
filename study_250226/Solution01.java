package Devcos.AIBE.study_250226;

public class Solution01 {

    public static void main(String[] args) {
        Teacher young = new Teacher();
        Student han = new Student();
        young.useAI();
        System.out.println(young.language);
        young.useAI("바본가");
//        System.out.println("young.secret = " + young.secret);
        System.out.println("young.protectedSecret = " + young.protectedSecret);
        han.useAI();
        System.out.println(han.language);
        han.useAI("천잰가");
        han.saySecret();
        han.useLanguage("Python");
        System.out.println("han.protectedSecret = " + han.protectedSecret);
        System.out.println("han = " + han);
    }
}

class Teacher {
    String language = "Java";

    private String secret = "이상함";

    protected String protectedSecret = "말 많음";

    Teacher() {
        System.out.println("강사 등장");
    }

    void useAI() {
        System.out.println("AI 쓰셈");
    }

    void useAI(String msg) {
        System.out.println(msg);
    }
}

// 상속 extends
class Student extends Teacher {
    String language = "Java17";

    protected String protectedSecret = "말 없음";

    @Override
    void useAI() {
        System.out.println("난 AI 만들거임");
    }

    void useLanguage(String language) {
        System.out.println("language = " + language);
        System.out.println("this.language = " + this.language);
        System.out.println("super.language = " + super.language);
    }

    void saySecret() {
//        System.out.println("secret = " + secret);
        System.out.println("protectedSecret = " + protectedSecret);;
    }

    @Override
    public String toString() {
        return "학생임";
    }
}