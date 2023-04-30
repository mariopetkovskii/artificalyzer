CREATE TABLE aimodels.ai_editsmodel_users (
                                   "id" BIGSERIAL NOT NULL,
                                   "ur_user_id" BIGINT,
                                   "ai_edits_id" BIGINT,
                                   PRIMARY KEY ("id"),
                                   CONSTRAINT "aimodels_ai_models_user_fk" FOREIGN KEY ("ur_user_id") REFERENCES userroles.ur_user("id"),
                                   CONSTRAINT "aimodels_ai_models_aiedits_fk" FOREIGN KEY ("ai_edits_id") REFERENCES aimodels.ai_edits("id")
);