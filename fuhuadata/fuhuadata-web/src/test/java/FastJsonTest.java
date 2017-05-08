import com.alibaba.fastjson.JSON;
import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;
import com.fuhuadata.domain.mybatis.CustomerPurchaseSupplier;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/5/2017
 */
public class FastJsonTest {

    @Test
    public void testProducts() {

        CustomerPurchaseProduct product = new CustomerPurchaseProduct();
        product.setProductName("95%草甘膦原药");
        product.setCustomerId(12345);
        product.setProductId(82891);
        product.setAnnualDemands("8329");

        List<CustomerPurchaseSupplier> suppliers = Lists.newArrayList();

        CustomerPurchaseSupplier supplier1 = new CustomerPurchaseSupplier();
        supplier1.setPurchaseId(12345);
        supplier1.setName("供应商1");

        CustomerPurchaseSupplier supplier2 = new CustomerPurchaseSupplier();
        supplier2.setPurchaseId(12345);
        supplier2.setName("供应商2");

        suppliers.add(supplier1);
        suppliers.add(supplier2);

        product.setSuppliers(suppliers);

        System.out.println(JSON.toJSONString(product));
    }
}
