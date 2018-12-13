package org.wt.book.datasource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceGlobal> contextHolder = new ThreadLocal<>();

    public static void setDataSource(DataSourceGlobal dataSource){
        contextHolder.set(dataSource);
    }

    public static DataSourceGlobal getDataSource(){
        return contextHolder.get();
    }

    public static void cleardataSource(){
        contextHolder.remove();
    }
}
