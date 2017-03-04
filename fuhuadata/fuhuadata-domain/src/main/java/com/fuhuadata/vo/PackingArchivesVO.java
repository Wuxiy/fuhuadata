package com.fuhuadata.vo;

import com.fuhuadata.domain.PackingArchives;

import java.util.ArrayList;
import java.util.List;

/**
 * 包材成本view
 * Created by intanswer on 2017/3/4.
 */
public class PackingArchivesVO {
    private PackingArchives pack;//主材
    private List<PackingArchives> nodes;//关联包材

    public PackingArchives getPack() {
        return pack;
    }

    public void setPack(PackingArchives pack) {
        this.pack = pack;
    }

    public List<PackingArchives> getNodes() {
        return nodes;
    }

    public void setNodes(List<PackingArchives> nodes) {
        this.nodes = nodes;
    }

    public void addNodes(PackingArchives packingArchives){
        if(this.nodes==null){
            this.nodes=new ArrayList<PackingArchives>();
        }
        this.nodes.add(packingArchives);
    }
}
