package com.yl.sql.entity;

import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.type.AndOrType;
import com.yl.sql.type.JoinType;
import com.yl.sql.type.WhereType;
import com.yl.sql.util.SqlUtil;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 * Select Sql statement (contains : clause)
 * @author YuanLi
 */
public class Select implements Serializable, Supplier<String> {

    private Table table;

    private Where where;

    private Join[] joins;

    private String[][] groups;

    private String[][] orders;

    private int limitStart;
    private int limitCount;

    private int type = 0;

    public Select(Table table) {
        this.table = table;

        this.type = 1;
    }

    public Select(Table table, String[][] orders) {
        this.table = table;
        this.orders = orders;

        this.type = 2;
    }

    public Select(Table table, String[][] orders, int limitStart, int limitCount) {
        this.table = table;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 3;
    }

    public Select(Table table, Join[] joins) {
        this.table = table;
        this.joins = joins;

        this.type = 4;
    }

    public Select(Table table, Join[] joins, String[][] groups) {
        this.table = table;
        this.joins = joins;
        this.groups = groups;

        this.type = 5;
    }

    public Select(Table table, Join[] joins, String[][] groups, String[][] orders) {
        this.table = table;
        this.joins = joins;
        this.groups = groups;
        this.orders = orders;

        this.type = 6;
    }

    public Select(Table table, Join[] joins, String[][] groups, String[][] orders, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.groups = groups;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 7;
    }

    public Select(Table table, Join[] joins, String[][] groups, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.groups = groups;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 8;
    }

    public Select(Table table, String[][] orders, Join[] joins) {
        this.table = table;
        this.joins = joins;
        this.orders = orders;

        this.type = 9;
    }

    public Select(Table table, String[][] orders, Join[] joins, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 10;
    }

    public Select(Table table, Join[] joins, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 11;
    }

    public Select(Table table, Join[] joins, Where where) {
        this.table = table;
        this.joins = joins;
        this.where = where;

        this.type = 12;
    }

    public Select(Table table, Join[] joins, Where where, String[][] groups) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.groups = groups;

