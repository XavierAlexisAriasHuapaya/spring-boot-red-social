insert into users (username, password, email, created_at, updated_at, status) values ('alexis', '123456', 'xavieralexisariashuapaya@hotmail.com', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into users (username, password, email, created_at, updated_at, status) values ('manuel', '12345', 'xavieralexisariashuapaya1999@gmail.com', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into users (username, password, email, created_at, updated_at, status) values ('maria', '123456789', 'ariashuapayaxavieralexis@gmail.com', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into chats (name, chat_type, created_at, updated_at, status) values ('Alexis and Manuel', 'PRIVATE', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (1, 1, 'Hola?', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (1, 2, '¿Hola?', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);
insert into messages (chat_id, user_id, content, created_at, updated_at, status) values (1, 1, 'Que tal?', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);

insert into publications (user_id, content, created_at, updated_at, status) values (1, '¡Hoy me encuentro muy feliz!', '2024-10-31T14:30:28.380152', '2024-10-31T14:30:28.380152', true);