CREATE TABLE admin
(
    id         VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    phone      VARCHAR(255),
    address    VARCHAR(255),
    CONSTRAINT pk_admin PRIMARY KEY (id)
);

CREATE TABLE arrival
(
    id   VARCHAR(255) NOT NULL,
    date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_arrival PRIMARY KEY (id)
);

CREATE TABLE arrival_item
(
    id           VARCHAR(255) NOT NULL,
    arrival_id   VARCHAR(255) NOT NULL,
    book_copy_id VARCHAR(255) NOT NULL,
    quantity     INTEGER      NOT NULL,
    CONSTRAINT pk_arrival_item PRIMARY KEY (id)
);

CREATE TABLE author
(
    id            VARCHAR(255) NOT NULL,
    full_name     VARCHAR(255) NOT NULL,
    main_language VARCHAR(255) NOT NULL,
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE book
(
    id    VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    pages INTEGER      NOT NULL,
    isbn  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE book_author
(
    author_id VARCHAR(255) NOT NULL,
    book_id   VARCHAR(255) NOT NULL
);

CREATE TABLE book_copy
(
    id       VARCHAR(255) NOT NULL,
    book_id  VARCHAR(255) NOT NULL,
    format   VARCHAR(255) NOT NULL,
    language VARCHAR(255) NOT NULL,
    CONSTRAINT pk_book_copy PRIMARY KEY (id)
);

CREATE TABLE book_genres
(
    book_id  VARCHAR(255) NOT NULL,
    genre_id VARCHAR(255) NOT NULL
);

CREATE TABLE customer
(
    id         VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    phone      VARCHAR(255),
    address    VARCHAR(255),
    notes      VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE genre
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_genre PRIMARY KEY (id)
);

CREATE TABLE price_history
(
    id             VARCHAR(255)     NOT NULL,
    book_copy_id   VARCHAR(255)     NOT NULL,
    price          DOUBLE PRECISION NOT NULL,
    effective_date date             NOT NULL,
    CONSTRAINT pk_price_history PRIMARY KEY (id)
);

CREATE TABLE sale
(
    id          VARCHAR(255) NOT NULL,
    date        TIMESTAMP WITHOUT TIME ZONE,
    customer_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_sale PRIMARY KEY (id)
);

CREATE TABLE sale_item
(
    id           VARCHAR(255) NOT NULL,
    sale_id      VARCHAR(255) NOT NULL,
    book_copy_id VARCHAR(255) NOT NULL,
    quantity     INTEGER      NOT NULL,
    CONSTRAINT pk_sale_item PRIMARY KEY (id)
);

ALTER TABLE admin
    ADD CONSTRAINT uc_admin_email UNIQUE (email);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_email UNIQUE (email);

ALTER TABLE genre
    ADD CONSTRAINT uc_genre_name UNIQUE (name);

ALTER TABLE arrival_item
    ADD CONSTRAINT FK_ARRIVAL_ITEM_ON_ARRIVAL FOREIGN KEY (arrival_id) REFERENCES arrival (id);

ALTER TABLE arrival_item
    ADD CONSTRAINT FK_ARRIVAL_ITEM_ON_BOOK_COPY FOREIGN KEY (book_copy_id) REFERENCES book_copy (id);

ALTER TABLE book_copy
    ADD CONSTRAINT FK_BOOK_COPY_ON_BOOK FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE price_history
    ADD CONSTRAINT FK_PRICE_HISTORY_ON_BOOK_COPY FOREIGN KEY (book_copy_id) REFERENCES book_copy (id);

ALTER TABLE sale_item
    ADD CONSTRAINT FK_SALE_ITEM_ON_BOOK_COPY FOREIGN KEY (book_copy_id) REFERENCES book_copy (id);

ALTER TABLE sale_item
    ADD CONSTRAINT FK_SALE_ITEM_ON_SALE FOREIGN KEY (sale_id) REFERENCES sale (id);

ALTER TABLE sale
    ADD CONSTRAINT FK_SALE_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_j_author FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_j_book FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE book_genres
    ADD CONSTRAINT fk_boogen_on_j_book FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE book_genres
    ADD CONSTRAINT fk_boogen_on_j_genre FOREIGN KEY (genre_id) REFERENCES genre (id);