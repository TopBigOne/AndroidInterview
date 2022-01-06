package design.leet_code_355.resolve_1;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/5 18:28
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 推文
 * @Counter :
 * @Answer :
 */
public class Tweet {
    public int id;
    public  long time;
    public Tweet next;

    /**
     *  推文
     * @param id 推文内容id
     * @param time 发布推文的时间
     */
    public Tweet(int id, long time) {
        this.id = id;
        this.time = time;
    }
}
