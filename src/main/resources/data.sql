DROP  TABLE IF EXISTS User;
DROP  TABLE IF EXISTS Task;



CREATE TABLE User (
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);


  
  INSERT INTO User (user_name, email_address, password) VALUES
  ('Billy Jacob', 'billy.jacob33@gmail.com', 'admin'),
  ('Bill Gates', 'bill.gates01@gmail.com', 'microsoft'),
  ('John Kelly', 'john.kelly03@gmail.com', '1234'),
  ('admin', 'admin@gmail.com', 'admin');



  
  
  
  
  CREATE TABLE Task(
  task_id INT AUTO_INCREMENT  PRIMARY KEY,
  task_name VARCHAR(50) NOT NULL,
  description VARCHAR(250) NOT NULL,
  date DATE NOT NULL,
  priority INT NOT NULL,
  completed BOOLEAN NOT NULL,
  user_id INT NOT NULL ,
  foreign key (user_id) references User(user_id)
);


INSERT INTO Task (task_name,description, date,priority,completed,user_id ) VALUES
  ('Breakfast', 'have breakfast between 8 and 9', TO_DATE('24/Mar/2021'), 2, FALSE, 1),
  ('Lunch', 'have lunch between 1 and 2', TO_DATE('24/Mar/2021'), 2, FALSE, 1),
  ('Dinner', 'have dinner between 6 and 7', TO_DATE('24/Mar/2021'), 2, FALSE, 1);