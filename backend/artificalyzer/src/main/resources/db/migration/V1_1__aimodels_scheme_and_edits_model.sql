CREATE SCHEMA IF NOT EXISTS aimodels;

CREATE TABLE aimodels.ai_edits (
                                   "id" BIGSERIAL NOT NULL,
                                   "model" TEXT,
                                   "input_text" TEXT,
                                   "instruction" TEXT,
                                   "output_text" TEXT,
                                   PRIMARY KEY ("id")
);