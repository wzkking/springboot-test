package org.wt.book.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wt.book.model.Author;
import util.JSONUtils;

@Aspect
@Component
public class RedisAop {
    private static final int AUTHOR_DB=3;

    @Autowired
    private RedisOperator redisOperator;

    @Pointcut(value = "execution(* org.wt.book.service.impl.AuthorServiceImpl.selectByPrimaryKey(..))")
    public void getAuthorById(){}

    @Around("getAuthorById()")
    private Author getAuthorById(ProceedingJoinPoint pjp) throws Throwable{
        String id = ((Object[])pjp.getArgs())[0].toString();
        Object jsonToken = redisOperator.get(id, AUTHOR_DB);
        if(jsonToken == null){
            Author author = (Author)pjp.proceed();
            if(author != null)
                redisOperator.set(id, JSONUtils.toJSON(author), AUTHOR_DB);
            return author;
        }else{
            Author author = (Author)JSONUtils.fromJson(jsonToken.toString(), Author.class);
            return author;
        }
    }
}
