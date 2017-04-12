package com.fuhuadata.vo;

import java.io.Serializable;

/**
 * 装箱要求对象实体
 * Created by hexingfu on 2017/4/12.
 */
public class PackingRequireVo implements Serializable {
    //打托（缠膜）0:不需要 1:免蒸熏托盘 2:蒸熏托盘 3:塑料托盘 4:订制托盘
    private Integer tray;
    //帖唛 0不需要 1：需要
    private Integer postLabel;
    //垫板
    private Integer basePlate;
    //纸板
    private Integer paperBoard;
    //气囊
    private Integer gasbag;
    //拉网
    private Integer dragNet;
    //紧固带
    private Integer fastenBelt;
    //抄条码
    private Integer barcCode;
    //美式门封
    private Integer americanDoorseal;
    //护条
    private Integer  bead;
    //护角
    private Integer cornerProtection;
    //是否需要监装  0：不需要 1：商检 2：法检
    private Integer  inspectionOfLoading;
    //监装机构
    private String inspectionInstitution;
    //吨桶是否铁丝固定
    private Integer wireFixed;

    public Integer getTray() {
        return tray;
    }

    public void setTray(Integer tray) {
        this.tray = tray;
    }

    public Integer getPostLabel() {
        return postLabel;
    }

    public void setPostLabel(Integer postLabel) {
        this.postLabel = postLabel;
    }

    public Integer getBasePlate() {
        return basePlate;
    }

    public void setBasePlate(Integer basePlate) {
        this.basePlate = basePlate;
    }

    public Integer getPaperBoard() {
        return paperBoard;
    }

    public void setPaperBoard(Integer paperBoard) {
        this.paperBoard = paperBoard;
    }

    public Integer getGasbag() {
        return gasbag;
    }

    public void setGasbag(Integer gasbag) {
        this.gasbag = gasbag;
    }

    public Integer getDragNet() {
        return dragNet;
    }

    public void setDragNet(Integer dragNet) {
        this.dragNet = dragNet;
    }

    public Integer getFastenBelt() {
        return fastenBelt;
    }

    public void setFastenBelt(Integer fastenBelt) {
        this.fastenBelt = fastenBelt;
    }

    public Integer getBarcCode() {
        return barcCode;
    }

    public void setBarcCode(Integer barcCode) {
        this.barcCode = barcCode;
    }

    public Integer getAmericanDoorseal() {
        return americanDoorseal;
    }

    public void setAmericanDoorseal(Integer americanDoorseal) {
        this.americanDoorseal = americanDoorseal;
    }

    public Integer getBead() {
        return bead;
    }

    public void setBead(Integer bead) {
        this.bead = bead;
    }

    public Integer getCornerProtection() {
        return cornerProtection;
    }

    public void setCornerProtection(Integer cornerProtection) {
        this.cornerProtection = cornerProtection;
    }

    public Integer getInspectionOfLoading() {
        return inspectionOfLoading;
    }

    public void setInspectionOfLoading(Integer inspectionOfLoading) {
        this.inspectionOfLoading = inspectionOfLoading;
    }

    public String getInspectionInstitution() {
        return inspectionInstitution;
    }

    public void setInspectionInstitution(String inspectionInstitution) {
        this.inspectionInstitution = inspectionInstitution;
    }

    public Integer getWireFixed() {
        return wireFixed;
    }

    public void setWireFixed(Integer wireFixed) {
        this.wireFixed = wireFixed;
    }
}
