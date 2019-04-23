package model.service;

import model.entity.ChangeTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TimeUtilTest {
    private ArrayList<ChangeTime> times = new ArrayList<>();
    @Before
    public void init() {


    }
    @Test
    public void sortByAccountThenDate() {
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

        ArrayList<ChangeTime> expected = new ArrayList<>();
        expected.add(time3);
        expected.add(time3);
        expected.add(time2);
        expected.add(time2);
        expected.add(time1);
        expected.add(time1);

        times = new TimeUtil().sortByAccountThenDate(times);
        assertEquals(expected, times);

    }
}