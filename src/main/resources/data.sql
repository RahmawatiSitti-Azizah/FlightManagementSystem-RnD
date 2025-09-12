MERGE INTO app_user (id, username, password, name, role) KEY(username) VALUES (default, 'admin', 'admin123', 'admin', 'ADMIN');
MERGE INTO app_user (id, username, password, name, role) KEY(username) VALUES (default, 'passenger1', 'passenger123', 'Jane Doe', 'PASSENGER');
MERGE INTO app_user (id, username, password, name, role) KEY(username) VALUES (default, 'passenger2', 'passenger123', 'John Doe', 'PASSENGER');
MERGE INTO app_user (id, username, password, name, role) KEY(username) VALUES (default, 'passenger3', 'passenger123', 'Jack Brown', 'PASSENGER');
MERGE INTO app_user (id, username, password, name, role) KEY(username) VALUES (default, 'passenger4', 'passenger123', 'Ariana Grande', 'PASSENGER');