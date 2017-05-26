package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.vo.BusinessOrderVO;
import com.fuhuadata.vo.CostAndProfitStatistics;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/18.
 */

public class BusinessOrderDaoImpl extends SqlMapClientTemplate implements BusinessOrderDao {
    private static final String COUNT_ORDER= "BUSINESSORDER.COUNT-ORDER";
    private static final String COUNT_OFFER="BUSINESSORDER.COUNT-OFFER";
    private static final String ADD="BUSINESSORDER.ADD";
    private static final String UPDATE_BY_ORDERID="BUSINESSORDER.UPDATE";
    public static final String GET_BY_ID = "BUSINESSORDER.GET-BY-ID";
    private static final String UPDATE_OFFER_STATUS="BUSINESSORDER.UPDATE-OFFER-STATUS";
    private static final String OFFER_GET_PAGE="BUSINESSORDER.OFFER-GET-PAGE";
    private static final String ORDER_GET_PAGE="BUSINESSORDER.ORDER-GET-PAGE";

    private static final String COUNT = "BUSINESSORDER.count";
    private static final String QUERY_PAGE = "BUSINESSORDER.query_page";

    private static final String COST_AND_PROFIT="BUSINESSORDER.COST-AND-PROFIT";

    private static final String PROFIT_STATISTICS="BUSINESSORDER.PROFIT-STATISTICS";

    public static final String COUNT_COST_AND_PROFIT = "BUSINESSORDER.COUNT-COST-AND-PROFIT";

    public static final String COUNT_PROFIT_STATISTICS="BUSINESSORDER.COUNT-PROFIT-STATISTICS";

    public static final String GET_BY_BUSINESS_ID="BUSINESSORDER.getByBusinessId";

    public  static final String GET_SALESMAN_DEPT_CODE = "BUSINESSORDER.getSalesmanDeptCode";
    @Override
    public String getOrderIdByBusinessId(String businessId) {
        try {
            return (String)this.queryForObject(GET_BY_BUSINESS_ID,businessId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getSalesManDeptCode(String orderId) {
        try {
            return (String)this.queryForObject(GET_SALESMAN_DEPT_CODE,orderId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count(QueryBusinessOrder queryBusinessOrder) {
        try {
            return (Integer)this.queryForObject(COUNT,queryBusinessOrder);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override

    public List<BusinessOrder> getOrderLisPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return this.queryForList(QUERY_PAGE,queryBusinessOrder);
    }

    @Override
    public List<CostAndProfitStatistics> getCostAndProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics) {
        return this.queryForList(COST_AND_PROFIT,costAndProfitStatistics);
    }

    @Override
    public int countCostAndProfit(CostAndProfitStatistics costAndProfitStatistics) {
        return (Integer) this.queryForObject(COUNT_COST_AND_PROFIT,costAndProfitStatistics);
    }

    @Override
    public List<CostAndProfitStatistics> getProfitStatisticsByPage(CostAndProfitStatistics costAndProfitStatistics) {
        return this.queryForList(PROFIT_STATISTICS,costAndProfitStatistics);
    }

    @Override
    public int countProfitStatistics(CostAndProfitStatistics costAndProfitStatistics) {
        return (Integer) this.queryForObject(COUNT_PROFIT_STATISTICS,costAndProfitStatistics);
    }

    @Override
    public BusinessOrder addBusinessOrder(BusinessOrder businessOrder) {
        return (BusinessOrder) this.insert(ADD,businessOrder);
    }

    @Override
    public int updateBusinessOrderByOrderId(BusinessOrder businessOrder) {
        return this.update(UPDATE_BY_ORDERID,businessOrder);
    }

    @Override
    public int deleteBusinessOrderByOrderId(String orderId) {
        return 0;
    }

    @Override
    public int updateOfferStatus(BusinessOrder businessOrder) {
        return this.update(UPDATE_OFFER_STATUS,businessOrder);
    }

    @Override
    public BusinessOrder getBusinessOrderByOrderId(String orderId) {
        return (BusinessOrder) this.queryForObject(GET_BY_ID,orderId);
    }

    @Override
    public List<QueryBusinessOrder> getOfferListPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return this.queryForList(OFFER_GET_PAGE,queryBusinessOrder);
    }

    @Override
    public int countOffer(QueryBusinessOrder queryBusinessOrder) {
        return ((Integer)(this.queryForObject(COUNT_OFFER,queryBusinessOrder))).intValue();
    }

    @Override
    public int countOrder(QueryBusinessOrder queryBusinessOrder) {
        return ((Integer) (this.queryForObject(COUNT_ORDER,queryBusinessOrder))).intValue();
    }

    @Override

    public List<QueryBusinessOrder> getOrderListPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return this.queryForList(ORDER_GET_PAGE,queryBusinessOrder);
    }

    @Override
    public BusinessOrder getById(String orderId) {
        return (BusinessOrder)this.queryForObject(GET_BY_ID,orderId);
    }
}
