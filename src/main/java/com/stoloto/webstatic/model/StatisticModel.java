package com.stoloto.webstatic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "db_stoloto")
public class StatisticModel {
    @Transient
    private int[][] drawnNumbers;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "circulation")
    private Integer circulation;
    @Column(name = "date", columnDefinition = "text")
    private String date;
    @Column(name = "tab_1")
    private byte tab_1;
    @Column(name = "tab_2")
    private byte tab_2;
    @Column(name = "tab_3")
    private byte tab_3;
    @Column(name = "tab_4")
    private byte tab_4;
    @Column(name = "tab_5")
    private byte tab_5;
    @Column(name = "tab_6")
    private byte tab_6;
    @Column(name = "tab_7")
    private byte tab_7;
    @Column(name = "tab_8")
    private byte tab_8;

    @Column(name = "bank")
    private String bank;

    public StatisticModel(String date, Integer circulation, byte tab_1, byte tab_2, byte tab_3, byte tab_4,
                          byte tab_5, byte tab_6, byte tab_7, byte tab_8, String bank) {
        this.circulation = circulation;
        this.date = date;
        this.tab_1 = tab_1;
        this.tab_2 = tab_2;
        this.tab_3 = tab_3;
        this.tab_4 = tab_4;
        this.tab_5 = tab_5;
        this.tab_6 = tab_6;
        this.tab_7 = tab_7;
        this.tab_8 = tab_8;
        this.bank = bank;
    }

    public StatisticModel() {
    }

    public int[][] getDrawnNumbers() {
        return this.drawnNumbers;
    }

    public Integer getCirculation() {
        return this.circulation;
    }

    public String getDate() {
        return this.date;
    }

    public byte getTab_1() {
        return this.tab_1;
    }

    public byte getTab_2() {
        return this.tab_2;
    }

    public byte getTab_3() {
        return this.tab_3;
    }

    public byte getTab_4() {
        return this.tab_4;
    }

    public byte getTab_5() {
        return this.tab_5;
    }

    public byte getTab_6() {
        return this.tab_6;
    }

    public byte getTab_7() {
        return this.tab_7;
    }

    public byte getTab_8() {
        return this.tab_8;
    }

    public String getBank() {
        return this.bank;
    }

    public void setDrawnNumbers(int[][] drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    public void setCirculation(Integer circulation) {
        this.circulation = circulation;
    }

    public void setDate(String timeNewPost) {
        this.date = timeNewPost;
    }

    public void setTab_1(byte tab_1) {
        this.tab_1 = tab_1;
    }

    public void setTab_2(byte tab_2) {
        this.tab_2 = tab_2;
    }

    public void setTab_3(byte tab_3) {
        this.tab_3 = tab_3;
    }

    public void setTab_4(byte tab_4) {
        this.tab_4 = tab_4;
    }

    public void setTab_5(byte tab_5) {
        this.tab_5 = tab_5;
    }

    public void setTab_6(byte tab_6) {
        this.tab_6 = tab_6;
    }

    public void setTab_7(byte tab_7) {
        this.tab_7 = tab_7;
    }

    public void setTab_8(byte tab_8) {
        this.tab_8 = tab_8;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StatisticModel)) return false;
        final StatisticModel other = (StatisticModel) o;
        if (!other.canEqual((Object) this)) return false;
        if (!java.util.Arrays.deepEquals(this.getDrawnNumbers(), other.getDrawnNumbers())) return false;
        if (this.id != other.id) return false;
        if (this.getCirculation() != other.getCirculation()) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        if (this.getTab_1() != other.getTab_1()) return false;
        if (this.getTab_2() != other.getTab_2()) return false;
        if (this.getTab_3() != other.getTab_3()) return false;
        if (this.getTab_4() != other.getTab_4()) return false;
        if (this.getTab_5() != other.getTab_5()) return false;
        if (this.getTab_6() != other.getTab_6()) return false;
        if (this.getTab_7() != other.getTab_7()) return false;
        if (this.getTab_8() != other.getTab_8()) return false;
        final Object this$bank = this.getBank();
        final Object other$bank = other.getBank();
        if (this$bank == null ? other$bank != null : !this$bank.equals(other$bank)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StatisticModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + java.util.Arrays.deepHashCode(this.getDrawnNumbers());
        result = result * PRIME + this.id;
        result = result * PRIME + this.getCirculation();
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        result = result * PRIME + this.getTab_1();
        result = result * PRIME + this.getTab_2();
        result = result * PRIME + this.getTab_3();
        result = result * PRIME + this.getTab_4();
        result = result * PRIME + this.getTab_5();
        result = result * PRIME + this.getTab_6();
        result = result * PRIME + this.getTab_7();
        result = result * PRIME + this.getTab_8();
        final Object $bank = this.getBank();
        result = result * PRIME + ($bank == null ? 43 : $bank.hashCode());
        return result;
    }

    public String toString() {
//        return "StatisticModel(drawnNumbers=" + java.util.Arrays.deepToString(this.getDrawnNumbers()) + ", id=" + this.id + ", circulation=" + this.getCirculation() + ", date=" + this.getDate() + ", tab_1=" + this.getTab_1() + ", tab_2=" + this.getTab_2() + ", tab_3=" + this.getTab_3() + ", tab_4=" + this.getTab_4() + ", tab_5=" + this.getTab_5() + ", tab_6=" + this.getTab_6() + ", tab_7=" + this.getTab_7() + ", tab_8=" + this.getTab_8() + ", bank=" + this.getBank() + ")";

        return String.format("%-34s %-18s %-3d [%-3d %-3d %-3d %-3d |  %-3d %-3d %-3d %-2d]   %s",
                this.getClass().getSimpleName(),
                this.date,
                this.circulation,
                this.tab_1, this.tab_2, this.tab_3, this.tab_4,
                this.tab_5, this.tab_6, this.tab_7, this.tab_8,
                this.bank);
    }
}