package com.yl.sql.type;

public enum WhereType {
    equal {
        public String sign() {
            return "=";
        }
    },
    like {
        public String sign() {
            return "LIKE";
        }
    },
    greaterThan {
        public String sign() {
            return ">";
        }
    },
    lessThan {
        public String sign() {
            return "<";
        }
    },
    lessEqual {
        public String sign() {
            return "<=";
        }
    },
    greaterEqual {
        public String sign() {
            return ">=";
        }
    },
    in {
        @Override
        public String sign() {
            return "IN";
        }
    },
    notIn {
        @Override
        public String sign() {
            return "NOT IN";
        }
    };

    public abstract String sign();
}
