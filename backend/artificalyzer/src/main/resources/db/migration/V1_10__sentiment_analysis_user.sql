CREATE TABLE sentiment_analysis_users (
                                          "id" BIGSERIAL NOT NULL,
                                          "ur_user_id" BIGINT,
                                          "sentiment_analysis_id" BIGINT,
                                          PRIMARY KEY ("id"),
                                          CONSTRAINT "aimodels_ai_models_user_fk2" FOREIGN KEY ("ur_user_id") REFERENCES userroles.ur_user("id"),
                                          CONSTRAINT "sentiment_analysis_fk" FOREIGN KEY ("sentiment_analysis_id") REFERENCES sentiment_analysis("id")
);