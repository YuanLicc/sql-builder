package com.yl.sql.imp;

import com.yl.sql.GroupBySql;
import com.yl.sql.LimitSql;
import com.yl.sql.OrderBySql;
import com.yl.sql.SelectSql;
import com.yl.sql.entity.Select;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.util.ArrayUtil;

import java.util.List;

public class GroupBySqlImp implements GroupBySql {

    private String[][] columns, alias, groupTablesAndColumns;
    private String[] fromTables;

    public GroupBySqlImp(List<String[]> columnsList, List<String[]> aliasList, String[] fromTables
            , List<Select> clauses, String[][] groupTablesAndColumns) {

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

    public LimitSql limit(int start, int count) {

        return new LimitSqlImp(this.columns, this.alias, this.fromTables
                , this.groupTablesAndColumns, start, count);
    }

    public OrderBySql orderBy(String[]... tablesColumns) {
        return null;
    }

    public SelectSql union() {
        return null;
    }

}
