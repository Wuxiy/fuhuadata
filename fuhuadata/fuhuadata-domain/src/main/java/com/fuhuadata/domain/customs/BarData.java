package com.fuhuadata.domain.customs;

/**
 * <p>User: wangjie
 * <p>Date: 7/4/2017
 */
public class BarData {

    private Integer id;

    private String name;

    private Double value;

    private Integer yearFlag;

    private Integer monthFlag;

    public BarData() {
    }

    public BarData(Integer id, String name, Double value, Integer yearFlag, Integer monthFlag) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.yearFlag = yearFlag;
        this.monthFlag = monthFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearFlag() {
        return yearFlag;
    }

    public void setYearFlag(Integer yearFlag) {
        this.yearFlag = yearFlag;
    }

    public Integer getMonthFlag() {
        return monthFlag;
    }

    public void setMonthFlag(Integer monthFlag) {
        this.monthFlag = monthFlag;
    }

    public static class BarDataBuilder {

        private Integer id;
        private String name;
        private Double value;
        private Integer yearFlag;
        private Integer monthFlag;

        public BarDataBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public BarDataBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BarDataBuilder setValue(Double value) {
            this.value = value;
            return this;
        }

        public BarDataBuilder setYearFlag(Integer yearFlag) {
            this.yearFlag = yearFlag;
            return this;
        }

        public BarDataBuilder setMonthFlag(Integer monthFlag) {
            this.monthFlag = monthFlag;
            return this;
        }

        public BarData createBarData() {
            return new BarData(id, name, value, yearFlag, monthFlag);
        }
    }

}
