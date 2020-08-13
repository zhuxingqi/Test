package dao;

import PoJo.StudengHg;
import domain.Teacher;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/7
 */
public interface TeacherDao extends Mapper<Teacher> {
    @Select("SELECT t1.tname teacherName,t1.lesson lesson,COUNT(tname) count FROM teacher t1 , st s1 ,rscore r1 WHERE t1.tid = s1.tid AND r1.sid = s1.sid AND r1.lesson = t1.lesson AND rscore>60 GROUP BY tname")
    List<StudengHg> selectByHahaha();
}
