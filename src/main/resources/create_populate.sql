DROP TABLE IF EXISTS quiz.user, quiz.role;

CREATE TABLE role
(
  role_id INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(35) NOT NULL,
  PRIMARY KEY (role_id)
);

CREATE TABLE user
(
  user_id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(35) NOT NULL,
  password VARCHAR(35) NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id),
  CONSTRAINT user_fk FOREIGN KEY (role_id) REFERENCES role (role_id)
);

INSERT INTO quiz.role (role_name) VALUES
  ('USER'),
  ('ADMIN'),
  ('ANON');

INSERT INTO quiz.user (username, password, role_id) VALUES
  ('user1','user1', 1),
  ('user2','user2', 1),
  ('user3','user3', 1),
  ('judge1','judge1', 2),
  ('judge2','judge2', 2);