    create table sentence_translate(
                                       "id" BIGSERIAL NOT NULL,
                                       "input_sentance" TEXT,
                                       "lg" text,
                                       "translated_sentece" TEXT,
                                       PRIMARY KEY ("id")
    );