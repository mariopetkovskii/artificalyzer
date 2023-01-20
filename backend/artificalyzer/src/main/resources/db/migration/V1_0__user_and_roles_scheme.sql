CREATE SCHEMA IF NOT EXISTS userroles;

CREATE TABLE userroles.ur_role (
                                   "id" BIGSERIAL NOT NULL,
                                   "name" TEXT,
                                   "label" TEXT,
                                   PRIMARY KEY ("id"),
                                   UNIQUE ("name")
);

CREATE TABLE userroles.ur_user (
                                   "id" BIGSERIAL NOT NULL,
                                   "email" TEXT,
                                   "password" TEXT,
                                   "enabled" BOOLEAN,
                                   "date_created" TIMESTAMP WITH TIME ZONE,
                                   "date_modified" TIMESTAMP WITH TIME ZONE,
                                   "first_name" TEXT,
                                   "last_name" TEXT,
                                   PRIMARY KEY ("id"),
                                   UNIQUE ("email")
);


CREATE TABLE userroles.ur_user_role (
                                        "id" BIGSERIAL NOT NULL,
                                        "ur_role_id" BIGINT,
                                        "ur_user_id" BIGINT,
                                        PRIMARY KEY ("id")
);

CREATE TABLE userroles.ur_token (
                                    "id" BIGSERIAL NOT NULL,
                                    "token" TEXT,
                                    "date_created" TIMESTAMP WITH TIME ZONE,
                                    "ur_user_id" BIGINT,
                                    "expiration_date" TIMESTAMP WITH TIME ZONE,
                                    PRIMARY KEY ("id")
);
