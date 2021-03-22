INSERT INTO Doc (id, name, code)
 VALUES (1, 'Паспорт гражданина РФ', '21');

INSERT INTO Country (id, name, code)
 VALUES (1, 'Российская Федерация', '643');



INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 'ООО Зима', 'Общество с ограниченной ответственностью Зима', '123456789012', '123456789',
        'ул. Цветочная, 10', '+79995553333', 1);

INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 'ООО Лето', 'Общество с ограниченной ответственностью Лето', '111456789012', '111456789',
        'ул. Солнечная, 15', '+79095663300', 1);


INSERT INTO Office (id, name, address, phone, is_active, org_id)
 VALUES (1, 'Зима на Лесной', 'ул. Лесная, 10', '+79995553322', 1, 1);

INSERT INTO Office (id, name, address, phone, is_active, org_id)
 VALUES (2, 'Лето на Снежной', 'ул. Снежная, 25', '+79097778855', 1, 2);


INSERT INTO User (id, first_name, second_name, middle_name, address, phone, position, is_identified, office_id, citizenship_id)
 VALUES (1, 'Иван', 'Иванов', 'Иванович', 'ул. Лесная, 20', '+79990003322', 'manager', 1, 1, 1);

INSERT INTO User (id, first_name, second_name, middle_name, address, phone, position, is_identified, office_id, citizenship_id)
 VALUES (2, 'Иван', 'Петр', 'Петрович', 'ул. Лесная, 21', '+79990003323', 'manager', 1, 1, 1);

INSERT INTO User (id, first_name, second_name, middle_name, address, phone, position, is_identified, office_id, citizenship_id)
 VALUES (3, 'Петров', 'Петр', 'Петрович', 'ул. Снежная, 55', '+79000123456', 'manager', 1, 2, 1);

INSERT INTO User (id, first_name, second_name, middle_name, address, phone, position, is_identified, office_id, citizenship_id)
 VALUES (4, 'Петров', 'Иван', 'Иванович', 'ул. Снежная, 56', '+79000123411', 'manager', 1, 2, 1);


INSERT INTO User_doc (id, doc_id, doc_number, doc_date)
 VALUES (1, 1, '8888 123456', '2000-12-05');

INSERT INTO User_doc (id, doc_id, doc_number, doc_date)
 VALUES (2, 1, '8889 1234599', '2001-10-15');

INSERT INTO User_doc (id, doc_id, doc_number, doc_date)
 VALUES (3, 1, '5556 654378', '1992-10-25');

INSERT INTO User_doc (id, doc_id, doc_number, doc_date)
 VALUES (4, 1, '5555 654321', '1990-05-25');