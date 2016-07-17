package com.daily.April;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckyyflv on 16-4-27.
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3)
 findMedian() -> 2
 */
public class FindMedianFromDataStream {
    // Adds a number into the data structure.
    List<Integer> list=new ArrayList<Integer>();
    public void addNum(int num) {
        if(list.isEmpty()){
            list.add(num);
        }else{
            for(int i=0;i<list.size();i++){
                if(num <= list.get(i)){
                    list.add(i,num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size=list.size();
        if(size % 2 ==1) return list.get(size/2);
        else{
            return ((double)list.get(size/2)+(double)list.get(size/2-1))/2;
        }
    }

    public static void main(String[] args){
        FindMedianFromDataStream Find=new FindMedianFromDataStream();
        Find.addNum(1);
        Find.addNum(2);
        System.out.println(Find.findMedian());
        Find.addNum(3);
        System.out.println(Find.findMedian());
    }
}