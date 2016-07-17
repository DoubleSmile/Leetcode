package com.daily.March;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by luckyyflv on 16-3-19.
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    public static class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s,int e){
            start=s;
            end=e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals){
        if(intervals == null || intervals.size() < 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.start > o2.start) return 1;
                else if(o1.start < o2.start) return -1;
                else if(o1.start == o2.start){
                    if(o1.end > o2.end) return 1;
                    else if(o1.end  < o2.end) return -1;
                }
                return 0;
            }
        });

        List<Interval> list=new ArrayList<Interval>();
        Interval pre=intervals.get(0);
        for(int i=0;i<intervals.size();i++){
            Interval inter=intervals.get(i);
            if(inter.start == pre.start && inter.end == pre.end) continue;
            else if(inter.start >= pre.start && inter.end <= pre.end) continue;
            else if(inter.start >= pre.start && inter.start <= pre.end && inter.end > pre.end){
                pre.end=inter.end;
                continue;
            }
            else{
                list.add(pre);
                pre=intervals.get(i);
            }
        }
        list.add(pre);
        return list;

    }

    /*public static void main(String[] args){
        List<Interval> array=new ArrayList<Interval>();
        array.add(new Interval(1,3));
        array.add(new Interval(2,6));
        array.add(new Interval(8,10));
        array.add(new Interval(15,18));
        List<Interval> result=merge(array);
        for(Interval in:result){
            System.out.println(in.start+"---"+in.end);
        }
    }*/
}
