ALTER TABLE book_genre
    DROP CONSTRAINT fk52evq6pdc5ypanf41bij5u218;

CREATE TABLE admin
(
    id         UUID         NOT NULL,
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
    id   UUID NOT NULL,
    date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_arrival PRIMARY KEY (id)
);

CREATE TABLE arrival_item
(
    id           UUID    NOT NULL,
    arrival_id   UUID    NOT NULL,
    book_copy_id UUID    NOT NULL,
    quantity     INTEGER NOT NULL,
    CONSTRAINT pk_arrival_item PRIMARY KEY (id)
);

CREATE TABLE book_genres
(
    book_id  UUID NOT NULL,
    genre_id UUID NOT NULL
);

CREATE TABLE customer
(
    id         UUID         NOT NULL,
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
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_genre PRIMARY KEY (id)
);

CREATE TABLE sale
(
    id          UUID NOT NULL,
    date        TIMESTAMP WITHOUT TIME ZONE,
    customer_id UUID NOT NULL,
    CONSTRAINT pk_sale PRIMARY KEY (id)
);

CREATE TABLE sale_item
(
    id           UUID    NOT NULL,
    sale_id      UUID    NOT NULL,
    book_copy_id UUID    NOT NULL,
    quantity     INTEGER NOT NULL,
    CONSTRAINT pk_sale_item PRIMARY KEY (id)
);

ALTER TABLE book
    ADD isbn VARCHAR(255);

ALTER TABLE book
    ALTER COLUMN isbn SET NOT NULL;

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

ALTER TABLE sale_item
    ADD CONSTRAINT FK_SALE_ITEM_ON_BOOK_COPY FOREIGN KEY (book_copy_id) REFERENCES book_copy (id);

ALTER TABLE sale_item
    ADD CONSTRAINT FK_SALE_ITEM_ON_SALE FOREIGN KEY (sale_id) REFERENCES sale (id);

ALTER TABLE sale
    ADD CONSTRAINT FK_SALE_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE book_genres
    ADD CONSTRAINT fk_boogen_on_j_book FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE book_genres
    ADD CONSTRAINT fk_boogen_on_j_genre FOREIGN KEY (genre_id) REFERENCES genre (id);

DROP TABLE book_genre CASCADE;

ALTER TABLE book_author
    DROP COLUMN author_id;

ALTER TABLE book_author
    DROP COLUMN book_id;

ALTER TABLE book_author
    ADD author_id UUID NOT NULL;

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_j_author FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE price_history
    DROP COLUMN book_copy_id;

ALTER TABLE price_history
    DROP COLUMN id;

ALTER TABLE price_history
    DROP COLUMN price;

ALTER TABLE price_history
    ADD book_copy_id UUID NOT NULL;

ALTER TABLE price_history
    ADD CONSTRAINT FK_PRICE_HISTORY_ON_BOOK_COPY FOREIGN KEY (book_copy_id) REFERENCES book_copy (id);

ALTER TABLE book_author
    ADD book_id UUID NOT NULL;

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_j_book FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE book_copy
    DROP COLUMN book_id;

ALTER TABLE book_copy
    DROP COLUMN id;

ALTER TABLE book_copy
    ADD book_id UUID NOT NULL;

ALTER TABLE book_copy
    ADD CONSTRAINT FK_BOOK_COPY_ON_BOOK FOREIGN KEY (book_id) REFERENCES book (id);

ALTER TABLE author
    DROP COLUMN id;

ALTER TABLE author
    ADD id UUID NOT NULL PRIMARY KEY;

ALTER TABLE book
    DROP COLUMN id;

ALTER TABLE book
    ADD id UUID NOT NULL PRIMARY KEY;

ALTER TABLE book_copy
    ADD id UUID NOT NULL PRIMARY KEY;

ALTER TABLE dummy
    ALTER COLUMN id TYPE VARCHAR(255) USING (id::VARCHAR(255));

ALTER TABLE dummy_uuid
    ALTER COLUMN id TYPE VARCHAR(255) USING (id::VARCHAR(255));

ALTER TABLE price_history
    ADD id UUID NOT NULL PRIMARY KEY;

ALTER TABLE price_history
    ADD price DOUBLE PRECISION NOT NULL;