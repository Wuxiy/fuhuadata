package com.fuhuadata.domain.query;

/**
 * @author wangbo
 * @date 2017-01-17 14:24:28
 */
public class QueryFreightforwardingWarehouseRelation extends PageBase {

    /****/
	private Integer id;
	
    /**货代id**/
	private String freightforwardingId;
	
    /**仓库id**/
	private String warehouseId;
	

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFreightforwardingId() {
		return freightforwardingId;
	}
	
	public void setFreightforwardingId(String freightforwardingId) {
		this.freightforwardingId = freightforwardingId;
	}
	
	public String getWarehouseId() {
		return warehouseId;
	}
	
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	

}