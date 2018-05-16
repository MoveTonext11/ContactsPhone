package com.anrong.contaactsphone.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class PollcyThree {
    public String content;
    public List<PollcyFour> pollcyFours = new ArrayList<>();

    @Override
    public String toString() {
        return "PollcyThree{" +
                "content='" + content + '\'' +
                ", pollcyFours=" + pollcyFours +
                '}';
    }
}
