## sql-builder [![Build Status](https://travis-ci.org/YuanLicc/sql-builder.svg?branch=master)](https://travis-ci.org/YuanLicc/sql-builder) [![codecov.io](https://codecov.io/gh/YuanLicc/sql-builder/branch/master/graphs/badge.svg?branch=master)](https://codecov.io/gh/YuanLicc/sql-builder?branch=master) [![GitHub version](https://badge.fury.io/gh/yuanlicc%2Fsql-builder.svg)](https://badge.fury.io/gh/yuanlicc%2Fsql-builder)

SQL语句构建器。本项目目前连简单查询都不能做到，因为中间遇到的问题太多了，若初步完成，我会打个 tag，也希望感兴趣的能够和我一起想想怎么设计。大力么么哒。

### 情景

之前在做项目时，发现了很多复杂查询我们都会选择直接写 Sql 语句进行查询，在此过程中首先肯定要书写一个 `String sql = "..."`，比如：

```mysql
select * from person left join course on person.courseId=course.id order by course.startTime desc;
```

假设我的另外一个需求是在上面的基础上做一个分页查询，此时我们就可能复制上面的 SQL 然后加上我们的分页查询语句，我就在想我们何不将 SQL 基础部分抽象出来，方便复用呢？再者写这么长的字符串往往会显得代码不好看。另外一个原因就是我们通常书写 SQL 语句时有了自己的逻辑，但是容易写错，可能是少个空格，或者关键字写错了等等。基于上面的情况，我想做一个解决这些问题的构件。



### 目标
1）实现形如以下的调用后得到预计的SQL语句：

```java
String sql = SqlBuilder.buildSelectSql().columns("id", "name")
    .aliasColumns("id", "personName")
    .from("person")
    .as("p")
    .where(...)
    ...;
```

结果：

```mysql
SELECT p.id AS id, p.name AS personName from person AS p where ...;
```

2）支持多表查询语句

3）支持关联查询语句

4）支持子查询



### 目前状况

已经实现了上诉要求的 SQL 拼接，即构造 `Select` 对象的构造方法，但怎样从 `SqlBuilder` 通过一系列的调用最终构造出一个 `Select` 对象还未完成。由于每次调用一个方法都存在构造新类型的对象，而调用时的参数怎么维护，以哪种形式表现和传递都是一个很大的问题，在此过程中最大的难点莫过于SQL本身的语法组合情况太多，导致最终存在很多的判断。

由于字符串的拼接会造成大量的 StringBuilder 对象生成（字符串 + 字符串），后面有时间再修改为 StringBuilder。

总之，此构件不可用，等有时间再搞，emm。