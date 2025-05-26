package com.github.frameworkbinder_server;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/6 12:20
 * @Desc : 客户端进程信息
 */
public class MyProcess   implements Parcelable {

    public int pid;
    public String name;

    protected MyProcess(Parcel in) {
        pid = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pid);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<MyProcess> CREATOR = new Creator<MyProcess>() {
        @Override
        public MyProcess createFromParcel(Parcel in) {
            return new MyProcess(in);
        }

        @Override
        public MyProcess[] newArray(int size) {
            return new MyProcess[size];
        }
    };
}
