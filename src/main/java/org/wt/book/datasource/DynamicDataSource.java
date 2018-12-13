package org.wt.book.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;

    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("当前数据源"+DataSourceContextHolder.getDataSource());
        return DataSourceContextHolder.getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put(DataSourceGlobal.WRITE,masterDataSource);
        map.put(DataSourceGlobal.READ,slaveDataSource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(masterDataSource);
        super.afterPropertiesSet();
    }
}
