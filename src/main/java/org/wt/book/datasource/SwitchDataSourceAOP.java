package org.wt.book.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Lazy(false)
@Order(0)
public class SwitchDataSourceAOP {
    //这里切到你的方法目录
    @Before(value = "execution(* org.wt.book.service.*.*(..))")
    public void process(JoinPoint joinPoint) {
        String methodName=joinPoint.getSignature().getName();
        if (methodName.startsWith("get")
                ||methodName.startsWith("find")
                ||methodName.startsWith("list")
                ||methodName.startsWith("select")
                ||methodName.startsWith("check")){
            DataSourceContextHolder.setDataSource(DataSourceGlobal.READ);
        }else {
            //切换dataSource
            DataSourceContextHolder.setDataSource(DataSourceGlobal.WRITE);
        }
    }

}
