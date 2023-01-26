package Manipal_practise

import java.sql.*

class BankSystem {
    var connect:Connection?= null
    fun createConnection(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "1234")
            if (connect != null){
                println("Connection Online")

            }
        }catch (e:SQLException){
            println(e)
        }
    }


    fun addUser(){
        var prepState:PreparedStatement? = null
        var insertInto = "insert into customer(customer_name, customer_email , customer_cardNo , customer_password , customer_phoneNumber) values(? , ? , ? , ? , ?);"
        try {
            prepState = connect!!.prepareStatement(insertInto)
            println("Enter Customer Name")
            prepState.setString(1 , readlnOrNull())
            println("Enter Customer Email")
            prepState.setString(2 , readlnOrNull())
            println("Enter Customer Card Number")
            prepState.setLong(3, readln().toLong())
            println("Set Your Password")
            prepState.setLong(4, readln().toLong())
            println("Enter Your Phone Number")
            prepState.setLong(5, readln().toLong())
            var status = prepState.executeUpdate()
            if (status > 0){
                println("Data Taken")
            }else{
                println("Data Not Taken")
            }
        }catch (e:SQLException){
            println(e)
        }

    }

    fun addAccount(){
        var prepState:PreparedStatement? = null
        var insertIntoAccount = "insert into account(accountNumber, accountBalance , accountType ) values( ? , ? , ? );"
        try {
            prepState = connect!!.prepareStatement(insertIntoAccount)
            println("Enter your Desired Account Number")
            prepState.setLong(1, readln().toLong())
            println("Enter your Deposit Amount")
            prepState.setLong(2, readln().toLong())
            println("Enter your Account Type")
            prepState.setString(3 , readlnOrNull())
            var status = prepState.executeUpdate()
            if (status > 0){
                println("Data Taken")
            }else{
                println("Data Not Taken")
            }
        }catch (e:SQLException){
            println(e)
        }

    }


    fun searchUser(){
        var prepState: Statement? = null
        var res: ResultSet? = null
        println("Enter your Card Number")
        var cd = readlnOrNull()!!.toLong()
        var search = "select * from customer where customer_cardNo =" +cd+";"
        try {
            prepState = connect!!.createStatement()
            res = prepState.executeQuery(search)
            while (res.next()){
                println("Customer Name:- "+"${res.getString("customer_name")}\t")
                println("Customer Email Address:- " +"${res.getString("customer_email")}\t")
                println("Customer Phone Number:- " +"${res.getLong("customer_phoneNumber")}\t")
            }
        }catch (e:SQLException){
            println(e)
        }

    }

    fun deleteUser(){
        var prepState:PreparedStatement? = null
        println("Enter Card Number")
        var deleted = readln().toLong()
        var delete = "DELETE from customer where customer_cardNo =" + deleted + ";"
        try {
            prepState = connect!!.prepareStatement(delete)
            var status = prepState.executeUpdate()
            if (status>0){
                println("Deleted")
            }else{
                println("Not Found")
            }
        }catch (e:SQLException){
            println(e)
        }
    }

    fun deleteAccount(){
        var prepState:PreparedStatement? = null
        println("Enter Account Number")
        var deleted = readln().toLong()
        var delete = "DELETE from account where accountNumber =" + deleted + ";"
        try {
            prepState = connect!!.prepareStatement(delete)
            var status = prepState.executeUpdate()
            if (status>0){
                println("Deleted")
            }else{
                println("Not Found")
            }
        }catch (e:SQLException){
            println(e)
        }
    }

    fun closeConnection(){
        try {
        connect?.close()
        }catch (e:SQLException){
            println(e)
        }
    }
}

fun main() {
    var bankobj = BankSystem()
    bankobj.createConnection()

    println("Welcome to Apna Bank")

    start@ while (true){

        println("Press 1 for Add User")

        println("Press 2 for Search User")

        println("Press 3 for Delete User")

        println("Press 4 to Exit")

        var input = readlnOrNull()!!.toInt()

         when(input){
            1 -> {
                bankobj.addUser()
                bankobj.addAccount()
            }

            2 -> {
                bankobj.searchUser()
            }

            3 -> {
                bankobj.deleteUser()
                bankobj.deleteAccount()
            }

            4 -> {
                bankobj.closeConnection()
                break@start
            }
        }
    }
}