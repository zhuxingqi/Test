package domain;

import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class Student implements Serializable {
  @Id
    private Integer sid;
    private String sname;
    private String sex;
    private Integer age;

    //一个学生有多门成绩
    private List<Rscore> rlist=new ArrayList<Rscore>();

    private List<St> slist=new ArrayList<St>();

    public List<Rscore> getRlist() {
        return rlist;
    }

    public void setRlist(List<Rscore> rlist) {
        this.rlist = rlist;
    }

    public List<St> getSlist() {
        return slist;
    }

    public void setSlist(List<St> slist) {
        this.slist = slist;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(Integer sid, String sname, String sex, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
    }

    public Student() {
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
}
