package com.yl.sql.imp;

import com.yl.sql.AliasColumnSql;
import com.yl.sql.FromTablesSql;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.util.ArrayUtil;

public class AliasColumnSqlImp implements AliasColumnSql {

    private String[] columns;
    private String[] alias;


    public AliasColumnSqlImp(String[] columns, String[] alias) {

        if(ArrayUtil.isExistEmpty(columns, alias)) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns, alias, tables not null\n" +
                    "2. the length of columns, alias, tables not be 0");
        }
        else if(columns.length != alias.length){
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == alias.length");
        }
        this.columns = columns;
        this.alias = alias;
    }


    @Override
    public FromTablesSql from(String... tables) {

        return new FromTableSqlImp(this.columns, this.columns, tables);
    }

}
