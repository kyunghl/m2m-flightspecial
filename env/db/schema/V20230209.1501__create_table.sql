-- >>>>>>>>> CUSTOMER <<<<<<<<<
create table if not exists ledger.customers
(
    customer_no                   integer GENERATED ALWAYS AS IDENTITY,
    name                          varchar(255),
    email                         varchar(255),
    address                       varchar(255),
    date_of_birth                 DATE,
    created_at                    TIMESTAMP,
    primary key (customer_no)
);

-- >>>>>>>>> ACCOUNT <<<<<<<<<
create table if not exists ledger.accounts
(
    account_no                    integer GENERATED ALWAYS AS IDENTITY,
    customer_no                   integer,
    currency_code                 varchar(3),
    address                       varchar(255),
    balance                       bigint,
    created_at                    TIMESTAMP,
    primary key (account_no),
    foreign key (customer_no) references ledger.customers(customer_no)
);

-- >>>>>>>>> TRANSACTION <<<<<<<<<
create table if not exists ledger.transactions
(
    transaction_no                integer GENERATED ALWAYS AS IDENTITY,
    account_no                    integer,
    transaction_type              smallint, -- 1: DEPOSIT, 2: WITHDRAWAL, 3: TRANSFER
    amount                        bigint,
    currency_code                 varchar(3),
    created_at                    TIMESTAMP,
    primary key (transaction_no),
    foreign key (account_no) references ledger.accounts(account_no)
);
