
# SQL Fundamentals and Basic Queries

---

## 1. Introduction to SQL

SQL (Structured Query Language) is the standard language for managing and manipulating relational databases. It allows you to create, read, update, and delete data, as well as define the structure and relationships of tables.

---

## 2. Data Types in SQL

Common SQL data types:

- `INT`, `BIGINT` — Integer numbers
- `DECIMAL`, `FLOAT` — Decimal numbers
- `CHAR(n)`, `VARCHAR(n)` — Fixed and variable-length strings
- `DATE`, `TIME`, `DATETIME` — Date and time values
- `BOOLEAN` — True/false values (supported in some DBMS)

Example:
```sql
CREATE TABLE sample (
  id INT,
  name VARCHAR(50),
  price DECIMAL(10,2),
  created_at DATE
);
```

---


## 3. Basic CRUD Operations

CRUD stands for Create, Read, Update, Delete — the four basic operations for persistent storage.

### Create (INSERT)
Add new rows to a table.
```sql
INSERT INTO employees (emp_id, name, dept_id) VALUES (1, 'Alice', 101);
INSERT INTO employees VALUES (2, 'Bob', 102); -- If column order matches table definition
```

### Read (SELECT)
Retrieve data from one or more tables.
```sql
SELECT * FROM employees; -- All columns, all rows
SELECT name, dept_id FROM employees WHERE emp_id = 1; -- Specific columns, filtered rows
SELECT DISTINCT dept_id FROM employees; -- Unique department IDs
SELECT name FROM employees WHERE dept_id = 101 ORDER BY name ASC; -- Sorted results
SELECT COUNT(*) FROM employees WHERE dept_id = 101; -- Count rows matching condition
```

### Update (UPDATE)
Modify existing rows in a table.
```sql
UPDATE employees SET dept_id = 102 WHERE emp_id = 1; -- Change department for Alice
UPDATE employees SET name = 'Robert' WHERE emp_id = 2; -- Change name for emp_id 2
```

### Delete (DELETE)
Remove rows from a table.
```sql
DELETE FROM employees WHERE emp_id = 1; -- Remove Alice
DELETE FROM employees WHERE dept_id = 102; -- Remove all employees in dept 102
```

---

## 4. Table Structure and Normalization

Tables are the basic storage objects in SQL. Each table consists of rows and columns. Good table design follows normalization principles to reduce redundancy and improve data integrity.

**Normalization** is the process of organizing data to minimize duplication. Common normal forms:
- 1NF: Each column contains atomic values.
- 2NF: Every non-key column is fully dependent on the primary key.
- 3NF: No transitive dependencies (non-key columns depend only on the primary key).

---


## 5. SQL Keys

Keys are attributes (columns) that help uniquely identify rows, enforce relationships, and maintain data integrity.

### SQL Keys Summary Table

| Key Type      | Definition (short)                                              | Typical use / notes                             |
| ------------- | --------------------------------------------------------------- | ----------------------------------------------- |
| Super Key     | One or more columns that can uniquely identify a row.           | May include unnecessary columns; not minimal.   |
| Candidate Key | A minimal Super Key (no extra columns).                         | Potential Primary Keys.                         |
| Primary Key   | The chosen Candidate Key used to uniquely identify rows.        | One per table; implies uniqueness and NOT NULL. |
| Foreign Key   | Column(s) referencing a Primary/Candidate Key in another table. | Enforces referential integrity between tables.  |

---

### Super Key
A Super Key is any combination of columns that can uniquely identify a row. It may include extra columns.

**Example:**
```sql
-- Both (emp_id) and (emp_id, name) are Super Keys for this table
CREATE TABLE employees (
  emp_id INT,
  name VARCHAR(100),
  email VARCHAR(255),
  ssn CHAR(11)
);
-- (emp_id, email) is also a Super Key if both are unique together
```

### Candidate Key
A minimal Super Key — no unnecessary columns. Removing any column breaks uniqueness.

