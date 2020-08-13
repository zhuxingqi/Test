package dao;

import PoJo.RscoreVo;
import domain.Rscore;
import PoJo.RscoreMaxMin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public interface RscoreDao extends Mapper<Rscore> {

    @Select("SELECT AVG(rscore) FROM rscore WHERE sid IN(SELECT sid FROM student WHERE sex='男') AND lesson='Java' GROUP BY lesson")
    float selectStudentAvg();

    @Select("SELECT MAX(rscore) max,MIN(rscore) min FROM rscore WHERE lesson=#{lesson}")
    List<RscoreMaxMin> selectByMaxMin(@Param("lesson") String lesson);

    @Select("SELECT COUNT(rid) row FROM rscore WHERE lesson='php'")
    Integer selectByPhp();
    @Select("SELECT COUNT(rid) row2 FROM rscore WHERE lesson='python'\n")
    Integer selectByPython();

    @Select("SELECT AVG(rscore) FROM rscore WHERE sid IN(SELECT sid FROM st WHERE tid =(SELECT tid FROM teacher WHERE tname=#{tname}))")
    float selectAvgByTeacherName(@Param("tname") String tname);

    @Select("select *  from student s1,(select sid,lesson,max(rscore) max from rscore group by lesson \n" +
        ") s2 where s1.sid=s2.sid")
    List<RscoreVo> selectMaxlist();
}
