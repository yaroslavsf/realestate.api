CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO public."role"
(role_id, created_at, created_by, last_modified_by, modified_at, "name")
VALUES(uuid_generate_v4(), CURRENT_TIMESTAMP, 'Migration', 'Migration', CURRENT_TIMESTAMP , 'Agent');


INSERT INTO public."role"
(role_id, created_at, created_by, last_modified_by, modified_at, "name")
VALUES(uuid_generate_v4(), CURRENT_TIMESTAMP, 'Migration', 'Migration', CURRENT_TIMESTAMP , 'Client');
