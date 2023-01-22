
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

class customer {
    var tran = arrayListOf<bookingTransaction>()
    var name = ""
    var age = 0
    var place = ""

    fun addCustomer(){
        println("Enter your Name ")
        name = readlnOrNull().toString()
        println("Enter Your Age ")
        age= readlnOrNull()!!.toInt()
        println("Enter Your Place ")
        place = readlnOrNull().toString()
    }

    fun transactionhist(){
        for (t in tran){
            println("------------")
            println("Date:- ${t.date}")
            println("Ticket Type:- ${t.ticketType}")
            println("Source Station:- ${t.sourceT}")
            println("Destination Station:- ${t.destinationT}")
            println("Total Fare:- ${t.ticketFare}")
        }
    }
}

class ticket {
    var source=""
    var destination = ""
    var date = LocalDateTime.now()
    var seatNumber = 1

    fun addTicket(){
        println("Enter your Source Station")
        source = readlnOrNull().toString()
        println("Enter your destination Station")
        destination = readlnOrNull().toString()
    }

    fun ticketfor1ac(customer: customer):Double{
        var totalfare = 2000.0
        var tc = bookingTransaction()
        tc.addTransaction("First Ac", source , destination , totalfare)
        customer.tran.add(tc)
        return totalfare
    }
    fun ticketfor2ac(customer: customer):Double{
        var totalfare = 1000.0
        var tc = bookingTransaction()
        tc.addTransaction("Second Ac", source , destination , totalfare)
        customer.tran.add(tc)
        return totalfare
    }
    fun ticketfor3ac(customer: customer): Double{
        var totalfare = 500.0
        var tc = bookingTransaction()
        tc.addTransaction("Third Ac", source , destination , totalfare)
        customer.tran.add(tc)
        return totalfare
    }

}
class bookingTransaction {
        var date = LocalDateTime.now()
        var ticketType = ""
        var sourceT = ""
        var destinationT = ""
        var ticketFare = 0.0

    fun addTransaction(ticketType: String , sourceT: String , destinationT: String ,ticketFare: Double){
        this.date = LocalDateTime.now()
        this.ticketType = ticketType
        this.sourceT = sourceT
        this.destinationT = destinationT
        this.ticketFare = ticketFare
    }

}



fun main() {
        var map: HashMap<String , customer> = HashMap()
        println("Welcome to Reservation System Using kotlin")
        var exit = true
        while(exit) {
            println("Press 1 for Registration")
            println("Press 2 for Customer Display")
            println("Press 3 for Ticket Booking")
            println("Press 4 for Transaction History")
            println("Press 5 for Exit")

            var input = readlnOrNull()?.toInt()

            when (input) {

                1 -> {
                    var obj = customer()
                    obj.addCustomer()
                    map.put(obj.name, obj)
                }

                2 -> {
                    println("Enter Your Name to see the INFO")
                    var n = readlnOrNull().toString()
                    if (map.containsKey(n)) {
                    println("Customer Found");
                    println(map.get(n)!!.name)
                    println(map.get(n)!!.age)
                    println(map.get(n)!!.place)

                    }
                    else {
                        System.out.println("Not Found");
                    }
                }

                3 -> {
                    var tc = ticket()
                    println("Enter your name")
                    var name1 = readlnOrNull().toString()
                    if (map.containsKey(name1)){
                    tc.addTicket()
                        var exit = true
                        while(exit){
                        println("Enter 1 for First Ac")
                        println("Enter 2 for Second Ac")
                        println("Enter 3 for Third Ac")
                        println("Enter 4 to go to Main Menu")
                        var input = readlnOrNull()!!.toInt()
                            when(input){
                                1 -> {
                                    println("Date And Time of Reservation:- ${tc.date}")
                                    println("Name:- ${map.get(name1)!!.name}")
                                    println("Age:- ${map.get(name1)!!.age}")
                                    println("Place:- ${map.get(name1)!!.place}")
                                    println("Source Station:- ${tc.source} ")
                                    println("Destination Station:- ${tc.destination}")
                                    println("Ticket Type:- First AC")
                                    println("Total fare:- " + tc.ticketfor1ac(map.get(name1)!!))
                                }

                                2 -> {
                                    println("Date And Time of Reservation:- ${tc.date}")
                                    println("Name:- ${map.get(name1)!!.name}")
                                    println("Age:- ${map.get(name1)!!.age}")
                                    println("Place:- ${map.get(name1)!!.place}")
                                    println("Source Station:- ${tc.source} ")
                                    println("Destination Station:- ${tc.destination}")
                                    println("Ticket Type:- Second AC")
                                    println("Total fare:- " + tc.ticketfor2ac(map.get(name1)!!))
                                }
                                3 -> {
                                    println("Date And Time of Reservation:- ${tc.date}")
                                    println("Name:- ${map.get(name1)!!.name}")
                                    println("Age:- ${map.get(name1)!!.age}")
                                    println("Place:- ${map.get(name1)!!.place}")
                                    println("Source Station:- ${tc.source} ")
                                    println("Destination Station:- ${tc.destination}")
                                    println("Ticket Type:- Third AC")
                                    println("Total fare:- " + tc.ticketfor3ac(map.get(name1)!!))
                                }

                                4 -> exit = false
                            }
                        }
                    }
                }
                4 -> {
                    println("Enter your name")
                    var name2 = readlnOrNull().toString()
                    if (map.containsKey(name2)){
                        map.get(name2)?.transactionhist()
                    }
                    else{
                        println("Not Available")
                    }
                }

                5 -> exit = false
            }
        }
}