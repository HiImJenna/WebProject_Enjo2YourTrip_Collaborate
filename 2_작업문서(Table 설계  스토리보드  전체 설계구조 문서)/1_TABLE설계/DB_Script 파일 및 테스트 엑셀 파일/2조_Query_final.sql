/* 내 테이블1 */
CREATE TABLE my_table1 (
   my_pk1 INTEGER NOT NULL, /* 내 기본 키 컬럼1 */
   my_pk2 INTEGER NOT NULL, /* 내 기본 키 컬럼2 */
   my_column1 VARCHAR(20) NOT NULL, /* 내 컬럼1 */
   my_column2 VARCHAR(20) /* 내 컬럼2 */
);

COMMENT ON TABLE my_table1 IS 'DDL 생성 예제 테이블입니다.';

COMMENT ON COLUMN my_table1.my_pk1 IS '내 기본 키 컬럼1';

COMMENT ON COLUMN my_table1.my_pk2 IS '내 기본 키 컬럼2';

COMMENT ON COLUMN my_table1.my_column1 IS '내 컬럼1';

COMMENT ON COLUMN my_table1.my_column2 IS '내 컬럼2';

CREATE UNIQUE INDEX my_table1_pk
   ON my_table1 (
      my_pk1 ASC,
      my_pk2 ASC
   );

CREATE UNIQUE INDEX my_table1_uq
   ON my_table1 (
      my_column1 ASC
   );

CREATE UNIQUE INDEX my_table1_uq_sys_gen
   ON my_table1 (
      my_column2 ASC
   );

ALTER TABLE my_table1
   ADD
      CONSTRAINT my_table1_pk
      PRIMARY KEY (
         my_pk1,
         my_pk2
      );

ALTER TABLE my_table1
   ADD
      CONSTRAINT my_table1_uq
      UNIQUE (
         my_column1
      );

ALTER TABLE my_table1
   ADD
      CONSTRAINT my_table1_uq_sys_gen
      UNIQUE (
         my_column2
      );

ALTER TABLE my_table1
   ADD
      CONSTRAINT my_table1_cc
      CHECK (my_pk1 > 1900 AND my_column2='Tomato System');

/* 내 테이블2 */
CREATE TABLE my_table2 (
   my_pk1 INTEGER NOT NULL, /* 내 기본 키 컬럼1 */
   my_pk2 INTEGER NOT NULL, /* 내 기본 키 컬럼2 */
   my_column VARCHAR(20) NOT NULL /* 내 컬럼1 */
);

COMMENT ON TABLE my_table2 IS '내 테이블2';

COMMENT ON COLUMN my_table2.my_pk1 IS '내 기본 키 컬럼1';

COMMENT ON COLUMN my_table2.my_pk2 IS '내 기본 키 컬럼2';

COMMENT ON COLUMN my_table2.my_column IS '내 컬럼1';

CREATE UNIQUE INDEX my_table2_pk
   ON my_table2 (
      my_pk1 ASC,
      my_pk2 ASC
   );

CREATE INDEX my_table2_idx
   ON my_table2 (
      my_column ASC
   );

ALTER TABLE my_table2
   ADD
      CONSTRAINT my_table2_pk
      PRIMARY KEY (
         my_pk1,
         my_pk2
      );

ALTER TABLE my_table2
   ADD
      CONSTRAINT my_table2_fk
      FOREIGN KEY (
         my_pk1,
         my_pk2
      )
      REFERENCES my_table1 (
         my_pk1,
         my_pk2
      );