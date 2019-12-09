package skbaek.homework.demo.util;

public enum FileHeader {

    YEAR("연도", "연도"),
    MONTH("월", "월"),
    HOUSECITY_FUND("주택도시기금1)(억원)", "주택도시기금"),
    KOOKMIN("국민은행(억원)", "국민은행"),
    WOORI("우리은행(억원)", "우리은행"),
    SHINHAN("신한은행(억원)", "신한은행"),
    KOREACITY("한국시티은행(억원)", "한국시티은행"),
    HANA("하나은행(억원)", "하나은행"),
    NONGHYUP_SUHYUP("농협은행/수협은행(억원)", "농협은행/수협은행"),
    KOREAEXCHANGE("외환은행(억원)", "외환은행"),
    ETC("기타은행(억원)", "기타은행");

    private String header;
    private String value;

    FileHeader(String header, String value) {
        this.header = header;
        this.value = value;
    }

    public String getHeader() {
        return this.header;
    }

    public String getValue() {
        return this.value;
    }
}