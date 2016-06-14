package model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Vector<T> {
    private T[] list;

    public Vector(Vector<T> arg){
        list = Arrays.copyOf(arg.getList(), arg.getList().length);
    }

    public Vector(Class<T> c, int length){
        @SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(c, length);
        list = a;
    }

    public T get(int index) {
        return list[index];
    }

    public void set(int index, T type){
        list[index] = type;
    }

    public int length(){
        return list.length;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String res = "";
        for (T type : list){
            res = res + type.toString() + " ";
        }
        return res.trim();
    }
}