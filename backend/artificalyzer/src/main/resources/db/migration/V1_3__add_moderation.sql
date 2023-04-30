CREATE TABLE aimodels.ai_moderations (
                                   "id" BIGSERIAL NOT NULL,
                                   "input_text" TEXT,
                                   "hate" BOOLEAN,
                                   "hate_score" DOUBLE PRECISION,
                                   "hate_and_threatening" BOOLEAN,
                                   "hate_and_threatening_score" DOUBLE PRECISION,
                                   "self_harm" BOOLEAN,
                                   "self_harm_score" DOUBLE PRECISION,
                                   "sexual" BOOLEAN,
                                   "sexual_score" DOUBLE PRECISION,
                                   "sexual_minors" BOOLEAN,
                                   "sexual_minors_score" DOUBLE PRECISION,
                                   "violence" BOOLEAN,
                                   "violence_score" DOUBLE PRECISION,
                                   "violence_graphic" BOOLEAN,
                                   "violence_graphic_score" DOUBLE PRECISION,
                                   PRIMARY KEY ("id")
);