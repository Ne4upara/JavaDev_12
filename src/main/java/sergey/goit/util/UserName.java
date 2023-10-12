package sergey.goit.util;

public class UserName {

    public static String userName(String name){
        String un = name.trim();
        if (un.isEmpty()){
            return "Аноним";
        }else{
            return un;
        }
    }
}
