package com.test.kotler;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GivePrize {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        List<String> list = getData();
        int i = 0;
        for (String s : list) {
            System.out.println("开始处理第 " + i++ + " 条");
            String[] ss = s.split(",");
            if (ss.length < 2) {
                continue;
            }
            try {
                RequestBody body = RequestBody.create(mediaType, "{\"winningLogId\": \"" + ss[0] + "\",\"userId\": \"" + ss[1] + "\", \"employeeCode\": \"\"}");
                Request request = new Request.Builder()
                        .url("https://sop.yifengx.com/kotler-rest/rest/activity/activityService/givePrizeByWinningLogId")
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .build();
                Response response = client.newCall(request).execute();
                System.out.println(response.body().string());
            }catch (Exception e) {

            }
        }
    }

    public static List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("65729dda73916d00061aa79f,62c26692aa242900062aa9ca");
        list.add("65729de173916d00061aa7a3,62c26692aa242900062aa9ca");
        return list;
    }
}
