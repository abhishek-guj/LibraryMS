CREATE TABLE book
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    title            VARCHAR(255)          NULL,
    isbn             VARCHAR(255)          NULL,
    publication_year datetime              NULL,
    library_id       INT                   NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE book_author
(
    book_id   BIGINT NOT NULL,
    author_id BIGINT NOT NULL
);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_LIBRARY FOREIGN KEY (library_id) REFERENCES library (id);

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_author FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_book FOREIGN KEY (book_id) REFERENCES book (id);