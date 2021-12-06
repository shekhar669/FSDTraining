create table USER(id bigint auto_increment, name varchar(255), email varchar(255),password varchar(255) );
create table TWEETS(id bigint auto_increment,message text, fromUser VARCHAR(255),profileImageUrl VARCHAR(255),url VARCHAR(255),createDate DATE,likes bigint);
create table REPLIES(id bigint,tweetId bigint,message text,fromUser VARCHAR(255));