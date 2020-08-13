package domain;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class Teacher implements Serializable {
    @Id
    private Integer tid;
    private String tname;
    private String lession;
    private List<St> tlist=new ArrayList<St>();

    public List<St> getTlist() {
        return tlist;
    }

    public void setTlist(List<St> tlist) {
        this.tlist = tlist;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", lession='" + lession + '\'' +
                '}';
    }

    public Teacher() {
    }

    public Teacher(Integer tid, String tname, String lession) {
        this.tid = tid;
        this.tname = tname;
        this.lession = lession;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getLession() {
        return lession;
    }

    public void setLession(String lession) {
        this.lession = lession;
    }
}
