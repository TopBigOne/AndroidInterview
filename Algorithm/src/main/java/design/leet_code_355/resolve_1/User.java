package design.leet_code_355.resolve_1;

import java.util.HashSet;
import java.util.Set;



/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/5 18:30
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class User {

    private  int id;
    Set<Integer> followed;
    // 推文链表头
    public Tweet head;

    public User(int useId) {
        this.id = useId;
        followed = new HashSet<>();
        head = null;
        // 关注一下自己
        follow(id);
    }

    /**
     * 关注一个用户
     * @param id
     */
    public void follow(int id) {
        followed.add(id);
    }
    /**
     * 取关一个用户
     * @param id
     */
    public void unFollow(int id) {
        if(id==this.id){
            return;
        }
        followed.remove(id);
    }

    /**
     * 发布一条推文
     * @param tweetId
     */
    public void post(int tweetId){
        Tweet tweet  = new Tweet(tweetId,System.currentTimeMillis());
        // 采用的头插法，最新的推文，放在前面；
        tweet.next = head;
        head = tweet;
    }
}
