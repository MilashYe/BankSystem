package model.service;

import model.entity.ChangeTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class TimeUtilTest {
    private ArrayList<ChangeTime> times = new ArrayList<>();
    @Before
    public void init() {
        ChangeTime time1 = new ChangeTime();
        time1.setAcId(13);
        time1.setChangeTime(new Date());
        ChangeTime time2 = new ChangeTime();
        time2.setAcId(12);
        time2.setChangeTime(new Date());
        ChangeTime time3 = new ChangeTime();
        time3.setAcId(4);
        time3.setChangeTime(new Date());
        times.add(time1);
        times.add(time2);
        times.add(time3);
        times.add(time1);
        times.add(time2);
        times.add(time3);

    }
    @Test
    public void sortByAccountThenDate() {

        new TimeUtil().sortByAccountThenDate(times).forEach(System.out::println);

    }
}