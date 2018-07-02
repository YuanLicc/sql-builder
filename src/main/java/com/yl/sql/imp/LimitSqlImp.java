package com.yl.sql.imp;

import com.yl.sql.LimitSql;
import com.yl.sql.exception.ParameterNotMatchException;

public class LimitSqlImp implements LimitSql {

    private String[][] columns, alias, groups;
    private int start, count;
    private String[] fromTables;

    public LimitSqlImp(String[][] columns, String[][] alias, String[] fromTables
            , String[][] groups, int start, int count) {
        if(start < 1 || count < 1) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. start >= 1 && count >= 1");
        }
        this.columns = columns;
        this.alias = alias;
        this.fromTables = fromTables;
        this.groups = groups;
        this.start = start;
        this.count = count;
    }

    @Override
    public String get() {
        return null;
    }

}
