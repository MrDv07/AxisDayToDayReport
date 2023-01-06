package Manipal_practise;

import java.util.Scanner;

interface blueprint{
    void getTotalCost();
    void getTotalextendedCost();
    void getTotalDiscount();
}

class Retailcalculations implements blueprint {
    Scanner sc = new Scanner(System.in);
    final float tax_cosmetics = 0.07f;
    final float tax_perfume = 0.012f;
    final float tax_clothes = 0.04f;
    final float final_discount =0.02f;
    final int set_of_cosmetics = 10000;
    final int set_of_perfume = 5000;
    final int bundle_of_clothes = 7000;
    float final_total_cost_cosmetic;
    float final_total_cost_perfume;
    float final_total_cost_of_clothes;
    float total_sum;
    float final_total_amount;


    @Override
    public void getTotalCost() {
        System.out.println("Enter the quantity(in sets) for Cosmetics ");
        int cm = sc.nextInt();
        System.out.println("Enter the quantity(in sets) for Perfumes");
        int pf = sc.nextInt();
        System.out.println("Enter the quantity(in bundles) for Clothes");
        int cl = sc.nextInt();

        int total_cost_cosmetic = cm * set_of_cosmetics;
        final_total_cost_cosmetic = (total_cost_cosmetic + (total_cost_cosmetic * tax_cosmetics));
        int total_cost_perfume = pf * set_of_perfume;
        final_total_cost_perfume = total_cost_perfume + (total_cost_perfume * tax_perfume);
        int total_cost_clothes = cl * bundle_of_clothes;
        final_total_cost_of_clothes = total_cost_clothes + (total_cost_clothes * tax_clothes);

        System.out.println("Cost of Cosmetic Set: " + final_total_cost_cosmetic );
        System.out.println("Cost of Perfume set: " + final_total_cost_perfume);
        System.out.println("Cost of Clothes Bundle: "+ final_total_cost_of_clothes);


    }

    @Override
    public void getTotalextendedCost() {
          total_sum = final_total_cost_cosmetic + final_total_cost_perfume + final_total_cost_of_clothes;
          System.out.println("Total of The 3 Items without Final Discount:-"+" "+ total_sum);
    }

    @Override
    public void getTotalDiscount() {
        final_total_amount = total_sum - (total_sum* final_discount);
        System.out.println("Amount after final discount:-"+" "+ final_total_amount);
    }

    public void Final(){
        getTotalCost();
        getTotalextendedCost();
        getTotalDiscount();
    }
}

    public class Day_8_task_1 {
        public static void main(String[] args) {
           var shop = new Retailcalculations();
            shop.Final();
    }
}
