INSERT INTO app_user (id, name, email, enabled, password, registered)
VALUES (100000, 'User', 'user@yandex.ru', true, '{noop}password', '2018-09-01'),
       (100001, 'Admin', 'admin@yandex.ru', true, '{noop}admin', '2018-09-01');


INSERT INTO restaurant (id, name)
VALUES (100002, 'Russia'),
       (100003, 'Ukraine'),
       (100004, 'U Kolyana'),
       (100005, 'Almaz'),
       (100006, 'Fart');

INSERT INTO menu (id, date, restaurant_id)
VALUES (100007, '2018-09-01', 100002),
       (100008, '2018-09-02', 100003),
       (100009, '2018-09-03', 100004),
       (100010, '2018-09-04', 100005),
       (100011, '2018-09-05', 100006),
       (100012, '2018-09-06', 100002),
       (100013, CURRENT_DATE, 100003);

INSERT INTO meal (id, name, price, menu_id)
VALUES (100014, 'Apple', 5, 100007),
       (100015, 'Juice', 10, 100008),
       (100016, 'Potato', 20, 100009),
       (100017, 'Bananas', 30, 100010),
       (100018, 'Bread', 40, 100011),
       (100019, 'Bottle of water', 50, 100012),
       (100020, 'Mango', 100, 100013);

INSERT INTO vote (id, date, app_user_id, restaurant_id)
VALUES (100021, '2018-09-01', 100000, 100002),
       (100022, '2018-09-02', 100000, 100003),
       (100023, '2018-09-03', 100000, 100004),
       (100024, '2018-09-01', 100001, 100005),
       (100025, '2018-09-02', 100001, 100006),
       (100026, '2018-09-03', 100001, 100002);

INSERT INTO restaurant_menus (restaurant_id, menus_id)
VALUES (100002, 100007),
       (100003, 100008),
       (100004, 100009),
       (100005, 100010),
       (100006, 100011),
       (100002, 100012),
       (100003, 100013);
