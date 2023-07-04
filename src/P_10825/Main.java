package P_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static ArrayList<Student> students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.add(new Student(name, korea, english, math));
        }

        Collections.sort(students);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).name);
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        int korea;
        int english;
        int math;

        public Student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;

        }

        @Override
        public int compareTo(Student o) {
            if (this.korea == o.korea) {
                if (this.english == o.english) {
                    if (this.math == o.math) {
                        return this.name.compareTo(o.name);

                    } else {
                        return o.math - this.math;
                    }
                } else {
                    return this.english - o.english;
                }
            }
            return o.korea - this.korea;
        }
    }
}
