    CREATE DATABASE Bank_System;
    
    USE Bank_System;

    CREATE TABLE bank( name CHAR(255) , address VARCHAR(255) , bank_code VARCHAR(255) , bank_id INT primary key auto_increment);

    CREATE TABLE customer (customer_id INT auto_increment primary key, customer_name CHAR(255) , customer_email VARCHAR(255) , customer_phone INT , customer_email VARCHAR(255) , customer_address VARCHAR(255) , customer_cardNumber BigInt  , customer_password INT);

    CREATE TABLE Account (account_id INT auto_increment primary key , account_Number BigInt , account_balance INT, account_type VARCHAR(255) , bank_id INT , customer_id INT ) ;
    
    ALTER TABLE Account add constraint bank_id int , foreign key (bank_id) references bank (bank_id);

    ALTER TABLE Account add constraint customer_id int , foreign key (customer_id) references customer (customer_id);

    CREATE TABLE Transaction (transaction_id INT auto_increment primary key , transaction_date Date , transaction_amount INT , transaction_type CHAR(255) , current_balance int , account_id int ); 

    alter table transaction add constraint account_id foreign key (account_id) references Account (account_id);

    CREATE TABLE Atm(atm_id int auto_increment primary key , deposite BOOL , withdraw BOOL , check_balance BOOL , transaction_id INT );

    alter table Atm add constraint transaction_id foreign key (transaction_id) references transaction (transaction_id);
