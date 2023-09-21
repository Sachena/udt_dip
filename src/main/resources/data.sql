INSERT INTO mobile_phone (MANUFACTURER, MODEL, NAME, USIM, DESCRIPTION, PRICE) VALUES ('SAMSUNG', 'SM-F926N512', '갤럭시 Z 폴드3 512G', 'NANO', '', 2097700);
INSERT INTO mobile_phone (MANUFACTURER, MODEL, NAME, USIM, DESCRIPTION, PRICE) VALUES ('SAMSUNG', 'SM-F926N', '갤럭시 Z 폴드3', 'NANO', '', 1998700);
INSERT INTO mobile_plan (name, price, description) values ('5G 프리미어 에센셜', '85000', '');
INSERT INTO mobile_plan (name, price, description) values ('5G 스탠다드', '75000', '');
INSERT INTO customer (name, resident_number) values ('테스터', '123456-1234567');
INSERT INTO contract (phone_number, first_contract_date, customer_id, mobile_phone_id, mobile_plan_id, mobile_plan_discount_id, contract_change_datetime, communication_expense) values ('010-1234-5678', '2023-07-10 15:04:00.0', 1, 1, 1, 1, '2023-07-10 15:04:00.0', 85000.0);
INSERT INTO mobile_plan_discount (mobile_plan_id, name, ratio, description) values (1, '선택약정(24)', 25.0, '24개월');