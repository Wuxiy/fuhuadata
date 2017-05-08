package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.service.mybatis.CustomerBaseInfoService;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 5/5/2017
 */
@Service
public class CustomerBaseInfoServiceImpl extends BaseServiceImpl<CustomerBaseInfo, Integer>
        implements CustomerBaseInfoService {

    @Override
    public CustomerBaseInfo getCoopCustomer(Integer customerId) {
        CustomerBaseInfo customer = get(customerId);

        Date startCooperationTime = customer.getStartCooperationTime();

        if (null != startCooperationTime) {
            LocalDate startJoda = LocalDate.fromDateFields(startCooperationTime);
            LocalDate nowJoda = LocalDate.now();

            int months = Months.monthsBetween(startJoda, nowJoda).getMonths();

            customer.setCooperationDuration(months);// 合作时间
        }

        return customer;
    }

    public static void main(String[] args) {

        LocalDate start = LocalDate.parse("2017-04-08");
        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

        System.out.println(Months.monthsBetween(start, now).getMonths());
    }
}
