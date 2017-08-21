/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.sprintdragon.opensource.jpa.jpa.simple;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdEntity {

    protected Long id;

    /**
     * @return
     * @GeneratedValue 生成主键主要是单库
     * <p>
     * TABLE:使用一个特定的数据库表格来保存主键
     * <p>
     * SEQUENCE:根据地层数据库的序列来生成主键，条件是数据库支持序列，主要是Oracle
     * <p>
     * IDENTITY:主键由数据库自动生成(主要是自动增长型)
     * <p>
     * AUTO:主键由程序控制
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
