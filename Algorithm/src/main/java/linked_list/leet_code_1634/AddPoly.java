package linked_list.leet_code_1634;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/31 15:00
 * @Url :
 * @Level :    medium hard
 * @Desc :
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/add-two-polynomials-represented-as-linked-lists/solution/zhe-chong-lian-biao-ti-ni-you-xiu-kao-lu-anyy/
 */
public class AddPoly {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null) return poly2;
        if (poly2 == null) return poly1;
        if (poly1.power == poly2.power) {
            poly1.coefficient += poly2.coefficient;
            // 终止条件
            if (poly1.coefficient == 0){
                return addPoly(poly1.next, poly2.next);
            }
            poly1.next = addPoly(poly1.next, poly2.next);
            return poly1;
        } else if (poly1.power > poly2.power) {
            poly1.next = addPoly(poly1.next, poly2);
            return poly1;
        } else {
            poly2.next = addPoly(poly1, poly2.next);
            return poly2;
        }


    }

}