        this.type = 13;
    }

    public Select(Table table, Join[] joins, Where where, String[][] groups, String[][] orders) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.groups = groups;
        this.orders = orders;

        this.type = 14;
    }

    public Select(Table table, Join[] joins, Where where, String[][] groups, String[][] orders, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.groups = groups;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 15;
    }

    public Select(Table table, Join[] joins, Where where, String[][] groups, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.groups = groups;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 16;
    }

    public Select(Table table, Join[] joins, String[][] orders, Where where) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.orders = orders;

        this.type = 17;
    }

    public Select(Table table, Join[] joins, String[][] orders, Where where, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 18;
    }

    public Select(Table table, Join[] joins, Where where, int limitStart, int limitCount) {
        this.table = table;
        this.joins = joins;
        this.where = where;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 19;
    }

    public Select(Table table, int limitStart, int limitCount) {
        this.table = table;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 20;
    }

    public Select(String[][] groups, Table table) {
        this.table = table;
        this.groups = groups;

        this.type = 21;
    }

    public Select(String[][] groups, Table table, String[][] orders) {
        this.table = table;
        this.groups = groups;
        this.orders = orders;

        this.type = 22;
    }

    public Select(String[][] groups, Table table, String[][] orders, int limitStart, int limitCount) {
        this.table = table;
        this.groups = groups;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 23;
    }

    public Select(String[][] groups, Table table, int limitStart, int limitCount) {
        this.table = table;
        this.groups = groups;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 24;
    }

    public Select(Table table, Where where) {
        this.table = table;
        this.where = where;

        this.type = 25;
    }

    public Select(Table table, Where where, String[][] groups) {
        this.table = table;
        this.where = where;
        this.groups = groups;

        this.type = 26;
    }

    public Select(Table table, Where where, String[][] groups, String[][] orders) {
        this.table = table;
        this.where = where;
        this.groups = groups;
        this.orders = orders;

        this.type = 27;
    }

    public Select(Table table, Where where, String[][] groups, String[][] orders, int limitStart, int limitCount) {
        this.table = table;
        this.where = where;
        this.groups = groups;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 28;
    }

    public Select(Table table, Where where, String[][] groups, int limitStart, int limitCount) {
        this.table = table;
        this.where = where;
        this.groups = groups;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 29;
    }

    public Select(Table table, String[][] orders, Where where) {
        this.table = table;
        this.where = where;
        this.orders = orders;

        this.type = 30;
    }

    public Select(Table table, String[][] orders, Where where, int limitStart, int limitCount) {
        this.table = table;
        this.where = where;
        this.orders = orders;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 31;
    }

    public Select(Table table, Where where, int limitStart, int limitCount) {
        this.table = table;
        this.where = where;
        this.limitStart = limitStart;
        this.limitCount = limitCount;

        this.type = 32;
    }

    private String selectTypeThirtyTwo() {
        return selectTypeTwentyFive() + limitSql();
    }

    private String selectTypeThirtyOne() {
        return selectTypeThirty() + limitSql();
    }

    private String selectTypeThirty() {
        return selectTypeTwentyFive() + ordersSql();
    }

    private String selectTypeTwentyNine() {
        return selectTypeTwentySix() + limitSql();
    }

    private String selectTypeTwentyEight() {
        return selectTypeTwentySeven() + limitSql();
    }

    private String selectTypeTwentySeven() {
        return selectTypeTwentySix() + ordersSql();
    }

    private String selectTypeTwentySix() {
        return selectTypeTwentyFive() + groupsSql();
    }

    private String selectTypeTwentyFive() {
        return table.get() + where.get();
    }

    private String selectTypeTwentyFour() {
        return selectTypeTwentyOne() + limitSql();
    }

    private String selectTypeTwentyThree() {
        return selectTypeTwentyTwo() + limitSql();
    }

    private String selectTypeTwentyTwo() {
        return selectTypeTwentyOne() + ordersSql();
    }

    private String selectTypeTwentyOne() {
        return table.get() + groupsSql();
    }

    private String selectTypeTwenty() {
        return table.get() + limitSql();
    }

    private String selectTypeNineteen() {
        return selectTypeTwelve() + limitSql();
    }

    private String selectTypeEighteen() {
        return selectTypeSeventeen() + limitSql();
    }

    private String selectTypeSeventeen() {
        return selectTypeTwelve() + ordersSql();
    }

    private String selectTypeSixteen() {
        return selectTypeThirteen() + limitSql();
    }

    private String selectTypeFifteen() {
        return selectTypeFourteen() + limitSql();
    }

    private String selectTypeFourteen() {
        return selectTypeThirteen() + ordersSql();
    }

    private String selectTypeThirteen() {
        return selectTypeTwelve() + groupsSql();
    }

    private String selectTypeTwelve() {
        return selectTypeFour() + whereSql();
    }

    private String selectTypeEleven() {
        return selectTypeFour() + limitSql();
    }

    private String selectTypeTen() {
        return selectTypeNine() + limitSql();
    }

    private String selectTypeNine() {
        return selectTypeFour() + ordersSql();
    }

    private String selectTypeEight() {
        return selectTypeFive() + limitSql();
    }

    private String selectTypeSeven() {
        return selectTypeSix() + limitSql();
    }

    private String selectTypeSix() {
        return selectTypeFive() + ordersSql();
    }

    private String selectTypeFive() {
        return selectTypeFour() + groupsSql();
    }

    private String selectTypeFour() {
        return selectTypeOne() + joinsSql();
    }

    private String selectTypeThree() {
        return selectTypeTwo() + limitSql();
    }

    private String selectTypeTwo() {
        return selectTypeOne() + ordersSql();
    }

    private String selectTypeOne() {
        return SqlUtil.SELECT + SqlUtil.SPACE + this.table.get();
    }

    private String whereSql() {
        return where.get() + SqlUtil.SPACE;
    }

    private String joinsSql() {
        return SqlUtil.joinsToSql(joins) + SqlUtil.SPACE;
    }

    private String groupsSql() {
        return SqlUtil.GROUP_BY +
                SqlUtil.SPACE + SqlUtil.tablesAndColumnsToSql(groups) + SqlUtil.SPACE;
    }

    private String limitSql() {
        return SqlUtil.LIMIT + SqlUtil.SPACE +
                this.limitStart + SqlUtil.COMMA + SqlUtil.SPACE +
                this.limitCount + SqlUtil.SPACE;
    }

    private String ordersSql() {
        return SqlUtil.ORDER_BY +
                SqlUtil.SPACE + SqlUtil.tablesAndColumnsToSql(orders) + SqlUtil.SPACE;
    }

    @Override
    public String get() {
        switch (type) {
            case 1 : selectTypeOne();
            case 2 : selectTypeTwo();
            case 3 : selectTypeThree();
            case 4 : selectTypeFour();
            case 5 : selectTypeFive();
            case 6 : selectTypeSix();
            case 7 : selectTypeSeven();
            case 8 : selectTypeEight();
            case 9 : selectTypeNine();
            case 10 : selectTypeTen();
            case 11 : selectTypeEleven();
            case 12 : selectTypeTwelve();
            case 13 : selectTypeThirteen();
            case 14 : selectTypeFourteen();
            case 15 : selectTypeFifteen();
            case 16 : selectTypeSixteen();
            case 17 : selectTypeSeventeen();
            case 18 : selectTypeEighteen();
            case 19 : selectTypeNineteen();
            case 20 : selectTypeTwenty();
            case 21 : selectTypeTwentyOne();
            case 22 : selectTypeTwentyTwo();
            case 23 : selectTypeTwentyThree();
            case 24 : selectTypeTwentyFour();
            case 25 : selectTypeTwentyFive();
            case 26 : selectTypeTwentySix();
            case 27 : selectTypeTwentySeven();
            case 28 : selectTypeTwentyEight();
            case 29 : selectTypeTwentyNine();
            case 30 : selectTypeThirty();
            case 31 : selectTypeThirtyOne();
            case 32 : selectTypeThirtyTwo();
            default : {
                throw new ParameterNotMatchException("Error type");
            }
        }
    }

    public class Table implements Supplier<String> {

        private Columns[] tablesColumns;
        private String[] tablesNames;
        private String[] tablesAlias;

        private Select[] clause;
        private String[] clauseAlias;

        private int type = 0;

        public Table(Columns[] tablesColumns, String[] tablesNames) {
            this.tablesColumns = tablesColumns;
            this.tablesNames = tablesNames;

            this.type = 1;
        }

        public Table(Columns[] tablesColumns, String[] tablesNames, String[] tablesAlias) {
            this.tablesNames = tablesNames;
            this.tablesColumns = tablesColumns;
            this.tablesAlias = tablesAlias;

            this.type = 2;
        }

        public Table(Columns[] tablesColumns, Select[] clause, String[] clauseAlias) {
            this.tablesColumns = tablesColumns;
            this.clause = clause;
            this.clauseAlias = clauseAlias;

            this.type = 3;
        }

        public Table(Columns[] tablesColumns, String[] tablesNames, Select[] clause, String[] clauseAlias) {
            this.tablesColumns = tablesColumns;
            this.tablesNames = tablesNames;
            this.clause = clause;
            this.clauseAlias = clauseAlias;

            this.type = 4;
        }

        public Table(Columns[] tablesColumns, String[] tablesNames, String[] tablesAlias, Select[] clause, String[] clauseAlias) {
            this.tablesNames = tablesNames;
            this.tablesColumns = tablesColumns;
            this.tablesAlias = tablesAlias;
            this.clause = clause;
            this.clauseAlias = clauseAlias;

            this.type = 5;
        }

        private String tableTypeOne() {
            return SqlUtil.getSqlColumnsTablesNames(tablesColumns, tablesNames);
        }

        private String tableTypeTwo() {
            return SqlUtil.getSqlColumnsTablesNamesTablesAlias(tablesColumns, tablesNames, tablesAlias);
        }

        private String tableTypeThree() {
            return SqlUtil.getSqlColumnsClausesClausesAlias(tablesColumns, clause, clauseAlias);
        }

        private String tableTypeFour() {
            return SqlUtil.getSqlColumnsTablesNameClausesAlias(tablesColumns, tablesNames, clause, clauseAlias);
        }

        private String tableTypeFive() {
            return SqlUtil.getSqlColumnsTablesNameAliasClausesAlias(tablesColumns, tablesNames, tablesAlias, clause, clauseAlias);
        }

        @Override
        public String get() {
            return null;
        }
    }

    public class Columns implements Supplier<String> {

        private String[] columns;
        private String[] alias;
        private String tableOrAlias;

        private int type = 0;

        public Columns(String[] columns, String tableOrAlias) {
            this.columns = columns;
            this.tableOrAlias = tableOrAlias;

            this.type = 1;
        }

        public Columns(String[] columns, String[] alias, String tableOrAlias) {
            this.columns = columns;
            this.alias = alias;
            this.tableOrAlias = tableOrAlias;

            this.type = 2;
        }

        public Columns(String[] columns) {
            this.columns = columns;

            this.type = 3;
        }

        private String columnTypeOne() {
            return SqlUtil.getSqlColumnsTableOrAlias(this.columns, this.tableOrAlias);
        }

        private String columnTypeTwo() {
            return SqlUtil.getSqlColumnsAliasTableOrAlias(this.columns, this.alias, this.tableOrAlias);
        }

        private String columnTypeThree() {
            return SqlUtil.getSqlColumns(columns);
        }

        @Override
        public String get() {
            switch (type) {
                case 1 : columnTypeOne();
                case 2 : columnTypeTwo();
                case 3 : columnTypeThree();
                default: {
                    throw new ParameterNotMatchException("error type!");
                }
            }
        }
    }

    public class Where implements Supplier<String> {
        private AndOrType[] connectors;
        private Judgement[] judgements;

        public Where(AndOrType[] connectors, Judgement[] judgements) {
            this.connectors = connectors;
            this.judgements = judgements;
        }

        @Override
        public String get() {
            return SqlUtil.WHERE + SqlUtil.SPACE +
                    SqlUtil.judgementCombineConnector(this.connectors, this.judgements);
        }
    }

    /**
     * join statement (example : left join user on user.id = 1 and user.id = 2)
     * @author YuanLi
     */
    public class Join implements Supplier<String> {
        private JoinType joinType;
        private String joinTable;
        private AndOrType[] connectors;
        private Judgement[] judgements;

        public Join(JoinType joinType, String joinTable, AndOrType[] connectors, Judgement[] judgements) {
            this.joinType = joinType;
            this.joinTable = joinTable;
            this.connectors = connectors;
            this.judgements = judgements;
        }

        @Override
        public String get() {
            String sql = this.joinType + SqlUtil.SPACE + joinTable + SqlUtil.SPACE;

            return sql + SqlUtil.judgementCombineConnector(this.connectors, this.judgements);
        }
    }

    /**
     * judgement class (example : 1 > 1)
     * @author YuanLi
     */
    public class Judgement implements Supplier<String> {
        private String leftTable, leftColumn, rightTable, rightColumn;
        private WhereType connector;
        private Select leftClause, rightClause;

        private int type = 1;

        /**
         * constructor of judgement (example : user.id = role.userId)
         * @param leftTable [leftTable].id = role.userId
         * @param leftColumn user.[leftColumn] = role.userId
         * @param rightTable user.id = [rightTable].userId
         * @param rightColumn user.id = role.[rightColumn]
         * @param connector user.id [connector] role.userId
         */
        public Judgement(String leftTable, String leftColumn, String rightTable, String rightColumn, WhereType connector) {
            this.leftTable = leftTable;
            this.leftColumn = leftColumn;
            this.rightTable = rightTable;
            this.rightColumn = rightColumn;

            this.connector = connector;

            this.type = 1;
        }

        /**
         * constructor of judgement (example : (select id from user where id = 1) < (select id from user where user.id = 2) )
         * @param leftClause [leftClause] < (select id from user where user.id = 2)
         * @param rightClause (select id from user where id = 1) < [rightClause]
         * @param connector (select id from user where id = 1) [connector] (select id from user where user.id = 2)
         */
        public Judgement(Select leftClause, Select rightClause, WhereType connector) {
            this.leftClause = leftClause;
            this.rightClause = rightClause;

            this.connector = connector;

            this.type = 2;
        }

        /**
         * constructor of judgement (example : user.id < (select id from user where user.id = 2) )
         * @param leftTable [leftTable].id < (select id from user where user.id = 2)
         * @param leftColumn user.[leftColumn] < (select id from user where user.id = 2)
         * @param rightClause user.id < [rightClause]
         * @param connector user.id [connector] (select id from user where user.id = 2)
         */
        public Judgement(String leftTable, String leftColumn, Select rightClause, WhereType connector) {
            this.leftTable = leftTable;
            this.leftColumn = leftColumn;
            this.rightClause = rightClause;
            this.connector = connector;

            this.type = 3;
        }

        /**
         * constructor of judgement (example : (select id from user where user.id = 2) = user.id )
         * @param leftClause [leftClause] = user.id
         * @param rightTable (select id from user where user.id = 2) = [rightTable].id
         * @param rightColumn (select id from user where user.id = 2) = user.[rightColumn]
         * @param connector (select id from user where user.id = 2) [connector] user.id
         */
        public Judgement(Select leftClause, String rightTable, String rightColumn, WhereType connector) {
            this.leftClause = leftClause;
            this.rightTable = rightTable;
            this.rightColumn = rightColumn;

            this.connector = connector;

            this.type = 4;
        }

        /**
         * constructor of judgement (example : 3 = user.id )
         * @param leftValue [leftValue] = user.id
         * @param rightTable 3 = [rightTable].id
         * @param rightColumn 3 = user.[rightColumn]
         * @param connector 3 [connector] user.id
         */
        public Judgement(String leftValue, String rightTable, String rightColumn, WhereType connector) {
            this.leftColumn = leftValue;
            this.rightTable = rightTable;
            this.rightColumn = rightColumn;
            this.connector = connector;

            this.type = 5;
        }

        /**
         * constructor of judgement (example : user.id = 3 )
         * @param connector user.id [connector] 3
         * @param leftTable [leftTable].id = 3
         * @param LeftColumn user.[leftColumn] = 3
         * @param rightValue user.id = [rightValue]
         */
        public Judgement(WhereType connector, String leftTable, String LeftColumn, String rightValue) {
            this.rightColumn = rightValue;
            this.leftTable = leftTable;
            this.leftColumn = LeftColumn;

            this.connector = connector;

            this.type = 6;
        }

        /**
         * constructor of judgement (example : 3 = (select id from user where id = 3) )
         * @param leftValue [leftValue] = (select id from user where id = 3)
         * @param rightClause 3 = [rightClause]
         * @param connector 3 [connector] (select id from user where id = 3)
         */
        public Judgement(String leftValue, Select rightClause, WhereType connector) {
            this.leftColumn = leftValue;
            this.rightClause = rightClause;
            this.connector = connector;

            this.type = 7;
        }

        /**
         * constructor of judgement (example : (select id from user where id = 3) = 3 )
         * @param leftClause [leftClause] = 3
         * @param rightValue (select id from user where id = 3) = [rightValue]
         * @param connector (select id from user where id = 3) [connector] 3
         */
        public Judgement(Select leftClause, String rightValue, WhereType connector) {
            this.leftClause = leftClause;
            this.rightColumn = rightValue;
            this.connector = connector;

            this.type = 8;
        }

        @Override
        public String get() {
            switch (type) {
                case 1 : return getSqlTyeOne();
                case 2 : return getSqlTyeTwo();
                case 3 : return getSqlTyeThree();
                case 4 : return getSqlTyeFour();
                case 5 : return getSqlTyeFive();
                case 6 : return getSqlTyeSix();
                case 7 : return getSqlTyeSeven();
                case 8 : return getSqlTyeEight();
                default : {
                    throw new ParameterNotMatchException("error");
                }
            }
        }

        /**
         * String leftTable, String leftColumn, String rightTable, String rightColumn, WhereType connector
         * @return String
         */
        private String getSqlTyeOne() {
            return this.leftTable + SqlUtil.SPOT + this.leftColumn + SqlUtil.SPACE +
                    this.connector + SqlUtil.SPACE + SqlUtil.SINGLE_QUOTE +
                    this.rightTable + SqlUtil.SPOT + this.rightColumn + SqlUtil.SINGLE_QUOTE + SqlUtil.SPACE;
        }

        /**
         * Select leftClause, Select rightClause, WhereType connector
         * @return String
         */
        private String getSqlTyeTwo() {
            String leftSql = SqlUtil.LEFT_BRACKET + leftClause.get() + SqlUtil.RIGHT_BRACKET + SqlUtil.SPACE;
            String rightSql = SqlUtil.LEFT_BRACKET + rightClause.get() + SqlUtil.RIGHT_BRACKET + SqlUtil.SPACE;

            return leftSql + SqlUtil.SPACE + this.connector.sign() + SqlUtil.SPACE + rightSql + SqlUtil.SPACE;
        }

        /**
         * String leftTable, String leftColumn, Select rightClause, WhereType connector
         * @return String
         */
        private String getSqlTyeThree() {
            String rightSql = SqlUtil.LEFT_BRACKET + rightClause.get() + SqlUtil.RIGHT_BRACKET + SqlUtil.SPACE;

            return this.leftTable + SqlUtil.SPOT + this.leftColumn + SqlUtil.SPACE +
                    this.connector.sign() + SqlUtil.SPACE + rightSql;
        }


        /**
         * Select leftClause, String rightTable, String rightColumn, WhereType connector
         * @return String
         */
        private String getSqlTyeFour() {
            String leftSql = SqlUtil.LEFT_BRACKET + leftClause.get() +
                    SqlUtil.RIGHT_BRACKET + SqlUtil.SPACE;

            return leftSql + this.connector.sign() + SqlUtil.SPACE +
                    this.rightTable + SqlUtil.SPOT + this.rightColumn + SqlUtil.SPACE;
        }

        /**
         * String leftValue, String rightTable, String rightColumn, WhereType connector
         * @return String
         */
        private String getSqlTyeFive() {

            return this.leftColumn + SqlUtil.SPACE + this.connector.sign() + SqlUtil.SPACE +
                    this.rightTable + SqlUtil.SPOT + this.rightColumn + SqlUtil.SPACE;
        }

        /**
         * WhereType connector, String LeftTable, String LeftColumn, String rightValue
         * @return String
         */
        private String getSqlTyeSix() {
            return this.leftTable + SqlUtil.SPOT + leftColumn + SqlUtil.SPACE +
                    connector.sign() + SqlUtil.SPACE + rightColumn + SqlUtil.SPACE;
        }

        /**
         * String leftValue, Select rightClause, WhereType connector
         * @return String
         */
        private String getSqlTyeSeven() {
            String rightSql = SqlUtil.LEFT_BRACKET + rightClause.get() + SqlUtil.RIGHT_BRACKET + SqlUtil.SPACE;
            return leftColumn + SqlUtil.SPACE + this.connector.sign() + SqlUtil.SPACE +
                    rightSql + SqlUtil.SPACE;
        }

        /**
         * Select leftClause, String rightValue, WhereType connector
         * @return String
         */
        private String getSqlTyeEight() {
            String leftSql = SqlUtil.LEFT_BRACKET + leftClause.get() + SqlUtil.RIGHT_BRACKET + SqlUtil.SPACE;
            return leftSql + SqlUtil.SPACE + connector.sign() + SqlUtil.SPACE + rightColumn + SqlUtil.SPACE;
        }
    }

}
