package com.jar.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2/18/21 6:16 PM
 * @Desc : 不间断的调用 intern();
 */
public class MethordAreaOOMByIntern  implements Run{

    String str = "test_jar_jar";

    @Override
    public void execute()  {
        List<String> list  = new ArrayList<>();
        while (true){
            String str2 = str+str;
            str = str2;
            list.add(str.intern());
        }
    }

    public static void main(String[] args) {
        MethordAreaOOMByIntern methordAreaOOMByIntern = new MethordAreaOOMByIntern();
        methordAreaOOMByIntern.execute();

    }


}
