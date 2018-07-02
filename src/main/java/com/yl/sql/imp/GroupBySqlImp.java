package com.yl.sql.imp;

import com.yl.sql.GroupBySql;
import com.yl.sql.LimitSql;
import com.yl.sql.OrderBySql;
import com.yl.sql.SelectSql;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.util.ArrayUtil;
import com.yl.sql.util.SqlUtil;

public class GroupBySqlImp implements GroupBySql {

    private String[][] columns, alias, groupTablesAndColumns;
    private String[] fromTables;

    public GroupBySqlImp(String[][] columns, String[][] alias, String[] fromTables, String[][] groupTablesAndColumns) {
        if(ArrayUtil.isExistEmpty(groupTablesAndColumns)) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. groupTablesAndColumns != null && groupTablesAndColumns.length != 0\n" +
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
        if(columns != null && alias != null && fromTables != null && groupTablesAndColumns != null) {
            return SqlUtil.groupByAliasSql(columns, alias, fromTables, groupTablesAndColumns);
        }
        else if(columns != null && fromTables != null && groupTablesAndColumns != null) {
            return SqlUtil.groupBySql(columns, fromTables, groupTablesAndColumns);
        }
        else if(columns != null && fromTables != null) {
            return SqlUtil.simpleSql(columns, fromTables);
        }
        else {
            throw new ParameterNotMatchException("The parameters can not combine a statement");
        }
    }

}
