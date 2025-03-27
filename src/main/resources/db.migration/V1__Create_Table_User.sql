CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tb_users
(
    user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name  VARCHAR(100),
    last_name  VARCHAR(100)
);