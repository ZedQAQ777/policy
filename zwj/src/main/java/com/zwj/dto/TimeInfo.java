package com.zwj.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeInfo {
    @NotBlank(message = "开始日期不能为空")
    @NotNull(message = "邮箱不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;
    @NotBlank(message = "开始日期不能为空")
    @NotNull(message = "邮箱不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;
}
