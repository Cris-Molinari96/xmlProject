package com.bharath.xmlparsers.dto;

public class ReadParagraph {

//    <ReadParagraph>
//    <info1>stevens dr</info1>
//    <info2>king of prussia</info2>
//        <info3>PA</info3>
//        <info4>USA</info4>
//        <info5>19406</info5>
//    </ReadParagraph>
    private String info1;
    private String info2;
    private String info3;
    private String info4;
    private String info5;

    public ReadParagraph() {
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    public String getInfo4() {
        return info4;
    }

    public void setInfo4(String info4) {
        this.info4 = info4;
    }

    public String getInfo5() {
        return info5;
    }

    public void setInfo5(String info5) {
        this.info5 = info5;
    }

    @Override
    public String toString() {
        return "ReadParagraph{" +
                "info1='" + info1 + '\'' +
                ", info2='" + info2 + '\'' +
                ", info3='" + info3 + '\'' +
                ", info4='" + info4 + '\'' +
                ", info5='" + info5 + '\'' +
                '}';
    }
}
