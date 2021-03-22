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
    office_id	 INTEGER NOT NULL	    COMMENT 'Уникальный идентификатор офиса'
    );
CREATE INDEX IX_User_office_id ON User(office_id);
COMMENT ON TABLE Office IS 'Сотрудник';


CREATE TABLE IF NOT EXISTS Doc (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name	 	 VARCHAR(100) 	 	    COMMENT 'Название документа',
    code		 VARCHAR(2)  	 	    COMMENT 'Код документа'
    );
CREATE UNIQUE INDEX UX_Doc_code ON Doc(code);
COMMENT ON TABLE Office IS 'Документ';


CREATE TABLE IF NOT EXISTS Country (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name	 	 VARCHAR(100) 	 	    COMMENT 'Страна гражданства',
    code		 VARCHAR(3)  	 	    COMMENT 'Код гражданства'
    );
CREATE UNIQUE INDEX UX_Country_code ON Country(code);
COMMENT ON TABLE Office IS 'Гражданство';


CREATE TABLE IF NOT EXISTS User_doc (
    id		     INTEGER 		        COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    doc_code	 VARCHAR(2)  		    COMMENT 'Код документа',
    doc_number	 VARCHAR(50)  		    COMMENT 'Номер документа',
    doc_date	 DATE	  		        COMMENT 'Дата выдачи',
    citizenship_code VARCHAR(3)		    COMMENT 'Код гражданства'
    );
CREATE INDEX IX_User_doc_doc_code ON User_doc(doc_code);
CREATE INDEX IX_User_doc_citizenship_code ON User_doc(citizenship_code);
COMMENT ON TABLE Office IS 'Документ сотрудника';


ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User_doc ADD FOREIGN KEY (id) REFERENCES User_doc (id)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User_doc ADD  FOREIGN KEY (doc_code) REFERENCES Doc (code)
    ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE User_doc ADD  FOREIGN KEY (citizenship_code) REFERENCES Country (code)
    ON DELETE RESTRICT ON UPDATE CASCADE;