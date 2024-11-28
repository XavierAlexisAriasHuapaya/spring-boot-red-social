insert into modules (name, base_path, created_at, updated_at, status) values ('AUTHENTICATION', '/auth', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('VALIDATE', '/auth', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('USER', '/user', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('CHAT', '/chat', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('MESSAGE', '/message', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('PUBLICATION', '/publication', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('AUTHENTICATE', '/authenticate', 'POST', true, 1, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('VALIDATE', '/validate', 'POST', true, 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_CREATE', '', 'POST', true, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_UPDATE', '/[0-9]*', 'PUT', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_FIND_ONE', '/[0-9]*', 'GET', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_PAGINATION', '', 'GET', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_PAGINATION_EXCLUDE_ID', '/exclude/[0-9]*', 'GET', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_CREATE', '', 'POST', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_UPDATE', '/[0-9]*', 'PUT', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_ALL', '', 'GET', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_BY_USERS', '/users/one/[0-9]*/two/[0-9]*', 'GET', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_ALL_BY_USERS', '/user/[0-9]*', 'GET', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_ONE_BY_USER', '/[0-9]*/user/[0-9]*', 'GET', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('CHAT_NOTIFICATION_BY_USER', '/notifications/user/[0-9]*', 'GET', false, 4, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('MESSAGE_CREATE', '', 'POST', false, 5, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('MESSAGE_UPDATE', '/[0-9]*', 'PUT', false, 5, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('MESSAGE_ALL', '', 'GET', false, 5, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('MESSAGE_BY_CHAT', '/chat/[0-9]*', 'GET', false, 5, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('MESSAGE_UPDATE_SEEN', '/seen/[0-9]*', 'PUT', false, 5, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('PUBLICATION_CREATE', '', 'POST', false, 6, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('PUBLICATION_UPDATE', '/[0-9]*', 'PUT', false, 6, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('PUBLICATION_ALL', '', 'GET', false, 6, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);


INSERT INTO roles (description, created_at, updated_at, status) VALUES ('ADMINISTRATOR', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
INSERT INTO roles (description, created_at, updated_at, status) VALUES ('USER', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 3);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 4);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 5);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 6);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 7);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 8);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 9);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 10);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 11);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 12);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 13);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 14);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 15);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 16);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 17);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 18);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 19);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 20);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 21);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 22);

-- insert into users (username, password, email, name, last_name, rol_id, created_at, updated_at, status) values ('alexis', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'xavieralexisariashuapaya@hotmail.com', 'Xavier Alexis', 'Arias Huapaya', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
-- insert into users (username, password, email, name, last_name, rol_id, created_at, updated_at, status) values ('michael', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'xavieralexisariashuapaya1999@gmail.com', 'Michael Felix', 'Acosta Perez', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
-- insert into users (username, password, email, name, last_name, rol_id, created_at, updated_at, status) values ('kassandra', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'ariashuapayaxavieralexis@gmail.com', 'Kassandra Isabella', 'Acuña Perez' ,2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
-- insert into users (username, password, email, name, last_name, rol_id, created_at, updated_at, status) values ('roxana', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'roxana@gmail.com', 'Roxana', 'Aguirre Valencia', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
-- insert into users (username, password, email, name, last_name, rol_id, created_at, updated_at, status) values ('emylia', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'emylia@gmail.com', 'Emylia Bertha', 'Benaventa Ramos', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
-- insert into users (username, password, email, name, last_name, rol_id, created_at, updated_at, status) values ('jair', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'jair@gmail.com', 'Jair Jesus Alberto', 'Barbaran Rimachi', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);