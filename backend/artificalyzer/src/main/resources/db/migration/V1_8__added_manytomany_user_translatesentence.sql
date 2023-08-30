CREATE TABLE translate_sentence_users (
                                               "id" BIGSERIAL NOT NULL,
                                               "ur_user_id" BIGINT,
                                               "translate_sentence_id" BIGINT,
                                               PRIMARY KEY ("id"),
                                               CONSTRAINT "aimodels_ai_models_user_fk2" FOREIGN KEY ("ur_user_id") REFERENCES userroles.ur_user("id"),
                                               CONSTRAINT "translate_sentence_fk" FOREIGN KEY ("translate_sentence_id") REFERENCES sentence_translate("id")
);