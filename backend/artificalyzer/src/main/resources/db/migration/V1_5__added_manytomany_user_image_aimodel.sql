CREATE TABLE aimodels.ai_imagesmodel_users (
                                              "id" BIGSERIAL NOT NULL,
                                              "ur_user_id" BIGINT,
                                              "ai_images_id" BIGINT,
                                              PRIMARY KEY ("id"),
                                              CONSTRAINT "aimodels_ai_models_user_fk2" FOREIGN KEY ("ur_user_id") REFERENCES userroles.ur_user("id"),
                                              CONSTRAINT "aimodels_ai_models_aiimages_fk" FOREIGN KEY ("ai_images_id") REFERENCES aimodels.ai_images("id")
);