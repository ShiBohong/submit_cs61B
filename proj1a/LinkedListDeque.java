public class LinkedListDeque<template> {

    private class IntNode {
        public template item;
        public IntNode next;
        public IntNode prev;

        public IntNode(template f, IntNode n, IntNode p) {
            item = f;
            next = n;
            prev = p;
        }
    }

    private int size;
    private IntNode sentinal;

    public LinkedListDeque(template x){
        sentinal=new IntNode(null,null,null);
        sentinal.next=new IntNode(x,sentinal,sentinal);
        sentinal.prev=sentinal.next;
        size=1;
    }

    public LinkedListDeque(){
        sentinal = new IntNode(null, null, null);
        sentinal.next = sentinal;  // 指向自己
        sentinal.prev = sentinal;  // 指向自己
        size=0;
    }

    public void addFirst(template item){
        size+=1;
        IntNode s=new IntNode(item,sentinal.next,sentinal);
        sentinal.next.prev=s;
        sentinal.next=s;

    }

    public void addLast(template item){
        size+=1;
        IntNode s=new IntNode(item,sentinal,sentinal.prev);
        sentinal.prev=s;
        s.prev.next=s;
    }

    public boolean isEmpty(){
        if(size==0){return true;}
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode p=sentinal.next;
        while(p!=sentinal){
            System.out.print(p.item+" ");
            p=p.next;
        }
    }

    public template removeFirst(){
        if(isEmpty()){return null;}
        size-=1;
        IntNode p=sentinal.next;
        sentinal.next.next.prev=sentinal;
        sentinal.next=sentinal.next.next;
        p.prev=null;
        p.next=null;
        return p.item;
    }

    public template removeLast(){
        if(isEmpty()){return null;}
        size-=1;
        IntNode p=sentinal.prev;
        sentinal.prev.prev.next=sentinal;
        sentinal.prev=sentinal.prev.prev;
        p.prev=null;
        p.next=null;
        return p.item;
    }

    public template get(int index){
        if(isEmpty()){return null;}
        IntNode p=sentinal;
        for(int j=index;j>=0;j--){
            p=p.next;
        }
        return p.item;
    }

    public template getRecursive(int index){
        if(isEmpty()){return null;}
        IntNode p=sentinal;
        if(index==0){return p.next.item;}
        return getRecursive(index-1);
    }

}
