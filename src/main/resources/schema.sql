CREATE TABLE IF NOT EXISTS category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255),
    price double,
    categoryId int,
    FOREIGN KEY(categoryId) REFERENCES category(id)
);