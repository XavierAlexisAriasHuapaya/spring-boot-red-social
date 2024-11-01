insert into modules (name, base_path, created_at, updated_at, status) values ('AUTHENTICATION', '/auth', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('VALIDATE', '/auth', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into modules (name, base_path, created_at, updated_at, status) values ('USER', '/user', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('AUTHENTICATE', '/authenticate', 'POST', true, 1, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('VALIDATE', '/validate', 'POST', true, 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_CREATE', '', 'POST', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_UPDATE', '', 'PUT', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_FIND_ONE', '/[0-9]*', 'GET', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into operations (name, path, http_method, permit_all, module_id, created_at, updated_at, status) values ('USER_PAGINATION', '', 'GET', false, 3, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

INSERT INTO roles (description, created_at, updated_at, status) VALUES ('ADMINISTRATOR', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
INSERT INTO roles (description, created_at, updated_at, status) VALUES ('USER', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 3);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 4);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 5);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 6);

insert into users (username, password, email, rol_id, created_at, updated_at, status) values ('alexis', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'xavieralexisariashuapaya@hotmail.com', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into users (username, password, email, rol_id, created_at, updated_at, status) values ('manuel', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'xavieralexisariashuapaya1999@gmail.com', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into users (username, password, email, rol_id, created_at, updated_at, status) values ('maria', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 'ariashuapayaxavieralexis@gmail.com', 2, '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into chats (name, chat_type, created_at, updated_at, status) values ('Alexis and Manuel', 'PRIVATE', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into chats (name, chat_type, created_at, updated_at, status) values ('Alexis and Manuel and Maria', 'GROUP', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (1, 1, 'Hola?', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (1, 2, '¿Hola?', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (1, 1, 'Que tal?', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);


insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (2, 1, 'Hola a todos.', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (2, 2, 'Hola Alexis', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (2, 3, 'Hola a todo el grupo', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (2, 1, 'A que hora nos reunimos para avanzar el trabajo', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into publications (user_id, content, created_at, updated_at, status) values (1, '¡Hoy me encuentro muy feliz!', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);