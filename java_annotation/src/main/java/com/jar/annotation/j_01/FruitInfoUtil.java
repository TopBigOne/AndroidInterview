package com.jar.annotation.j_01;

import java.lang.reflect.Field;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/29 17:55
 * @Desc : 注解处理器
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        StringBuilder strFruitName = new StringBuilder("水果名称：");
        StringBuilder strFruitColor = new StringBuilder("水果颜色：");
        String strFruitProvince = "供应商：";
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName.append(fruitName.value());
                System.out.println(strFruitName);
                continue;
            }

            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor.append(fruitColor.fruitColor().toString());
                System.out.println(strFruitColor);
                continue;
            }

            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvince = "供应商编号：" + fruitProvider.id() + " 供应商名称 ： "
                        + fruitProvider.name() + " 供应商地址 ： " + fruitProvider.address();
                System.out.println(strFruitProvince);

                continue;
            }
        }

    }
}
