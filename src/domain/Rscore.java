package domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class Rscore implements Serializable {
  @Id
    private Integer rid;
  private String lesson;
  private Float rscore;
  private Integer sid;
  //一门成绩只属于一个学生
  private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Rscore{" +
                "rid=" + rid +
                ", lesson='" + lesson + '\'' +
                ", rscore=" + rscore +
                ", sid=" + sid +
                '}';
    }

    public Rscore() {
    }

    public Rscore(Integer rid, String lesson, Float rscore, Integer sid) {
        this.rid = rid;
        this.lesson = lesson;
        this.rscore = rscore;
        this.sid = sid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getlesson() {
        return lesson;
    }

    public void setlesson(String lesson) {
        this.lesson = lesson;
    }

    public Float getRscore() {
        return rscore;
    }

    public void setRscore(Float rscore) {
        this.rscore = rscore;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
