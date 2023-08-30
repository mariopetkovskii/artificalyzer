create table sentiment_analysis(
                                   "id" BIGSERIAL NOT NULL,
                                   "input_sentance" TEXT,
                                   "polarity" TEXT,
                                   PRIMARY KEY ("id")
);