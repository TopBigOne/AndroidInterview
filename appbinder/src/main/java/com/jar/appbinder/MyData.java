package com.jar.appbinder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : dev
 * @version :
 * @Date :  12/20/20 5:30 PM
 * @Desc :
 */
public class MyData implements Parcelable {
    int data1 ,data2;

    public MyData() {
    }

    protected MyData(Parcel in) {
        readFromParcel(in);
    }

    /** 从Parcel中读取数据 **/
    public void readFromParcel(Parcel in){
        data1 = in.readInt();
        data2 = in.readInt();
    }


    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(data1);
        dest.writeInt(data2);
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "data1=" + data1 +
                ", data2=" + data2 +
                '}';
    }
}
