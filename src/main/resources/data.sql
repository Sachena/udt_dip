INSERT INTO mobile_phone (MANUFACTURER, MODEL, NAME, USIM, DESCRIPTION, PRICE) VALUES ('SAMSUNG', 'SM-F926N512', '갤럭시 Z 폴드3 512G', 'NANO', '', 2097700);
INSERT INTO mobile_phone (MANUFACTURER, MODEL, NAME, USIM, DESCRIPTION, PRICE) VALUES ('SAMSUNG', 'SM-F926N', '갤럭시 Z 폴드3', 'NANO', '', 1998700);
INSERT INTO mobile_plan (name, price, description) values ('5G 프리미어 에센셜', '85000', '');
INSERT INTO mobile_plan (name, price, description) values ('5G 스탠다드', '75000', '');
INSERT INTO customer (name, resident_number) values ('테스터', '123456-1234567');
INSERT INTO contract (phone_number, first_contract_date, customer_id, mobile_phone_id, mobile_plan_id, contract_change_datetime) values ('010-1234-5678', '2023-07-10 15:04:00.0', 1, 1, 1, '2023-07-10 15:04:00.0');
INSERT INTO product_discount (mobile_phone_id, mobile_plan_id, type, name, price, ratio, description) values (1, 1, 'ratio', '선택약정(24)', 0.0, 25.0, '24개월');
INSERT INTO contract_discount (contract_id, mobile_phone_id, mobile_plan_id, product_discount_id) values (1, 1, 1, 1);
