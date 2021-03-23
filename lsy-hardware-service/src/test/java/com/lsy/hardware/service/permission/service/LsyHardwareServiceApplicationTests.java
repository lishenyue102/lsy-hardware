package com.lsy.hardware.service.permission.service;

import com.lsy.hardware.service.entity.EsProduct;
import com.lsy.hardware.service.entity.EsProductAttributeValue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
class LsyHardwareServiceApplicationTests {

    @Resource
    private ElasticsearchOperations elasticsearchOperations;

    /**
     * elasticsearchOperations.indexOps  返回一个该类的索引操作对象
     * indexOperations.exists() 判断索引是否存在
     * indexOperations.getSettings() 获取该索引配置
     * IndexOperations.refresh() 刷新索引
     */
    @Test
    public void testEsProductMapping() {
        // indexOps返回一个该类的索引操作对象
        IndexOperations indexOperations = elasticsearchOperations.indexOps(EsProduct.class);
        System.out.println(elasticsearchOperations.stringIdRepresentation("1"));
        // 判断索引是否存在
        if (indexOperations.exists()) {
            System.out.println(indexOperations.exists());

            System.out.println(indexOperations.getSettings());

            return;
        }
        // 创建索引
        boolean isCreated = indexOperations.create();
        System.out.println(isCreated);
        indexOperations.putMapping(indexOperations.createMapping(EsProduct.class));
        Map mapping = indexOperations.getMapping();
        System.out.println(mapping);
    }

    @Test
    public void testEsProductSave() {
        List<EsProductAttributeValue> esProductAttributeValues = new ArrayList<>();
        EsProductAttributeValue esProductAttributeValue = new EsProductAttributeValue();
        esProductAttributeValue.setProductAttributeId("1");
        esProductAttributeValue.setName("主体");
        esProductAttributeValue.setValue("Vostro 14-3400-R1605D");
        esProductAttributeValue.setType("1");

        EsProductAttributeValue esProductAttributeValue1 = new EsProductAttributeValue();
        esProductAttributeValue1.setProductAttributeId("2");
        esProductAttributeValue1.setName("内存");
        esProductAttributeValue1.setValue("2666");
        esProductAttributeValue1.setType("2");
        esProductAttributeValues.add(esProductAttributeValue);
        esProductAttributeValues.add(esProductAttributeValue1);

        EsProduct esProduct = new EsProduct();
        esProduct.setProductId("1");
        esProduct.setProductName("戴尔笔记本");
        esProduct.setProductDesc("戴尔笔记本描述");
        esProduct.setBrandId("0001");
        esProduct.setBrandName("戴尔");
        esProduct.setPrice(5000);
        esProduct.setStatus("1");
        esProduct.setEsProductAttributeValues(esProductAttributeValues);

        EsProduct save = elasticsearchOperations.save(esProduct);
        System.out.println(save);
    }


    @Test
    public void testEsProductDelete() {
        System.out.println(elasticsearchOperations.delete("1", EsProduct.class));
    }

    @Test
    public void testEsProductGet() {
        System.out.println(elasticsearchOperations.get("1", EsProduct.class));
    }

}
