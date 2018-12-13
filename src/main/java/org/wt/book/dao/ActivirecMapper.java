package org.wt.book.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wt.book.model.Activirec;
import org.wt.book.model.ActivirecExample;
import org.wt.book.model.Rank;

public interface ActivirecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activirec record);

    int insertSelective(Activirec record);

    Activirec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activirec record);

    int updateByPrimaryKey(Activirec record);

    Activirec selectByUidAndTitleIdDesc(@Param("uid") int uid, @Param("id") Integer id);

    int sumAward(int userId);

    int sumAwardByDate(@Param("userId") int userId, @Param("date") Date date);

    Rank myRank(int userId);

    int countUser();

    Activirec selectByUidAndTitleId(@Param("uid") int uid, @Param("id") Integer id);

    int countTitleFriend(@Param("uid") int uid, @Param("id") Integer id);

    List<Activirec> selectByUserIdAndTitleId(@Param("userId") int userId, @Param("titleId") Integer titleId);

}
