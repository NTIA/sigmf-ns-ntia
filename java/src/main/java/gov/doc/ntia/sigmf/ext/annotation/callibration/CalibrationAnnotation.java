package gov.doc.ntia.sigmf.ext.annotation.callibration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.Annotation;
import gov.doc.ntia.sigmf.serialization.DoubleSerializer;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalibrationAnnotation extends Annotation {

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-calibration:receiver_scaling_factor", required = false)
    protected Double receiverScalingFactor;

    @JsonSerialize(using= DoubleSerializer.class)
    @JsonProperty(value="ntia-calibration:receiver_ldb_compression_point", required = false)
    protected Double receiverLdbCompressionPoint;

    @JsonProperty(value="ntia-calibration:receiver_system_noise_power", required = false)
    protected SystemNoise receiverSystemNoisePower;

    public Date getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(Date calibrationDate) {
        this.calibrationDate = calibrationDate;
    }

    @JsonProperty(value="ntia-calibration:calibration_date")
    protected Date calibrationDate;


    public Double getReceiverScalingFactor() {
        return receiverScalingFactor;
    }

    public void setReceiverScalingFactor(Double receiverScalingFactor) {
        this.receiverScalingFactor = receiverScalingFactor;
    }

    public Double getReceiverLdbCompressionPoint() {
        return receiverLdbCompressionPoint;
    }

    public void setReceiverLdbCompressionPoint(Double receiverLdbCompressionPoint) {
        this.receiverLdbCompressionPoint = receiverLdbCompressionPoint;
    }

    public SystemNoise getReceiverSystemNoisePower() {
        return receiverSystemNoisePower;
    }

    public void setReceiverSystemNoisePower(SystemNoise receiverSystemNoisePower) {
        this.receiverSystemNoisePower = receiverSystemNoisePower;
    }

}
