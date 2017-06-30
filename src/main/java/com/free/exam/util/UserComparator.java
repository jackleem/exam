package com.free.exam.util;

import com.free.exam.model.User;

import java.util.Comparator;

/**
 * Created by Li Yu on 2017/6/8.
 */
public final class UserComparator implements Comparator<User> {
    private boolean isAscend;

    public UserComparator(boolean isAscend){
        this.isAscend = isAscend;
    }

    @Override
    public int compare(User o1, User o2) {
        if(isAscend){
            if((o1.getId()-o2.getId())>0){
                return 1;
            }else{
                return -1;
            }
        }else{
            if((o2.getId()-o1.getId())>0){
                return 1;
            }else{
                return -1;
            }
        }

    }
}