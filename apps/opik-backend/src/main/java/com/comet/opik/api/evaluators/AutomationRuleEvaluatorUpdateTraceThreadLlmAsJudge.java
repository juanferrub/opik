package com.comet.opik.api.evaluators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.beans.ConstructorProperties;
import java.util.UUID;

import static com.comet.opik.api.evaluators.AutomationRuleEvaluatorTraceThreadLlmAsJudge.TraceThreadLlmAsJudgeCode;

@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public final class AutomationRuleEvaluatorUpdateTraceThreadLlmAsJudge
        extends
            AutomationRuleEvaluatorUpdate<TraceThreadLlmAsJudgeCode> {

    @ConstructorProperties({"name", "samplingRate", "code", "projectId"})
    public AutomationRuleEvaluatorUpdateTraceThreadLlmAsJudge(
            @NotBlank String name, float samplingRate, @NotNull TraceThreadLlmAsJudgeCode code,
            @NotNull UUID projectId) {
        super(name, samplingRate, code, projectId);
    }

    /**
     * Two purposes:
     * - Makes the polymorphic T code available for serialization.
     * - Provides the specific type T for Open API and Fern.
     */
    @JsonProperty
    @Override
    public TraceThreadLlmAsJudgeCode getCode() {
        return super.getCode();
    }

    @Override
    public AutomationRuleEvaluatorType getType() {
        return AutomationRuleEvaluatorType.TRACE_THREAD_LLM_AS_JUDGE;
    }
}
