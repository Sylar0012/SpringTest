# MyBatis DB연결 세팅


### 설정방법
- MyBatisConfig 파일 필요
- resources/mapper/*.xml 파일 필요


### 테이블 생성
```sql

USE greendb;

create table stadium(
   id int primary KEY AUTO_INCREMENT,
   name VARCHAR(50) UNIQUE NOT null,
	createdAt TIMESTAMP
);

create table team(
   id int primary KEY AUTO_INCREMENT,
   stadiumid INT,
   name VARCHAR(30) UNIQUE not null,
	createdAt TIMESTAMP
);

create table player(
   id int primary KEY AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   teamid INT,
   position VARCHAR(20) NOT NULL,
   createdAt TIMESTAMP
);

create table outplayer(
   id int primary KEY AUTO_INCREMENT,
   teamid INT,
   playerid INT,
   reason VARCHAR(50) NOT NULL,
   createdAt TIMESTAMP
);
```

### 더미데이터 추가
```sql

-- stadium

INSERT into stadium(name,createdAt) VALUES("사직야구장",NOW());
INSERT into stadium(name,createdAt) VALUES("구덕야구장",NOW());
INSERT into stadium(name,createdAt) VALUES("잠실야구장",NOW());


-- team

INSERT into team(stadiumId,name,createdAt) VALUES(1,"두산",now());
INSERT into team(stadiumId,name,createdAt) VALUES(2,"NC",NOW());
INSERT into team(stadiumId,name,createdAt) VALUES(3,"롯데",now());


-- player

INSERT into player(name,teamId,position,createdAt) VALUES("김민재",1,"타자",now());
INSERT into player(name,teamId,position,createdAt) VALUES("채지선",1,"투수",now());
INSERT into player(name,teamId,position,createdAt) VALUES("알칸타라",1,"외야수",now());

INSERT into player(name,teamId,position,createdAt) VALUES("손민한",2,"타자",now());
INSERT into player(name,teamId,position,createdAt) VALUES("루친스키",2,"투수",now());
INSERT into player(name,teamId,position,createdAt) VALUES("박석민",2,"내야수",now());

INSERT into player(name,teamId,position,createdAt) VALUES("오윤석",3,"타자",now());
INSERT into player(name,teamId,position,createdAt) VALUES("박세웅",3,"투수",now());
INSERT into player(name,teamId,position,createdAt) VALUES("오태근",3,"내야수",now());


commit;
```



