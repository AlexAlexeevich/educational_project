CREATE TABLE IF NOT EXISTS Organization (
    id  		 INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name		 VARCHAR(100) NOT NULL 	COMMENT 'Название',
    full_name	 VARCHAR(100) NOT NULL 	COMMENT 'Полное название',
    inn		     VARCHAR(12) NOT NULL  	COMMENT 'ИНН',
    kpp 	     VARCHAR(9) NOT NULL 	COMMENT 'КПП',
    address 	 VARCHAR(200) NOT NULL 	COMMENT 'Адрес',
    phone 		 VARCHAR(25) 		    COMMENT 'Номер телефона',
    is_active 	 BOOLEAN                COMMENT 'Активность'
    );
COMMENT ON TABLE Organization IS 'Организация';


CREATE TABLE IF NOT EXISTS Office (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name		 VARCHAR(100) NOT NULL 	COMMENT 'Название',
    address 	 VARCHAR(200) NOT NULL 	COMMENT 'Адрес',
    phone 		 VARCHAR(25) 		    COMMENT 'Номер телефона',
    is_active 	 BOOLEAN                COMMENT 'Активность',
    org_id		 INTEGER NOT NULL	    COMMENT 'Уникальный идентификатор организации'
    );
CREATE INDEX IX_Office_org_id ON Office(org_id);
COMMENT ON TABLE Office IS 'Офис';


CREATE TABLE IF NOT EXISTS User (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    first_name	 VARCHAR(100) NOT NULL 	COMMENT 'Имя',
    second_name	 VARCHAR(100) NOT NULL 	COMMENT 'Фамилия',
    middle_name	 VARCHAR(100) NOT NULL 	COMMENT 'Отчество',
    address 	 VARCHAR(200) NOT NULL 	COMMENT 'Адрес',
    phone 		 VARCHAR(25) 		    COMMENT 'Номер телефона',
    position	 VARCHAR(50) NOT NULL 	COMMENT 'Название',
    is_identified 	 BOOLEAN            COMMENT 'Идентификация',
    office_id	 INTEGER NOT NULL	    COMMENT 'Уникальный идентификатор офиса',
    citizenship_id INTEGER NOT NULL     COMMENT 'Уникальный идентификатор гражданства'
    );
CREATE INDEX IX_User_office_id ON User(office_id);
CREATE INDEX IX_User_citizenship_id ON User(citizenship_id);
COMMENT ON TABLE Office IS 'Сотрудник';


CREATE TABLE IF NOT EXISTS Doc (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name	 	 VARCHAR(100) 	 	    COMMENT 'Название документа',
    code		 VARCHAR(2)  	 	    COMMENT 'Код документа'
    );
COMMENT ON TABLE Office IS 'Документ';


CREATE TABLE IF NOT EXISTS Country (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name	 	 VARCHAR(100) 	 	    COMMENT 'Страна гражданства',
    code		 VARCHAR(3)  	 	    COMMENT 'Код гражданства'
    );
COMMENT ON TABLE Office IS 'Гражданство';


CREATE TABLE IF NOT EXISTS User_doc (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    doc_id       INTEGER NOT NULL       COMMENT 'Уникальный идентификатор документа',
    doc_number	 VARCHAR(50)  		    COMMENT 'Номер документа',
    doc_date	 DATE	  		        COMMENT 'Дата выдачи'
    );
CREATE INDEX IX_User_doc_doc_id ON User_doc(doc_id);
COMMENT ON TABLE Office IS 'Документ сотрудника';


ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User ADD  FOREIGN KEY (citizenship_id) REFERENCES Country (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User_doc ADD FOREIGN KEY (id) REFERENCES User (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User_doc ADD  FOREIGN KEY (doc_id) REFERENCES Doc (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;
