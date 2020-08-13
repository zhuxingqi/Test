package PoJo;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/7
 */
public class RscoreVo {
    private Integer sid;
    private String sname;
    private String sex;
    private Integer age;
    private String lesson;
    private Integer max;

    @Override
    public String toString() {
        return "RscoreVo{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", lesson='" + lesson + '\'' +
                ", max=" + max +
                '}';
    }

    public RscoreVo() {
    }

    public RscoreVo(Integer sid, String sname, String sex, Integer age, String lesson, Integer max) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.lesson = lesson;
        this.max = max;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
