DROP TABLE IF EXISTS time_event;

CREATE TABLE time_event (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_date_time DATETIME
);

CREATE TABLE rss (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(256),
    link VARCHAR(256),
    description VARCHAR(512),
    event_date_time DATETIME
);