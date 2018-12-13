package org.wt.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wt.book.model.Activirec;
import org.wt.book.model.ActivirecExample;
import org.wt.book.model.Author;
import org.wt.book.redis.RedisOperator;
import org.wt.book.service.ActiviRecService;
import org.wt.book.service.AuthorService;

@Controller
@RequestMapping("wt")
public class WzkController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private RedisOperator redisOperator;
    @Autowired
    private ActiviRecService activiRecService;

    private static Logger log = LoggerFactory.getLogger(WzkController.class);

    @RequestMapping("getInfo")
    @ResponseBody
    public Author getAuthor(Integer id){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        return authorService.selectByPrimaryKey(id);
    }

    @RequestMapping("rec")
    @ResponseBody
    public String rec(Integer id){
        log.info("sssss");
        Activirec ac = new Activirec();
        ac.setId(1);
        ac.setStr1("111111");
        ActivirecExample ae = new ActivirecExample();
        activiRecService.selectByIdFri(1,"1");
        return "0000";
    }

    @RequestMapping("sw")
    @ResponseBody
    public String sw(){
        try{
            Author a1 = new Author();
            a1.setId(2);
            a1.setStr1("3333");
            Author a2 = new Author();
            a2.setId(3);
            a2.setNickname("123");
            authorService.updateInfo(a1,a2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0000";
    }

    @RequestMapping("redis")
    @ResponseBody
    public String redis(Integer id){
        redisOperator.set("wzk","wwww",3);
        return "0000";
    }
}
