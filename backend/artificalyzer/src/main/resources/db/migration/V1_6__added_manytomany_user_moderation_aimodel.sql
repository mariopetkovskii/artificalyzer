CREATE TABLE aimodels.ai_moderationsmodel_users (
                                               "id" BIGSERIAL NOT NULL,
                                               "ur_user_id" BIGINT,
                                               "ai_moderations_id" BIGINT,
                                               PRIMARY KEY ("id"),
                                               CONSTRAINT "aimodels_ai_models_user_fk3" FOREIGN KEY ("ur_user_id") REFERENCES userroles.ur_user("id"),
                                               CONSTRAINT "aimodels_ai_models_aimoderations_fk" FOREIGN KEY ("ai_moderations_id") REFERENCES aimodels.ai_moderations("id")
);