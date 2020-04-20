package com.andyside.covid19india.model;

import com.google.gson.annotations.SerializedName;

public class TestedData {

    @SerializedName("positivecasesfromsamplesreported")
    private String positiveCasesFromSamplesReported;

    @SerializedName("samplereportedtoday")
    private String sampleReportedToday;

    @SerializedName("source")
    private String source;

    @SerializedName("testsconductedbyprivatelabs")
    private String testsConductedByPrivateLabs;

    @SerializedName("totalindividualstested")
    private String totalIndividualsTested;

    @SerializedName("totalpositivecases")
    private String totalPositiveCases;

    @SerializedName("totalsamplestested")
    private String totalSamplesTested;

    @SerializedName("updatetimestamp")
    private String updateTimestamp;

    public TestedData(String positiveCasesFromSamplesReported, String sampleReportedToday,
                      String source, String testsConductedByPrivateLabs, String totalIndividualsTested,
                      String totalPositiveCases, String totalSamplesTested, String updateTimestamp) {
        this.positiveCasesFromSamplesReported = positiveCasesFromSamplesReported;
        this.sampleReportedToday = sampleReportedToday;
        this.source = source;
        this.testsConductedByPrivateLabs = testsConductedByPrivateLabs;
        this.totalIndividualsTested = totalIndividualsTested;
        this.totalPositiveCases = totalPositiveCases;
        this.totalSamplesTested = totalSamplesTested;
        this.updateTimestamp = updateTimestamp;
    }

    public String getPositiveCasesFromSamplesReported() {
        return positiveCasesFromSamplesReported;
    }

    public void setPositiveCasesFromSamplesReported(String positiveCasesFromSamplesReported) {
        this.positiveCasesFromSamplesReported = positiveCasesFromSamplesReported;
    }

    public String getSampleReportedToday() {
        return sampleReportedToday;
    }

    public void setSampleReportedToday(String sampleReportedToday) {
        this.sampleReportedToday = sampleReportedToday;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTestsConductedByPrivateLabs() {
        return testsConductedByPrivateLabs;
    }

    public void setTestsConductedByPrivateLabs(String testsConductedByPrivateLabs) {
        this.testsConductedByPrivateLabs = testsConductedByPrivateLabs;
    }

    public String getTotalIndividualsTested() {
        return totalIndividualsTested;
    }

    public void setTotalIndividualsTested(String totalIndividualsTested) {
        this.totalIndividualsTested = totalIndividualsTested;
    }

    public String getTotalPositiveCases() {
        return totalPositiveCases;
    }

    public void setTotalPositiveCases(String totalPositiveCases) {
        this.totalPositiveCases = totalPositiveCases;
    }

    public String getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public void setTotalSamplesTested(String totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
    }

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
