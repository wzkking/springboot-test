package org.wt.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        Random rand = new Random();
        for(int j=0;j<5;j++) {
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                int rd = rand.nextInt(35) + 1;
                boolean falg = false;
                if (rd < 10) {
                    falg = true;
                }
                String str = falg ? "0" + rd : rd + "";
                if (list.contains(str)) {
                    continue;
                } else {
                    list.add(str);
                }
                if (list.size() == 5) {
                    break;
                }
            }

            for (int i = 0; i < 100; i++) {
                int rd = rand.nextInt(12) + 1;
                boolean falg = false;
                if (rd < 10) {
                    falg = true;
                }
                String str = falg ? "0" + rd : rd + "";
                if (list2.contains(str)) {
                    continue;
                } else {
                    list2.add(str);
                }
                if (list2.size() == 2) {
                    break;
                }
            }
            Collections.sort(list);
            Collections.sort(list2);
            for (String s : list) {
                System.out.print(s + " ");
            }
            for (String s : list2) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
