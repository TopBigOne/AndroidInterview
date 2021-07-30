package com.jar.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : dev
 * @version :
 * @Date :  2021/7/28 14:48
 * @Desc :
 */
public class Book implements Parcelable {
    public int bookId;
    public String bookName;

    public Book() {

    }

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(bookId);
        parcel.writeString(bookName);
    }
}
