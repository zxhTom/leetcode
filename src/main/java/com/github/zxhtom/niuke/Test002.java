package com.github.zxhtom.niuke;

import java.util.*;

/**
 * TODO
 *
 * @author zxhtom
 * 2024/8/9
 */
public class Test002 {

    static class Student{
        String name;
        int[] sc;
        int totalScore;

        Student(String name , int[] sc){
            this.name=name;
            this.sc=sc;
        }
        public int getScore(int index) {
            return sc[index];
        }
        public int compareTo(Student stu){
            return this.name.compareTo(stu.name);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<Student> students = new ArrayList<>();
        Map<String,Integer> res = new HashMap<>();
            int stuCount = in.nextInt();
            int bookCount = in.nextInt();
            in.nextLine();
            String[] courses = in.nextLine().split(" ");
            for(int i=0;i<stuCount;i++){
                String tmp = in.nextLine();
                String[] split = tmp.split(" ");
                int[] sc = Arrays.stream(split, 1, split.length).mapToInt(Integer::parseInt).toArray();
                int[] nsc = new int[sc.length + 1];
                System.arraycopy(sc,0,nsc,0,sc.length);
                nsc[sc.length] = Arrays.stream(sc).sum();
                students.add(new Student(split[0], nsc));
            }
        String keyCounrse = in.nextLine();
        int keyIndex = Arrays.asList(courses).indexOf(keyCounrse);
        if (keyIndex == -1) {
            keyIndex=bookCount;
        }
        int finalKeyIndex = keyIndex;
        students.sort(Comparator.comparingInt((Student student)->student.getScore(finalKeyIndex)).reversed()
                .thenComparing((Student student)->student.name).reversed());
        in.close();
        for (Student student : students) {
            System.out.print(student.name+" ");
        }
    }
}
