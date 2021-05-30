package com.lead.utils.threadlocal;

import com.lead.model.media.pojo.WmUser;

/**
 * @ClassName WmThreadLocalUtils
 * @date 2021/5/29 17:19
 * @Version 1.0
 * @Author ShyBoy
 */
public class WmThreadLocalUtils {
    private final  static ThreadLocal<WmUser> user_Thread_Local = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(WmUser user){
        user_Thread_Local.set(user);
    }

    /**
     * 获取线程中的用户
     * @return
     */
    public static WmUser getUser( ){
        return user_Thread_Local.get();
    }
}
