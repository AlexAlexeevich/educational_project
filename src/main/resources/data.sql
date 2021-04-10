INSERT INTO Doc (id, name, code)
VALUES (1, 'Свидетельство о рождении', '03');

INSERT INTO Doc (id, name, code)
VALUES (2, 'Военный билет', '07');

INSERT INTO Doc (id, name, code)
 VALUES (3, 'Паспорт гражданина РФ', '21');


INSERT INTO Country (id, name, code)
 VALUES (1, 'Российская Федерация', '643');

INSERT INTO Country (id, name, code)
VALUES (2, 'Беларусь', '112');


INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 'ООО Зима', 'Общество с ограниченной ответственностью Зима', '123456789012', '123456789',
        'ул. Цветочная, 10', '+79995553333', 1);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 0, 'ООО Лето', 'Общество с ограниченной ответственностью Лето', '111456789012', '111456789',
        'ул. Солнечная, 15', '+79095663300', 1);


INSERT INTO Office (id, version, name, address, phone, is_active, org_id)
 VALUES (1, 0, 'Зима на Лесной', 'ул. Лесная, 10', '+79995553322', 1, 1);

INSERT INTO Office (id, version, name, address, phone, is_active, org_id)
 VALUES (2, 0, 'Лето на Снежной', 'ул. Снежная, 25', '+79097778855', 1, 2);


INSERT INTO User (id, version, first_name, second_name, middle_name, phone, position, is_identified, office_id, citizenship_id)
 VALUES (1, 0, 'Иван', 'Иванов', 'Иванович', '+79990003322', 'manager', 1, 1, 1);

INSERT INTO User (id, version, first_name, second_name, middle_name, phone, position, is_identified, office_id, citizenship_id)
 VALUES (2, 0, 'Иван', 'Петр', 'Петрович', '+79990003323', 'manager', 1, 1, 2);

INSERT INTO User (id, version, first_name, second_name, middle_name, phone, position, is_identified, office_id, citizenship_id)
 VALUES (3, 0, 'Петров', 'Петр', 'Петрович', '+79000123456', 'manager', 1, 2, 2);

INSERT INTO User (id, version, first_name, second_name, middle_name, phone, position, is_identified, office_id, citizenship_id)
 VALUES (4, 0, 'Петров', 'Иван', 'Иванович', '+79000123411', 'manager', 1, 2, 1);


INSERT INTO User_doc (id, version, doc_id, doc_number, doc_date)
 VALUES (1, 0, 1, '8888 123456', '2000-12-05');

INSERT INTO User_doc (id, version, doc_id, doc_number, doc_date)
 VALUES (2, 0, 2, '8889 1234599', '2001-10-15');

INSERT INTO User_doc (id, version, doc_id, doc_number, doc_date)
 VALUES (3, 0, 1, '5556 654378', '1992-10-25');

INSERT INTO User_doc (id, version, doc_id, doc_number, doc_date)
 VALUES (4, 0, 3, '5555 654321', '1990-05-25');