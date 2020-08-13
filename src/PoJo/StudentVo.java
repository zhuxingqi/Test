package PoJo;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class StudentVo  {
    private String lesson;
    private float rscore;

    @Override
    public String toString() {
        return "StudentVo{" +
                "lesson='" + lesson + '\'' +
                ", rscore=" + rscore +
                '}';
    }

    public StudentVo() {
    }

    public StudentVo(String lesson, float rscore) {
        this.lesson = lesson;
        this.rscore = rscore;
    }

    public String getlesson() {
        return lesson;
    }

    public void setlesson(String lesson) {
        this.lesson = lesson;
    }

    public float getRscore() {
        return rscore;
    }

    public void setRscore(float rscore) {
        this.rscore = rscore;
    }
}
