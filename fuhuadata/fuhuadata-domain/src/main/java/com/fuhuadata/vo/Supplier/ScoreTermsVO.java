package com.fuhuadata.vo.Supplier;

import com.fuhuadata.domain.mybatis.supplier.EvaluationValue;
import com.fuhuadata.domain.mybatis.supplier.WarehouseEvaluationScoreRelation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiy on 2017/6/8.
 */
public class ScoreTermsVO {
    /**评价项id**/
    private int itemId;
    /**评价项名**/
    private String itemName;
    /**评价项显示顺序id**/
    private int orderId;
    /**父评价项名**/
    private String ItemParentName;
    /**评价项满分值**/
    private BigDecimal itemFullMarks;
    /**评价项显示顺序**/
    private int itemOrder;
//    /**选项id**/
//    private int optionId;
//    /**选项名**/
//    private String optionName;
//    /**选项分值**/
//    private BigDecimal optionValue;
    private List<ScoreTermsVO> nodes;
    private List<EvaluationValue> values;
    /**
     * 添加当前节点的nodes
     * @param scoreTermsVO
     */
    public void addChildNode(ScoreTermsVO scoreTermsVO){
        if(this.nodes == null){
            this.nodes = new ArrayList<ScoreTermsVO>();
        }
        this.nodes.add(scoreTermsVO);
    }

    /**
     * 添加当前节点的评分值
     * @param evaluationValue
     */
    public void addValues(EvaluationValue evaluationValue){
        if(this.values == null){
            this.values = new ArrayList<EvaluationValue>();
        }
        this.values.add(evaluationValue);
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getItemFullMarks() {
        return itemFullMarks;
    }

    public void setItemFullMarks(BigDecimal itemFullMarks) {
        this.itemFullMarks = itemFullMarks;
    }

    public List<ScoreTermsVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<ScoreTermsVO> nodes) {
        this.nodes = nodes;
    }

    public List<EvaluationValue> getValues() {
        return values;
    }

    public void setValues(List<EvaluationValue> values) {
        this.values = values;
    }

    public String getItemParentName() {
        return ItemParentName;
    }

    public void setItemParentName(String itemParentName) {
        ItemParentName = itemParentName;
    }

    public int getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
    }
}
