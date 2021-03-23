package com.lsy.hardware.service.entity;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author lishenyue Created on 2021/3/22 23:09
 * @version 1.0
 */
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = -2367025527755653176L;

    /**
     * 属性ID
     */
    @Field(type = FieldType.Keyword)
    private String productAttributeId;

    /**
     * 属性名
     */
    @Field(type= FieldType.Keyword)
    private String name;

    /**
     * 属性值
     */
    @Field(type = FieldType.Keyword)
    private String value;

    /**
     * 属性类型
     * 1-规格
     * 2-参数
     */
    @Field(type = FieldType.Keyword)
    private String type;

    public String getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(final String productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EsProductAttributeValue{" +
                "productAttributeId='" + productAttributeId + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
