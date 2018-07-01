package com.yl.sql.imp;

import com.yl.sql.GroupBySql;
import com.yl.sql.LimitSql;
import com.yl.sql.OrderBySql;
import com.yl.sql.SelectSql;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.util.ArrayUtil;

public class GroupBySqlImp implements GroupBySql {

    private String[] columns, alias, fromTables;
    private String[][] groupTablesAndColumns;

    public GroupBySqlImp(String[] columns, String[] alias, String[] fromTables, String[][] groupTablesAndColumns) {
        if(ArrayUtil.isExistEmpty(groupTablesAndColumns)) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. groupTablesAndColumns != null && groupTablesAndColumns.length != 0" +
                    "2. item in groupTablesAndColumns, item != null && item.length == 2");
        }

        this.columns = columns;
        this.alias = alias;
        this.fromTables = fromTables;
        this.groupTablesAndColumns = groupTablesAndColumns;
    }

    @Override
    public LimitSql limit(int start, int count) {
        return null;
    }

    @Override
    public OrderBySql orderBy(String[]... tablesColumns) {
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
}
