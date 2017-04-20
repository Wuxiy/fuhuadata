package com.fuhuadata.service.oracle;

import com.fuhuadata.domain.mybatis.Timezone;
import com.fuhuadata.domain.oracle.TimeZone;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/20/2017
 */
@Service
public class TimeZoneService extends BaseNcSyncService<TimeZone, String, Timezone, String> {

    public TimeZoneService() {
        this.syncName = "时区";
    }

}
