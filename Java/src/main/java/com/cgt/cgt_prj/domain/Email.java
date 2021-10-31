package com.cgt.cgt_prj.domain;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    String _id;

    @NonNull
    @NotBlank
    String ip;//요청자 주소

    @NonNull
    @NotBlank
    String EA;//이메일 주소

    @NonNull
    @NotBlank
    Long num;//인증키

    @NonNull
    @NotBlank
    Date CA;// 요청(생성) 시간

}
