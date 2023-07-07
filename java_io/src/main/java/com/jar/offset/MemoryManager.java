package com.jar.offset;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : top
 * @version :
 * @Date :  2023/7/7 23:02
 * @Desc :  学习计算机中，偏移量 offset的使用
 */
public class MemoryManager {
    private static final int ELEMENT_SIZE = 4; // 数组元素大小为 4 字节
    private static final int ARRAY_LENGTH = 10; // 数组长度为 10
    private static final long BUFFER_SIZE = ELEMENT_SIZE * ARRAY_LENGTH;
    //  创建了一个可共享的内存缓冲区。缓冲区的大小为 40 字节（ 缓冲区大小为 40 字节
    private MappedByteBuffer mappedByteBuffer = null;

    String filePath = "/Users/dev/Desktop/mp4/月半小夜曲-李克勤 小提琴版 (Half moon serenade-Hacken Lee).mp4";

    public MemoryManager() {
        // 创建一个可共享的内存缓冲区
        FileChannel channel;


        try {
            channel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 初始化数组
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            setElement(i, i);
        }
    }

    /**
     * 将值写入缓冲区
     * @param index
     * @param value
     */
    public void setElement(int index, int value) {
        if (index < 0 || index >= ARRAY_LENGTH) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        // 计算元素在数组中的偏移量
        int offset = index * ELEMENT_SIZE;

        // 将值写入缓冲区
        mappedByteBuffer.putInt(offset, value);
    }

    public int getElement(int index) {
        if (index < 0 || index >= ARRAY_LENGTH) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        // 计算元素在数组中的偏移量
        int offset = index * ELEMENT_SIZE;

        // 从缓冲区中读取值，并返回
        return mappedByteBuffer.getInt(offset);
    }

    public static void main(String[] args) {
        System.out.println("test.");
    }


}
