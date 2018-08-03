package com.yl.sql;

/**
 * SELECT [columns] | distinct [columns]
 * 1. 查找列 - 转换为{@link HasColumnSql}
 * 2. distinct 查找列 - 转换为{@link HasColumnSql}
 * @author YuanLi
 */
public interface SelectSql extends SQL {

}
