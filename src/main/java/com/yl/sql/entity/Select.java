package com.yl.sql.entity;

import com.yl.sql.type.JoinType;

import java.io.Serializable;
import java.util.function.Supplier;

public class Select implements Serializable, Supplier<String> {
    private String[][] columns;
    private String[][] alias;

    private String[] fromTables;
    private Select fromClause;

    private Join[] joins;

    private String[][] groups;

    private String[][] orders;

    private int limitStart;
    private int limitCount;

    @Override
    public String get() {
        return null;
    }

    public class Join implements Supplier<String> {
        private JoinType joinType;
        private String joinTable;
        private String[] judgementsConnectors;
        private Judgement[] judgement;

        @Override
        public String get() {
            return null;
        }
    }

    public class Judgement implements Supplier<String>{
        String leftTable, leftColumn, rightTable, rightColumn;
        Select leftClause, rightClause;

        @Override
        public String get() {
            return null;
        }
    }

}
