package domain;

import java.io.Serializable;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class St implements Serializable {
    private Integer sid;
    private Integer tid;
    private Student student;
    private Teacher teacher;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "St{" +
                "sid=" + sid +
                ", tid=" + tid +
                '}';
    }

    public St() {
    }

    public St(Integer sid, Integer tid) {
        this.sid = sid;
        this.tid = tid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