**Example:**
```sql
-- If emp_id and ssn are both unique, each is a Candidate Key
CREATE TABLE employees (
  emp_id INT UNIQUE,
  ssn CHAR(11) UNIQUE,
  name VARCHAR(100)
);
-- Candidate Keys: (emp_id), (ssn)
```

### Primary Key
The chosen Candidate Key used as the main unique identifier for table rows. Only one per table.

**Example:**
```sql
CREATE TABLE employees (
  emp_id INT PRIMARY KEY,
  ssn CHAR(11) UNIQUE,
  name VARCHAR(100)
);
-- emp_id is the Primary Key
```

**How to choose a good primary key?**
- Fast to sort on (INT types preferred)
- Small size (efficient indexing)
- Should not change (e.g., emp_id, not phone/email)

### Foreign Key
A column or set of columns in one table that refers to the Primary Key (or Candidate Key) in another table. Enforces referential integrity.

**Example:**
```sql
CREATE TABLE departments (
  dept_id INT PRIMARY KEY,
  dept_name VARCHAR(100)
);

CREATE TABLE employees (
  emp_id INT PRIMARY KEY,
  name VARCHAR(100),
  dept_id INT,
  CONSTRAINT fk_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);
-- employees.dept_id is a Foreign Key referencing departments.dept_id
```

---

## 6. SQL Constraints

A constraint in SQL is a rule enforced on data columns in a table. Constraints ensure the accuracy, reliability, and integrity of the data in the database by restricting the type of data that can be stored in a column or the relationships between tables.

### Types of Constraints

| Constraint Type | Description                                                                           | Example                                                 |
| --------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------- |
| PRIMARY KEY     | Uniquely identifies each row in a table. Implies NOT NULL and UNIQUE.                 | `emp_id INT PRIMARY KEY`                                |
| FOREIGN KEY     | Ensures referential integrity by linking to a primary/candidate key in another table. | `FOREIGN KEY (dept_id) REFERENCES departments(dept_id)` |
| UNIQUE          | Ensures all values in a column are unique (no duplicates).                            | `email VARCHAR(255) UNIQUE`                             |
| NOT NULL        | Ensures a column cannot have NULL values.                                             | `name VARCHAR(100) NOT NULL`                            |
| CHECK           | Ensures values in a column meet a specific condition.                                 | `salary INT CHECK (salary > 0)`                         |
| DEFAULT         | Sets a default value for a column if no value is provided.                            | `status VARCHAR(20) DEFAULT 'active'`                   |

#### Examples
```sql
CREATE TABLE students (
  student_id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
  user_id INT PRIMARY KEY,
  username VARCHAR(50) UNIQUE
);

CREATE TABLE orders (
  order_id INT PRIMARY KEY,
  customer_id INT,
  CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE products (
  product_id INT PRIMARY KEY,
  price DECIMAL(10,2) CHECK (price > 0)
);

CREATE TABLE tasks (
  task_id INT PRIMARY KEY,
  status VARCHAR(20) DEFAULT 'pending'
);
```

---


## 7. Constraint Syntax & Cascading Behavior

Foreign key constraints not only link tables logically but also control what happens when referenced rows are updated or deleted. The following table summarizes the main cascade types and their effects:

| Cascade Type        | Description                                                                 | Example Syntax        |
| ------------------- | --------------------------------------------------------------------------- | --------------------- |
| ON DELETE CASCADE   | When the referenced row is deleted, delete the referencing rows as well.    | `ON DELETE CASCADE`   |
| ON UPDATE CASCADE   | When the referenced key value is updated, update referencing rows to match. | `ON UPDATE CASCADE`   |
| ON DELETE SET NULL  | When the referenced row is deleted, set referencing FK column(s) to NULL.   | `ON DELETE SET NULL`  |
| ON UPDATE SET NULL  | When the referenced key is updated, set referencing FK column(s) to NULL.   | `ON UPDATE SET NULL`  |
| ON DELETE RESTRICT  | Prevent deletion of referenced row if referencing rows exist.               | `ON DELETE RESTRICT`  |
| ON UPDATE RESTRICT  | Prevent update of referenced key if referencing rows exist.                 | `ON UPDATE RESTRICT`  |
| ON DELETE NO ACTION | Like RESTRICT, but timing of enforcement may differ by DBMS.                | `ON DELETE NO ACTION` |
| ON UPDATE NO ACTION | Like RESTRICT, but timing of enforcement may differ by DBMS.                | `ON UPDATE NO ACTION` |

