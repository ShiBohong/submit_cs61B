public class ArrayDeque<template> {
    private template[] items;
    private int size;
    private int maxsize;

    //initializing
    public AList(){
        items=(template[]) new Object[8];
        size=0;
        maxsize=8;
    }

    private void resize(int capacity){
        template[] a=(template[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }

    public void addFirst(template item){
        if(size==maxsize){
            resize(maxsize*2);
            maxsize*=2;
        }
        template[] a=(template[]) new Object[maxsize*2];
        System.arraycopy(items,0,a,1,size);
        a[0]=item;
        items=a;
        size+=1;
    }

    public void addLast(template item){
        if(size==maxsize){
            resize(maxsize*2);
            maxsize*=2;
        }
        items[size]=item;
        size+=1;
    }

    public boolean isEmpty(){
        if(size==0){return true;}
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]+" ");
        }
    }

    public template removeFirst(){
        if(isEmpty()){return null;}
        template[] a=(template[]) new Object[size];
        System.arraycopy(items,1,a,0,size-1);
        template b=items[0];
        items=a;
        size-=1;
        return b;
    }

    public template removeLast(){
        if(isEmpty()){return null;}
        template b=items[size-1];
        items[size-1]=0;
        size-=1;
        return b;
    }

    public template get(int index){
        if(isEmpty()){return null;}
        return items[index-1];
    }



}
