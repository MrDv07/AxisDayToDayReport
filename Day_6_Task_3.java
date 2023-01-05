package Manipal_practise;

class UserInfo1 {
    String name;
    int userid;
    protected int age;
    static String place;
    static String companyname;
    String position;

    public UserInfo1(String name, int userid, int age, String position) {
        this(place , companyname);
        this.name = name;
        this.userid = userid;
        this.age = age;
        this.position = position;
    }

    public UserInfo1(String place, String companyname) {
        this.place = place;
        this.companyname = companyname;
        System.out.println("testing the methods.");
    }
}


    public class Day_6_Task_3 {
        public static void main(String[] args) {

            UserInfo1 us = new UserInfo1("dv", 123 , 25 , "DM");

//            UserInfo1 us1 = new UserInfo1("jbp","axis");


    }


}