**Examples:**
```sql
CREATE TABLE departments (
  dept_id INT PRIMARY KEY,
  dept_name VARCHAR(100)
);

CREATE TABLE employees (
  emp_id INT PRIMARY KEY,
  name VARCHAR(100),
  dept_id INT,
  CONSTRAINT fk_dept FOREIGN KEY (dept_id)
    REFERENCES departments(dept_id)
    ON DELETE CASCADE
);

CREATE TABLE employees2 (
  emp_id INT PRIMARY KEY,
  name VARCHAR(100),
  dept_id INT,
  CONSTRAINT fk_dept2 FOREIGN KEY (dept_id)
    REFERENCES departments(dept_id)
    ON DELETE SET NULL
);

CREATE TABLE employees3 (
  emp_id INT PRIMARY KEY,
  name VARCHAR(100),
  dept_id INT,
  CONSTRAINT fk_dept3 FOREIGN KEY (dept_id)
    REFERENCES departments(dept_id)
    ON UPDATE CASCADE
);
```

**Practical considerations:**
- Choose cascading actions carefully. ON DELETE CASCADE is useful for tightly-coupled data (e.g., order_items -> orders), but dangerous for loosely-coupled data.
- Use ON DELETE SET NULL when the relationship is optional and you want to retain referencing rows after the referenced row is removed.
- Use RESTRICT/NO ACTION when you want to prevent deletion or updates of referenced rows as long as dependent rows exist.
- Index foreign key columns in large tables to improve performance.
- When altering tables to add foreign keys or change actions, plan for the cost of checking existing rows.

**DBMS specifics (brief):**
- MySQL (InnoDB): supports CASCADE, SET NULL, RESTRICT, NO ACTION.
- PostgreSQL: supports CASCADE, SET NULL, RESTRICT, NO ACTION, DEFERRABLE constraints.
- SQL Server: supports CASCADE and SET NULL, with some syntax differences.

Always consult your DBMS documentation for exact behavior and supported options.

---

## 8. Additional SQL Concepts

### Comments in SQL
Use `--` for single-line comments and `/* ... */` for multi-line comments.
```sql
-- This is a single-line comment
/* This is a
   multi-line comment */
```


### Basic SELECT Clause (Elaborated)

The SELECT statement is used to query data from tables. It can retrieve all columns, specific columns, filter rows, sort results, and more.

**Syntax:**
```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition
ORDER BY column1 [ASC|DESC]
LIMIT n OFFSET m;
```

**Examples:**
```sql
-- Select all columns from employees
SELECT * FROM employees;

-- Select specific columns
SELECT name, dept_id FROM employees;

-- Filter rows
SELECT name FROM employees WHERE dept_id = 101;

-- Sort results
SELECT name, dept_id FROM employees ORDER BY name DESC;

-- Limit results (MySQL/PostgreSQL)
SELECT * FROM employees LIMIT 5;

-- Offset results (skip first 5 rows)
SELECT * FROM employees LIMIT 5 OFFSET 5;

-- Use expressions
SELECT name, dept_id, emp_id * 10 AS emp_id_times_10 FROM employees;

-- Use DISTINCT to get unique values
SELECT DISTINCT dept_id FROM employees;

-- Combine conditions
SELECT name FROM employees WHERE dept_id = 101 AND name LIKE 'A%';

-- Aggregate with COUNT (for reference, not detailed here)
SELECT COUNT(*) FROM employees WHERE dept_id = 101;
```

---







