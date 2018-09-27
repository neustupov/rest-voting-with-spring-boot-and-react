INSERT INTO app_user (id, name, email, enabled, password, registered)
VALUES (100000, 'User', 'user@yandex.ru', true, '{noop}password', '2018-09-01'),
       (100001, 'Admin', 'admin@yandex.ru', true, '{noop}admin', '2018-09-01');

INSERT INTO menu (id, restaurant_id, ADD_DATE)
VALUES (100002, '2015-05-01'),
       (100003, '2015-05-02'),
       (100004, '2015-05-03'),
       (100005, '2015-05-01'),
       (100006, '2015-05-02'),
       (100002, '2015-05-02'),
       (100002, CURRENT_DATE);