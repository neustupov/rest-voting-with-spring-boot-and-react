INSERT INTO role (id, name)
VALUES (100000, 'ROLE_USER'),
       (100001, 'ROLE_ADMIN');

/* User password -> password, Admin password -> admin, https://www.devglan.com/online-tools/bcrypt-hash-generator*/
INSERT INTO app_user (id, name, email, enabled, password, registered)
VALUES (100002, 'User', 'user@yandex.ru', true, '$2a$04$.IBcD1IdKEKLNCUYM/SkQeOtsjws356WSu.rMT2/mGi325KVwmCKG',
        '2018-09-01'),
       (100003, 'Admin', 'admin@yandex.ru', true, '$2a$04$vPfBHZ/i5i.DaA/s7dPG3.HZqvH.7RJIft//WdWlnym4I6TOuR1xC',
        '2018-09-01');

INSERT INTO user_role (user_id, role_id)
VALUES (100002, 100000),
       (100003, 100000),
       (100003, 100001);

INSERT INTO restaurant (id, name)
VALUES (100004, 'Russia'),
       (100005, 'Ukraine'),
       (100006, 'U Kolyana'),
       (100007, 'Almaz'),
       (100008, 'Fart');

INSERT INTO menu (id, date, restaurant_id)
VALUES (100009, '2018-09-01', 100004),
       (100010, '2018-09-02', 100005),
       (100011, '2018-09-03', 100006),
       (100012, '2018-09-04', 100007),
       (100013, '2018-09-05', 100008),
       (100014, '2018-09-06', 100004),
       (100015, CURRENT_DATE, 100005);

INSERT INTO meal (id, name, price, menu_id)
VALUES (100016, 'Apple', 5, 100009),
       (100017, 'Juice', 10, 100010),
       (100018, 'Potato', 20, 100011),
       (100019, 'Bananas', 30, 100012),
       (100020, 'Bread', 40, 100013),
       (100021, 'Bottle of water', 50, 100014),
       (100022, 'Mango', 100, 100015);

INSERT INTO vote (id, date, app_user_id, restaurant_id)
VALUES (100023, '2018-09-01', 100002, 100004),
       (100024, '2018-09-02', 100002, 100005),
       (100025, '2018-09-03', 100002, 100006),
       (100026, '2018-09-01', 100003, 100007),
       (100027, '2018-09-02', 100003, 100008),
       (100028, '2018-09-03', 100003, 100004);

INSERT INTO restaurant_menus (restaurant_id, menus_id)
VALUES (100004, 100009),
       (100005, 100010),
       (100006, 100011),
       (100007, 100012),
       (100008, 100013),
       (100004, 100014),
       (100005, 100015);
