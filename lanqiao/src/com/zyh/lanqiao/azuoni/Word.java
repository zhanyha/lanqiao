package com.zyh.lanqiao.azuoni;

/**
 * @Description Word¡ª¡ª
 * @Author zhanyuhao
 * @Date 2020/6/6 19:12
 **/
public class Word {
    private String english;
    private String chinese;
    private String wordRank;
    private String pronounce;
    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getWordRank() {
        return wordRank;
    }

    public void setWordRank(String wordRank) {
        this.wordRank = wordRank;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    @Override
    public String toString() {
        return "Word{" +
                "english='" + english + '\'' +
                ", chinese='" + chinese + '\'' +
                ", wordRank='" + wordRank + '\'' +
                ", pronounce='" + pronounce + '\'' +
                '}';
    }
}
