package PoJo;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/7
 */
public class StudengHg {
    private String teachername;
    private String lesson;
    private Integer count;

    @Override
    public String toString() {
        return "StudengHg{" +
                "teachername='" + teachername + '\'' +
                ", lesson='" + lesson + '\'' +
                ", count=" + count +
                '}';
    }

    public StudengHg() {
    }

    public StudengHg(String teachername, String lesson, Integer count) {
        this.teachername = teachername;
        this.lesson = lesson;
        this.count = count;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
