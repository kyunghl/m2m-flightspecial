-- >>>>>>>>> CUSTOMER <<<<<<<<<
insert into ledger.customers(name, email, address, date_of_birth, created_at) 
values (
    'Bob', 
    'bob@email.com', 
    '01 Gangnam-ro Seoul', 
    '1989-01-02', 
    '2023-02-12 10:10:01+09'
);

insert into ledger.customers(name, email, address, date_of_birth, created_at) 
values (
    'Charlie', 
    'chalie@email.com', 
    '00 Seocho-ro Seoul', 
    '1999-11-11', 
    '2023-02-13 00:00:01+09'
);

-- >>>>>>>>> ACCOUNT <<<<<<<<<
insert into ledger.accounts(customer_no, currency_code, address, balance, created_at) 
values (
    (select max(customer_no) from ledger.customers where email='charlie@email.com'), 
    'USD', 
    '00 Seocho-ro Seoul', 
    100, 
    '2023-02-13 00:00:02+09'
);

insert into ledger.accounts(customer_no, currency_code, address, balance, created_at) 
values (
    (select max(customer_no) from ledger.customers where email='bob@email.com'), 
    'USD', 
    '01 Gangnam-ro Seoul', 
    800, 
    '2023-02-12 10:10:05+09'
);

-- >>>>>>>>> TRANSACTION <<<<<<<<<
