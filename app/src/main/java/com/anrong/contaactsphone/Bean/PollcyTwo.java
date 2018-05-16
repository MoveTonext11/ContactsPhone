package com.anrong.contaactsphone.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class PollcyTwo {
    public String content;
    public List<PollcyThree> pollcyThrees = new ArrayList<>();

    @Override
    public String toString() {
        return "PollcyTwo{" +
                "content='" + content + '\'' +
                ", pollcyThrees=" + pollcyThrees +
                '}';
    }
}
