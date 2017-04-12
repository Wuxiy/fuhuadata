package com.fuhuadata.vo;

import java.io.Serializable;

/**
 * 装箱要求对象实体
 * Created by hexingfu on 2017/4/12.
 */
public class PackingRequireVo implements Serializable {
    //打托（缠膜） 1:免蒸熏托盘 2:蒸熏托盘 3:塑料托盘 4:订制托盘
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
   /* private Integer ordinary American*/


}
