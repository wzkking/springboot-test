package org.wt.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wt.book.dao.AuthorDao;
import org.wt.book.model.Author;
import org.wt.book.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    public AuthorDao authorDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return authorDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Author record) {
        return authorDao.insert(record);
    }

    @Override
    public int insertSelective(Author record) {
        return authorDao.insertSelective(record);
    }

    @Override
    public Author selectByPrimaryKey(Integer id) {
        return authorDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Author record) {
        return authorDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Author record) {
        return authorDao.updateByPrimaryKey(record);
    }

    @Override
    public Author selectAuthorName(Author record) {
        return authorDao.selectAuthorName(record);
    }

    @Override
    @Transactional
    public int updateInfo(Author a1, Author a2) {
        authorDao.updateByPrimaryKeySelective(a1);
        authorDao.insertSelective(a2);
        return 0;
    }
}
