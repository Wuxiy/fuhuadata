package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.CustomerPurchaseSupplier;
import com.fuhuadata.service.mybatis.CustomerPurchaseSupplierService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
@Service
public class CustomerPurchaseSupplierServiceImpl extends BaseServiceImpl<CustomerPurchaseSupplier, Integer>
        implements CustomerPurchaseSupplierService {

    @Override
    public List<CustomerPurchaseSupplier> listSupplierByProductId(Integer purchaseId) {

        Example example = newExample();
        example.createCriteria().andEqualTo("purchaseId", purchaseId);
        example.orderBy("id ase");

        return listByExample(example);
    }

    @Override
    public int saveOrUpdateSuppliers(List<CustomerPurchaseSupplier> suppliers) {
        if (suppliers == null) {
            return 0;
        }

        int result = 0;
        for (CustomerPurchaseSupplier supplier : suppliers) {
            result += saveOrUpdateSelective(supplier);
        }

        return result;
    }

    @Override
    public int deleteSuppliersByIds(List<Integer> supplierIds) {

        if (supplierIds == null) {
            return 0;
        }

        int result = 0;
        for (Integer id : supplierIds) {
            result += delete(id);
        }

        return result;
    }

    @Override
    public int deleteSuppliersByProductId(Integer productId) {

        Example example = newExample();
        example.createCriteria().andEqualTo("purchaseId", productId);

        return delete(example);
    }
}
