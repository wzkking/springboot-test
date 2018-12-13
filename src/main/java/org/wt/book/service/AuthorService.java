package org.wt.book.service;

import org.wt.book.model.Author;

public interface AuthorService {
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

    /**
     * 事务测试
     * @param a1
     * @param a2
     * @return
     */
    int updateInfo(Author a1,Author a2);
}