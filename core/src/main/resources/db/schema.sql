CREATE TABLE if not exists rabbit_message_dto
(
    id          BIGINT NOT NULL,
    type        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_rabbit_message_dto PRIMARY KEY (id)
);

CREATE TABLE if not exists debug
(
    id          varchar NOT NULL,
    system_type_id BIGINT,
    method_params VARCHAR(255),
    CONSTRAINT pk_rabbit_message_dto PRIMARY KEY (id)
);

CREATE TABLE if not exists exception
(
    id          varchar NOT NULL,
    system_type_id BIGINT,
    method_params VARCHAR(255),
    CONSTRAINT pk_rabbit_message_dto PRIMARY KEY (id)
);
