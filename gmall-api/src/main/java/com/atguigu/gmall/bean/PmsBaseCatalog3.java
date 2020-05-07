package com.atguigu.gmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * ClassName :PmsBaseCatalog3
 * Package :com.atguigu.gmall.bean
 * Description :
 *
 * @author :张哈哈
 * @date :2020/4/17 14:24
 */
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private String id;
    private String name;
    private String catalog2Id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(String catalog2Id) {
        this.catalog2Id = catalog2Id;
    }
}
