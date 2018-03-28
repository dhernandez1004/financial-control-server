create table book_entry_types (
  id number(1) primary key,
  type_name varchar(10)
);

insert into book_entry_types(id, type_name) values (1, 'INCOME');
insert into book_entry_types(id, type_name) values (2, 'EXPENSES');

create table book_entries (
  id number(10) auto_increment primary key,
  concept varchar(255),
  amount number(8,2),
  type_id number(1),
  punctual_entry boolean,
  avoidable_entry boolean,
  entry_date date,
  foreign key (type_id) references book_entry_types(id)
);

create table fixed_book_entries (
  id number(10) auto_increment primary key,
  concept varchar(255),
  amount number(8,2),
  type_id number(1),
  end_date date,
  foreign key (type_id) references book_entry_types(id)
);




