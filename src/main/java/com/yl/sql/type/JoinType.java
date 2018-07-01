package com.yl.sql.type;

public enum JoinType {

    leftJoin {
        @Override
        String sign() {
            return "LEFT JOIN";
        }
    },
    rightJoin {
        @Override
        String sign() {
            return "RIGHT JOIN";
        }
    },
    innerJoin {
        @Override
        String sign() {
            return "INNER JOIN";
        }
    },
    join {
        @Override
        String sign() {
            return "JOIN";
        }
    },
    fullJoin {
        @Override
        String sign() {
            return "FULL JOIN";
        }
    };

    abstract String sign();

}
