DROP TABLE IF EXISTS t_books;

CREATE TABLE t_books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    published_year INT,
    page_count INT
);
