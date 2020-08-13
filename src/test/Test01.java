package test;
import PoJo.RscoreMaxMin;
import PoJo.RscoreVo;
import PoJo.StudengHg;
import PoJo.StudentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.RscoreDao;
import dao.StudentDao;
import dao.TeacherDao;
import domain.*;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;
import utils.MyBatisUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class Test01 {
    /**
     * 添加一条学生数据：10,'张明','女',22
     */
    @Test
    public void run1(){
    StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
    Student s = new Student(10, "张明", "女", 22);
    int row = dao.insert(s);
    System.out.println(row);
    MyBatisUtils.commitAndClose();
}
    /**
     *修改一条学生数据：sid=10的数据，性别改为 '男'，其他数据不变
     */
    @Test
public void run2(){
    StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
    Student ss = new Student(10, null, "男", null);
    int row = dao.updateByPrimaryKeySelective(ss);
    System.out.println(row);
    MyBatisUtils.commitAndClose();
}
    /**
     * 、添加一条学生数据：11, '李林', '男',23
     删除一条学生数据：sid=10的数据
     这时，发现删除了不该删除的数据，需要删除后把删除的数据还原，但添加的数据
     */
    @Test
public void run3(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        Student s = new Student(11, "李林", "男", 23);
        int row = dao.insert(s);
        System.out.println(row);
        MyBatisUtils.commitAndClose();
        int i = dao.deleteByPrimaryKey(10);
        System.out.println(i);
        MyBatisUtils.rollbackAndClose();
    }
    /**
     * 删除一条学生数据：sid=10 或 sid=11的数据
     */
    @Test
public void run4(){
    StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
    List<Integer> slist = new ArrayList<>();
    Collections.addAll(slist,10,11);
    int row=dao.deleteStudentById(slist);
    System.out.println(row);
    MyBatisUtils.commitAndClose();
}
    /**
     * 添加一条学生数据：12, '李风', '男',25
     删除一条学生数据：sid=2的数据
     若删除出现异常，则把添加的数据和删除的数据均还原。
     若删除正确，则将本次添加和删除的数据均提交。
     */
    @Test
public void run5(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        Student s = new Student(12, "李凤", "男", 25);
        int row = dao.insert(s);
        try {
            int row2 = dao.deleteByPrimaryKey(2);
        } catch(Exception e) {
            MyBatisUtils.rollbackAndClose();
            return;
        }
        MyBatisUtils.commitAndClose();
    }
    /**
     * 分页查询学生表中：姓名以'明'结尾, 或者年龄在16~18之间
     */
    @Test
    public void run6(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
         PageHelper.startPage(1, 3);
        Example example = new Example(Student.class);
        Example.Criteria c = example.createCriteria();
        c.andLike("sname","%明");
        c.orBetween("age","16","18");
        List<Student> slist = dao.selectByExample(example);
        PageInfo<Student> pi = new PageInfo<>(slist);
        for (Student s : pi.getList()) {
            System.out.println(s);
        }
        MyBatisUtils.close();
    }
    /**
     *分页查询学生表中：年龄大于平均年龄的同学信息
     */
    @Test
    public void run7(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        List<Student> slist= dao.selectStudentAvg();
        PageInfo<Student> pi = new PageInfo<>(slist);
        for (Student student : pi.getList()) {
            System.out.println(student);
        }
        MyBatisUtils.close();
    }

    /**
     * 分页查询学生表中：主键为1或3或5或7，或者姓名包含'小', 并且性别为'男', 并且年龄在16~20岁之间
     */
    @Test
    public void run8(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        Example example = new Example(Student.class);
        Example.Criteria c = example.createCriteria();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,5,7);
        c.andIn("sid",list);
        c.orLike("sname","%小%");
        c.andEqualTo("sex","男");
        c.andBetween("age","16","20");
        List<Student> slist = dao.selectByExample(example);
        PageInfo<Student> pi = new PageInfo<Student>(slist);
        for (Student student : pi.getList()) {
            System.out.println(student);
        }
        MyBatisUtils.close();
    }

    /**
     *分页查询学生表中：主键为1或3或5或7，或者姓名包含'小', 并且性别为'男', 并且年龄在16~20岁之间
     注意：如果在参数传递时， 主键、姓名、性别、年龄 出现null或者空字符串，则视为该参数未传递，未传递参数的条件，不拼接到SQL语句上
     */
    @Test
    public void run9(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,5,7);
        List<Student> slist= dao.selectByTeam(list,"%小%","男",16,20 );
        PageInfo<Student> pi = new PageInfo<>(slist);
        for (Student s : pi.getList()) {
            System.out.println(s);
        }
           MyBatisUtils.close();
    }
    /**
     * 查询学生'龙龙'的两门成绩分别为什么？是否合格（分数>=60为合格）
     */
    @Test
    public void run10() {
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        List<StudentVo> slist = dao.selectScoreByName("龙龙");
        for (StudentVo s : slist) {
            if (s.getRscore() >= 60) {
                System.out.println("学科" + s.getlesson() + "成绩" + s.getRscore() + "合格");
            } else {
                System.out.println("学科" + s.getlesson() + "成绩" + s.getRscore() + "不合格");
            }
        }
        MyBatisUtils.close();
    }

/**
 * 查询所有男同学的'Java'课程的平均分
 */
@Test
public void run11(){
    RscoreDao dao = MyBatisUtils.getMapper(RscoreDao.class);
    float score=dao.selectStudentAvg();
    System.out.println("平均分为"+score);
}
/**
 * 查询所有同学的'Java'课程的最高分和最低分
 */
@Test
public void run12(){
    RscoreDao dao = MyBatisUtils.getMapper(RscoreDao.class);
      List<RscoreMaxMin> list = dao.selectByMaxMin("Java");
    System.out.println(list);
    MyBatisUtils.close();
}
/**
 * 查询学'PHP' 学生多？ 还是学'Python'的学生多？
 */
@Test
    public void run13(){
    RscoreDao dao = MyBatisUtils.getMapper(RscoreDao.class);
      Integer row= dao.selectByPhp();
      Integer row2= dao.selectByPython();
      if (row>row2){
          System.out.println("学php的人多");
      }else {
          System.out.println("学php的人多");
      }
      MyBatisUtils.close();
}
/**
 * 查询'磊老师'，学生平均成绩分别为多少（老师教哪门课程，就只计算学生的该课程的成绩）
 */
@Test
    public void run14(){
    RscoreDao dao = MyBatisUtils.getMapper(RscoreDao.class);
     float  avg= dao.selectAvgByTeacherName("磊老师");
     System.out.println(avg);
       MyBatisUtils.close();
}
/**
 * 计算并展示所有老师的学生合格数（老师教哪门课程，就只计算学生的该课程的成绩）
 */
@Test
public void run15(){
    TeacherDao dao = MyBatisUtils.getMapper(TeacherDao.class);
     List<StudengHg> tlist= dao.selectByHahaha();
    for (StudengHg studengHg : tlist) {
        System.out.println(studengHg);
    }
    MyBatisUtils.close();
}
/**
 *计算并查询，每科最高分数的成绩信息和同学信息
 */
@Test
public void run16(){
    RscoreDao dao = MyBatisUtils.getMapper(RscoreDao.class);
    List<RscoreVo> rlist = dao.selectMaxlist();
    System.out.println(rlist);
      MyBatisUtils.close();
    }
}





















