-- SQL Challenges - Day 2 (JOINs, CTEs, Triggers)
select invoice.invoice_id, customer.first_name, customer.last_name, invoice.total
from invoice
join customer on invoice.customer_id = customer.customer_id;

select invoice.invoice_id, customer.first_name, invoice.total
from invoice
join customer on invoice.customer_id = customer.customer_id
where invoice.total > 30.00;

with usa_customers as (
    select customer_id from customer where country = 'USA'
)
select invoice.*
from invoice
join usa_customers on invoice.customer_id = usa_customers.customer_id
where invoice.invoice_date > CURRENT_DATE - INTERVAL '6 months';

create table record_logs(
    log_id serial primary key,
    record_id integer,
    field_changed varchar(50),
    last_update timestamp default current_timestamp,
    old_value text,
    new_value text
);

create or replace function log_customer_changes()
returns trigger
language plpgsql
as $$
begin
    if old.first_name is distinct from new.first_name then
        insert into record_logs (record_id, field_changed, old_value, new_value)
        values (old.customer_id, 'first_name', old.first_name, new.first_name);
    end if;

    if old.last_name is distinct from new.last_name then
        insert into record_logs (record_id, field_changed, old_value, new_value)
        values (old.customer_id, 'last_name', old.last_name, new.last_name);
    end if;

    if old.email is distinct from new.email then
        insert into record_logs (record_id, field_changed, old_value, new_value)
        values(old.customer_id, 'email', old.email, new.email);
    end if;

    return new;
end;
$$;

create trigger customer_change_trigger
after update on customer
for each row
execute function log_customer_changes();

