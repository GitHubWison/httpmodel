package xu.qiwei.com.httpmodeapp;

/**
 * Created by xuqiwei on 17-6-7.
 */

public class Transfer {
    public static class TransferParam{
//        ?AppId=PreHospitalCare&
// NAME=&
// Patient_id=97c5adaa-387d-438c-a91a-4027e6d36bc6&
// TransferEndDate=2017-06-07&
// TransferStartDate=1991-06-06
        private String AppId = "PreHospitalCare";
        private String NAME="";
        private String Patient_id="97c5adaa-387d-438c-a91a-4027e6d36bc6";
        private String TransferEndDate = "2017-06-07";
        private String TransferStartDate="1991-06-06";
    }
    /**
     * TransferPatientId : 0ddbb9da-fd90-495f-8311-d2f397048e6f
     * patientRecordId : d4e34ca2-cb27-4681-80ac-a9720fa42c9a
     * Patient_id :
     * IDCARD : 123456789993456785
     * NAME : 123456789993456785
     * IDCARD_HOS : 医保卡号
     * OUTPATIENT_NO : 门（急）诊号
     * INHOSPITAL_NO : 住院号
     * CLINIC_TYPE : 门诊
     * OUT_HOSPITAL_NAME : 苏州市急救中心
     * IN_HOSPITAL_NAME : 苏州附二院
     * TRANSFER_DATE : 2016-02-23
     * CLINIC_TIME : 2016-02-18
     * BIRTHDAY : 2006-01-01
     * GENDER : 男
     * IsBind : 0
     */

    private String TransferPatientId;
    private String patientRecordId;
    private String Patient_id;
    private String IDCARD;
    private String NAME;
    private String IDCARD_HOS;
    private String OUTPATIENT_NO;
    private String INHOSPITAL_NO;
    private String CLINIC_TYPE;
    private String OUT_HOSPITAL_NAME;
    private String IN_HOSPITAL_NAME;
    private String TRANSFER_DATE;
    private String CLINIC_TIME;
    private String BIRTHDAY;
    private String GENDER;
    private String IsBind;

    public String getTransferPatientId() {
        return TransferPatientId;
    }

    public void setTransferPatientId(String TransferPatientId) {
        this.TransferPatientId = TransferPatientId;
    }

    public String getPatientRecordId() {
        return patientRecordId;
    }

    public void setPatientRecordId(String patientRecordId) {
        this.patientRecordId = patientRecordId;
    }

    public String getPatient_id() {
        return Patient_id;
    }

    public void setPatient_id(String Patient_id) {
        this.Patient_id = Patient_id;
    }

    public String getIDCARD() {
        return IDCARD;
    }

    public void setIDCARD(String IDCARD) {
        this.IDCARD = IDCARD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getIDCARD_HOS() {
        return IDCARD_HOS;
    }

    public void setIDCARD_HOS(String IDCARD_HOS) {
        this.IDCARD_HOS = IDCARD_HOS;
    }

    public String getOUTPATIENT_NO() {
        return OUTPATIENT_NO;
    }

    public void setOUTPATIENT_NO(String OUTPATIENT_NO) {
        this.OUTPATIENT_NO = OUTPATIENT_NO;
    }

    public String getINHOSPITAL_NO() {
        return INHOSPITAL_NO;
    }

    public void setINHOSPITAL_NO(String INHOSPITAL_NO) {
        this.INHOSPITAL_NO = INHOSPITAL_NO;
    }

    public String getCLINIC_TYPE() {
        return CLINIC_TYPE;
    }

    public void setCLINIC_TYPE(String CLINIC_TYPE) {
        this.CLINIC_TYPE = CLINIC_TYPE;
    }

    public String getOUT_HOSPITAL_NAME() {
        return OUT_HOSPITAL_NAME;
    }

    public void setOUT_HOSPITAL_NAME(String OUT_HOSPITAL_NAME) {
        this.OUT_HOSPITAL_NAME = OUT_HOSPITAL_NAME;
    }

    public String getIN_HOSPITAL_NAME() {
        return IN_HOSPITAL_NAME;
    }

    public void setIN_HOSPITAL_NAME(String IN_HOSPITAL_NAME) {
        this.IN_HOSPITAL_NAME = IN_HOSPITAL_NAME;
    }

    public String getTRANSFER_DATE() {
        return TRANSFER_DATE;
    }

    public void setTRANSFER_DATE(String TRANSFER_DATE) {
        this.TRANSFER_DATE = TRANSFER_DATE;
    }

    public String getCLINIC_TIME() {
        return CLINIC_TIME;
    }

    public void setCLINIC_TIME(String CLINIC_TIME) {
        this.CLINIC_TIME = CLINIC_TIME;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getIsBind() {
        return IsBind;
    }

    public void setIsBind(String IsBind) {
        this.IsBind = IsBind;
    }
}
