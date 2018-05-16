package com.anrong.contaactsphone.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class PollcyOne {
    public String content;
    public List<PollcyTwo> pollcyTwos = new ArrayList<>();

    @Override
    public String toString() {
        return "PollcyOne{" +
                "content='" + content + '\'' +
                ", pollcyTwos=" + pollcyTwos +
                '}';
    }
}
