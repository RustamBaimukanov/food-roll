CREATE TABLE IF NOT EXISTS food
(
    id
                         SERIAL
        PRIMARY
            KEY,
    name
                         VARCHAR(255) NOT NULL,
    difficulty           VARCHAR(50),
    image                BYTEA,
    image_file_extension VARCHAR(10)
);
