package dao;

import domain.Student;
import PoJo.StudentVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public interface StudentDao extends Mapper<Student>  {

    int deleteStudentById(@Param("slist") List<Integer> slist);

@Select("SELECT * FROM student WHERE age>(SELECT AVG(age) FROM student)")
    List<Student> selectStudentAvg();

    List<Student> selectByTeam(@Param("slist") ArrayList<Integer> list, @Param("sname") String sname, @Param("sex") String sex, @Param("age") int a1,@Param("age2") int a2);

@Select("SELECT lesson,rscore FROM rscore WHERE sid=(SELECT sid FROM student WHERE sname=#{sname})")
    List<StudentVo> selectScoreByName(@Param("sname") String sname);
}
