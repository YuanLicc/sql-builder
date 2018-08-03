package com.yl.sql.type;

public enum AndOrType {
    and {
        @Override
        public String sign() {
            return "AND";
        }
    },
    or {
        @Override
        public String sign() {
            return "OR";
        }
    };
    public abstract String sign();
}
