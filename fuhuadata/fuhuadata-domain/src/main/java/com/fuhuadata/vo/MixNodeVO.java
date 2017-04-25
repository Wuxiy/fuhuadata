package com.fuhuadata.vo;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
public class MixNodeVO extends BaseTreeVo<String> {

    public MixNodeVO(Integer type) {
        this.type = type;
    }

    private String ncId;

    private Integer type = 3;// 1：组织，2：部门，3：用户

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNcId() {
        return ncId;
    }

    public void setNcId(String ncId) {
        this.ncId = ncId;
    }

    public static MixNodeVO cloneNode(MixNodeVO orgi) {
        if (orgi == null) {
            return null;
        }

        MixNodeVO dest = new MixNodeVO(orgi.getType());
        dest.setCid(orgi.getCid());
        dest.setCname(orgi.getCname());
        dest.setPid(orgi.getPid());
        dest.setIsParent(orgi.getIsParent());
        dest.setOpen(orgi.getOpen());
        dest.setRoot(orgi.isRoot());
        dest.setNcId(orgi.getNcId());

        return dest;
    }
}
