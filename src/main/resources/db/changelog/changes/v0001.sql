DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS blogs;

CREATE TABLE blogs
(
    blog_id serial PRIMARY KEY,
    title VARCHAR ( 500 ) NOT NULL,
    content VARCHAR ( 5000 ) NOT NULL
);

CREATE TABLE comments
(
    comment_id serial PRIMARY KEY,
    userid VARCHAR ( 50 ) NOT NULL,
    content VARCHAR ( 5000 ) NOT NULL,
    blog_blog_id INTEGER REFERENCES blogs
);

