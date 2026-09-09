-- CHALLENGES - SQL
select * from customer;
select * from customer where state = 'AZ';
select * from invoice where invoice_date < current_date - interval '6 months';
update customer set phone = NULL where phone !~ '^\+1 \d{3} \d{3}-\d{4}$';
select * from track where milliseconds > 180000;
update customer set country = 'USA', address = NULL, city = NULL, state = NULL where country != 'USA';

create or replace function total_spending(cust_id integer)
returns numeric
as $$
    select sum(total) from invoice where customer_id = cust_id;
$$ language sql;

--test the function
select total_spending(5);

--stored procedure to update an employee's manager with validation
create or replace procedure update_manager(emp_id integer, new_mgr_id integer)
language plpgsql   
as $$
begin
    if emp_id = new_mgr_id then
        raise exception 'An employee cannot report to themselves.';
    end if;

    if not exists (select 1 from employee where employee_id = new_mgr_id) then
        raise exception 'The new manager does not exist.';
    end if;

    if exists (select 1 from employee where employee_id = new_mgr_id and reports_to = emp_id) then
        raise exception 'This would create a circular management relationship.';
    end if;

    update employee set reports_to = new_mgr_id where employee_id = emp_id;
end;
$$;

create schema pets;

create table pets.customer(
    customer_id serial primary key,
    name varchar(50) not null
);

create table pets.pet(
    pet_id serial primary key,
    name varchar(50) not null,
    species varchar(30),
    customer_id integer,
    foreign key (customer_id) references pets.customer(customer_id)
);

insert into pets.customer (name) values ('Paribesh'), ('Alex');
insert into pets.pet (name, species, customer_id) values
    ('Rex', 'Dog', 1),
    ('Whiskers', 'Cat', 1),
    ('Bubbles', 'Fish', 2);