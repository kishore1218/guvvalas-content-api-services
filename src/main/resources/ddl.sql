create table COURSE(
	ID SERIAL primary key,
	URL VARCHAR(200) not null,
	COURSE_NAME VARCHAR(200) unique not null,
	DESCRIPTION VARCHAR(500),
	LOGO_PATH varchar(500),
	IS_ACTIVE BOOLEAN default false,
	IS_PUBLISH BOOLEAN default FALSE
)

create table CHAPTER(
	ID SERIAL primary key,
	CHAPTER_NAME VARCHAR(200) unique not null,
	DESCRIPTION VARCHAR(500),
	CHAPTER_CONTENT VARCHAR(5024),
	SEQ INT not null,
	COURSE_ID INT not null,
	IS_ACTIVE BOOLEAN default false,
	IS_PUBLISH BOOLEAN default false,
	FOREIGN KEY(COURSE_ID) REFERENCES course(id)
)