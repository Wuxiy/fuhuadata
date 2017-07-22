package com.fuhuadata.domain.customs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 7/4/2017
 */
public class BarResult {

    /**
     * 分类：按年 or 按月
     */
    private List<String> categories;

    /**
     * 国家 or 公司
     */
    private List<String> legends;

    private ListMultimap<String, Double> data;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getLegends() {
        return legends;
    }

    public void setLegends(List<String> legends) {
        this.legends = legends;
    }

    public ListMultimap<String, Double> getData() {
        return data;
    }

    public void setData(ListMultimap<String, Double> data) {
        this.data = data;
    }

    public ListMultimap<String, Double> initData() {

        if (categories == null || legends == null) {
            return ArrayListMultimap.create();
        }

        List<Double> zeroData = categories.stream()
                .map(s -> 0.0)
                .collect(toList());

        ListMultimap<String, Double> data = ArrayListMultimap.create(legends.size(), categories.size());
        legends.forEach(legend -> data.putAll(legend, zeroData));

        setData(data);
        return getData();
    }

    public static void main(String[] args) throws JsonProcessingException {
        BarResult result = new BarResult();

        List<String> legends = Lists.newArrayList("美国", "澳大利亚");
        List<String> categorys = Lists.newArrayList("2015", "2016");

        result.setLegends(legends);
        result.setCategories(categorys);

        ListMultimap<String, Double> multimap = result.initData();

        multimap.get("美国").set(0, 1000.0);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new GuavaModule());
        System.out.println(objectMapper.writeValueAsString(result));

    }
}
