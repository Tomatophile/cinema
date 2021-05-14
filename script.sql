CREATE TABLE film
(
    id               SERIAL PRIMARY KEY,
    film_name        VARCHAR(200) NOT NULL,
    film_year        INTEGER      NOT NULL CHECK (film_year > 1880),
    film_age_limit   INTEGER      NOT NULL CHECK (film_age_limit >= 0),
    film_description TEXT         NOT NULL,
    film_rating      FLOAT        NOT NULL CHECK (film_rating > 0),
    film_buy_price   INTEGER      NOT NULL CHECK (film_buy_price > 0),
    film_rent_price  INTEGER      NOT NULL CHECK (film_rent_price > 0),
    film_country     VARCHAR(50)  NOT NULL
);

CREATE TABLE genre
(
    id         SERIAL PRIMARY KEY,
    genre_name VARCHAR(20) NOT NULL
);

CREATE TABLE film_genre
(
    film_id  INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    FOREIGN KEY (film_id) REFERENCES film,
    FOREIGN KEY (genre_id) REFERENCES genre,
    PRIMARY KEY (film_id, genre_id)
);

CREATE TABLE actor
(
    id            SERIAL PRIMARY KEY,
    actor_name    VARCHAR(20) NOT NULL,
    actor_surname VARCHAR(20) NOT NULL
);

CREATE TABLE film_actor
(
    film_id  INTEGER NOT NULL,
    actor_id INTEGER NOT NULL,
    FOREIGN KEY (film_id) REFERENCES film,
    FOREIGN KEY (actor_id) REFERENCES actor,
    PRIMARY KEY (film_id, actor_id)
);

CREATE TABLE client
(
    id            SERIAL PRIMARY KEY,
    email         VARCHAR(40) NOT NULL UNIQUE,
    nickname      VARCHAR(50) NOT NULL,
    password_hash VARCHAR(80)    NOT NULL,
    birthday      DATE,
    gender        CHAR(1) CHECK (gender in ('f', 'm', 'u', 'b'))
);

CREATE TABLE bought_film
(
    user_id      INTEGER  NOT NULL,
    film_id      INTEGER  NOT NULL,
    film_quality SMALLINT NOT NULL CHECK (film_quality IN (1, 2, 3)),
    FOREIGN KEY (user_id) REFERENCES client,
    FOREIGN KEY (film_id) REFERENCES film,
    PRIMARY KEY (film_id, user_id)
);

CREATE TABLE rented_film
(
    user_id      INTEGER   NOT NULL,
    film_id      INTEGER   NOT NULL,
    film_quality SMALLINT  NOT NULL CHECK (film_quality IN (1, 2, 3)),
    start_date   TIMESTAMP NOT NULL,
    end_date     TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES client,
    FOREIGN KEY (film_id) REFERENCES film,
    CHECK (start_date < end_date),
    PRIMARY KEY (film_id, user_id)
);

CREATE TABLE card
(
    id       SERIAL PRIMARY KEY,
    user_id  INTEGER  NOT NULL,
    number   CHAR(16) NOT NULL,
    owner    VARCHAR(80),
    end_date DATE     NOT NULL,
    FOREIGN KEY (user_id) REFERENCES client
);

CREATE TABLE voucher
(
    id           SERIAL PRIMARY KEY,
    film_id      INTEGER NOT NULL,
    payment_type VARCHAR(4) CHECK (payment_type in ('buy','rent')),
    payment_info TEXT,
    card_id      INTEGER NOT NULL,
    FOREIGN KEY (film_id) REFERENCES film,
    FOREIGN KEY (card_id) REFERENCES card
);

CREATE TABLE role
(
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(20) UNIQUE NOT NULL
);