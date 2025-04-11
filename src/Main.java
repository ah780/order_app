import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MenuIteam[] menuo={
          new MenuIteam("توست شنيتسل",8),
          new MenuIteam("توست فاهيتا",10),
          new MenuIteam("توست نقانق ",4),
          new MenuIteam("توست نقانق مع جبنة ",5),
          new MenuIteam("توست بيتزا",7)  ,

        };
        System.out.println("************القاءمة***********");
        for(int i=0 ; i<menuo.length;i++){
            System.out.println((i+1)+"."+menuo[i].getInfo());
        }
        List<MenuIteam> order = new ArrayList<>();
        while(true) {
            System.out.println("اختر رقم الصنف (او 0 لانهاء الطلب");
            int choice = in.nextInt();
            if(choice == 0) {break;}
            if(choice>0 && choice<=menuo.length) {
                order.add(menuo[choice-1]);
            }
            else{
                System.out.println("الرقم المدخل غير صالح");
            }
        }
        System.out.println("**********الفاتورة**********");
        double total = 0;
        for(MenuIteam item:order){
            System.out.println(item.name+": "+item.price+" شيكل ");
            total+=item.price;
        }
        System.out.println("المجموع: "+total + "شيكل");
    }
}