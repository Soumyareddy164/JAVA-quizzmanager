create table questions(
id INT auto_increment PRIMARY KEY,
question_text VARCHAR(250) NOT NULL,
topics VARCHAR(250),
Difficulty VARCHAR(10),
ISMCQ BOOLEAN
);

CREATE table MCQ_CHOICE(
mcq_id INT auto_increment PRIMARY KEY,
choice VARCHAR(200) NOT NULL,
question_id INT NOT NULL,
FOREIGN KEY (question_id) REFERENCES questions(id),
);

create table answers(
answer_id INT auto_increment primary key,
actual_answer VARCHAR(250),
user_answer VARCHAR(250),
question_id INT NOT NULL,
mcq_id INT,
foreign key (question_id) references questions(id),
foreign key (mcq_id) references MCQ_CHOICE(mcq_id),
);

create table student(
id INT auto_increment,
name VARCHAR (10),
score INT,
);

INSERT into questions(question_text,topics,difficulty,ISMCQ) values('Does java support multiple inheritance?', 'JAVA_BASICS', 1, 'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('What is the default value of int variable?', 'JAVA_BASICS', 1, 'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('What is the size of long variable?', 'JAVA_BASICS', 1, 'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('Method Overloading is an example of', 'JAVA_BASICS', 2, 'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('Can a top level class be private or protected', 'Inheritance', 1,'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('What kind of variables a class can consist of?', 'Inheritance', 1,'FALSE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('which of the following will directly stop the execution of a thread?', 'MULTITHREADING', 3, 'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('which will contain the body of the thread?', 'MULTITHREADING', 3, 'TRUE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('what keyword is used for inheritance in java?', 'OOPS', 3, 'FALSE');
INSERT into questions(question_text,topics,difficulty,ISMCQ) values('what keyword is used to define a class  in java?', 'OOPS', 3, 'FALSE');


insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) YES', 1);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) NO', 1);


insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) 0', 2);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) NULL', 2);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('c) NOT DEFINED', 2);


insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) 8 BIT', 3);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) 16 BIT', 3);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('c) 64 BIT', 3);

insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) STATIC BINDING', 4);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) DYNAMIC BINDING', 4);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('c)  BOTH', 4);

insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) TRUE', 5);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) FALSE', 5);

insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) wait()', 7);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) notify()', 7);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('c) sleep()', 7);

insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('a) run()', 8);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('b) start()', 8);
insert into MCQ_CHOICE(CHOICE,QUESTION_ID) values('c) main()', 8);

INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('b', ' ' , 1, 2);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('a', ' ' , 2, 3);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('c', ' ' , 3, 8);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('a', ' ' , 4, 9);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('b', ' ' , 5, 13);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID) VALUES('class variables, local variables, instance variables', ' ' , 6);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('a', ' ' , 7, 14);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID,MCQ_ID) VALUES('a', ' ' , 8, 17);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID) VALUES('extends', ' ' , 9);
INSERT INTO ANSWERS (ACTUAL_ANSWER,USER_ANSWER,QUESTION_ID) VALUES('class', ' ' , 10);
