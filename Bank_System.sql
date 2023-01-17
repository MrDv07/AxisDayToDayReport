    -- CREATE TABLE bank( name CHAR(255) , address VARCHAR(255) , bank_code VARCHAR(255) , bank_id INT primary key auto_increment);

    -- ALTER TABLE Account add constraint bank_id int , foreign key (bank_id) refences bank (bank_id);

    -- CREATE TABLE Transaction (transaction_id INT auto_increment primary key , transaction_date Date , transaction_amount INT , transaction_type CHAR(255) , current_balance int , account_id int ); 

    -- alter table transaction add constraint account_id foreign key (account_id) references Account (account_id);

    -- CREATE TABLE Atm(atm_id int auto_increment primary key , deposite BOOL , withdraw BOOL , check_balance BOOL , transaction_id INT );

    -- alter table Atm add constraint transaction_id foreign key (transaction_id) references transaction (transaction_id);
