package org.wt.book.dao;

import org.wt.book.model.Author;

public interface AuthorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
    
    /**
     * 根据作者名查看是否已存在
     * @param record
     * @return
     */
    Author selectAuthorName(Author record);
}