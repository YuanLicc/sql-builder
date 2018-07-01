package com.yl.sql.imp;

import com.yl.sql.*;
import com.yl.sql.type.JoinType;

public class WhereSqlImp implements WhereSql {

    @Override
    public JoinTableSql join(String table, JoinType joinType) {
        return null;
    }

    @Override
    public SelectSql union() {
        return null;
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public GroupBySql groupBy(String[]... tablesAndColumns) {
        return null;
    }

    @Override
    public LimitSql limit(int start, int count) {
        return null;
    }

    @Override
    public OrderBySql orderBy(String[]... tablesColumns) {
        return null;
    }
}
