package com.test.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinTest {

    public static void main(String[] args) {
        String str = "盐城开元商圈";
        String pinyin = getPinyinFirstLetter(str);
        System.out.println(pinyin.toUpperCase());
    }

    public static String getPinyinFirstLetter(String input) {
        StringBuilder pinyin = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // 中文范围
            if (ch >= 0x4E00 && ch <= 0x9FA5) {
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if (pinyinArray != null && pinyinArray.length > 0) {
                    pinyin.append(pinyinArray[0].charAt(0));
                }
            } else {
                pinyin.append(ch);
            }
        }
        return pinyin.toString();
    }
}
