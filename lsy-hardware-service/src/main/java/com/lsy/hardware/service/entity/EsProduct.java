package com.lsy.hardware.service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lishenyue Created on 2021/3/23 21:51
 * @version 1.0
 */
@Document(indexName = "es_product")
public class EsProduct implements Serializable {
    private static final long serialVersionUID = 5257371879186399678L;

    /**
     * 商品id
     *
     * Keyword用于精确查询
     */
    @Id
    @Field(type = FieldType.Keyword)
    private String productId;

    /**
     * 商品名
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String productName;

    /**
     * 商品描述
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String productDesc;

    /**
     * 价格
     */
    @Field(type = FieldType.Integer)
    private Integer price;

    /**
     * 品牌ID
     */
    @Field(type = FieldType.Keyword)
    private String brandId;

    /**
     * 品牌名
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 状态
     * 0-无货
     * 1-有货
     */
    @Field(type = FieldType.Keyword)
    private String status;

    @Field(type = FieldType.Nested)
    private List<EsProductAttributeValue> esProductAttributeValues;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(final String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(final String brandName) {
        this.brandName = brandName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(final String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public List<EsProductAttributeValue> getEsProductAttributeValues() {
        return esProductAttributeValues;
    }

    public void setEsProductAttributeValues(final List<EsProductAttributeValue> esProductAttributeValues) {
        this.esProductAttributeValues = esProductAttributeValues;
    }


    @Override
    public String toString() {
        return "EsProduct{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", price=" + price +
                ", brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", status='" + status + '\'' +
                ", esProductAttributeValues=" + esProductAttributeValues +
                '}';
    }
}
