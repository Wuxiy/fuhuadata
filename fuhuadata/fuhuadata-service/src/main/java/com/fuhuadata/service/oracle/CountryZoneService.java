package com.fuhuadata.service.oracle;

import com.fuhuadata.dao.datasource.DataSource;
import com.fuhuadata.domain.mybatis.Countryzone;
import com.fuhuadata.domain.oracle.CountryZone;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class CountryZoneService extends BaseNcSyncService<CountryZone, String, Countryzone, String> {

    public CountryZoneService() {
        this.syncName = "国家地区档案";
    }

    public static void main(String[] args) {
        System.out.println(AnnotationUtils.findAnnotation(CountryZoneService.class, DataSource.class));

        for (Class<?> clazz : ClassUtils.getAllInterfaces(CountryZoneService.class)) {
            System.out.println(clazz.isAnnotationPresent(DataSource.class));
            System.out.println(AnnotationUtils.findAnnotation(clazz, DataSource.class));

        }
    }
}
