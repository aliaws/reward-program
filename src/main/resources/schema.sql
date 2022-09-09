create table customers
(
    id   int auto_increment primary key,
    name varchar(255) null
);

create table `transactions`
(
    `id`           int auto_increment primary key,
    `customer_id`  float        not null,
    `date`         date     null,
    `month`        varchar(255) null,
    `quantity`     float        not null,
    `sales_amount` float        not null
);

create table reward
(
    customer_id   int   not null,
    date          date  null,
    reward_points float not null,
    sales_amount  float not null
);