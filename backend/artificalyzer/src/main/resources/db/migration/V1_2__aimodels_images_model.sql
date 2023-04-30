CREATE TABLE aimodels.ai_images (
                                    "id" BIGSERIAL NOT NULL,
                                    "prompt" TEXT,
                                    "number_images" BIGINT,
                                    "size" TEXT,
                                    "url" TEXT,
                                    PRIMARY KEY ("id")
);