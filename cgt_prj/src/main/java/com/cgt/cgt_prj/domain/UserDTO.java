package com.cgt.cgt_prj.domain;

import java.util.Date;


import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

import javax.validation.constraints.NotBlank;


/*@AllArgsConstructor*/
@Getter
@Setter
@ToString //exclude 로 제외시킬수 있음.
@Document(collection = "User")
public class UserDTO {

    // private Boolean AH;
    @Id
    @NonNull
    private String _id;

    @NonNull
    @NotBlank
    private String NM;

    @NotBlank
    private String NN;

    @NotBlank
    @NonNull
    private String PW;

    @NotBlank
    @NonNull
    private String EA;

    @Nullable
    private Number SX;

    @Nullable
    private String MN;

    @Nullable
    private Date BT;

    @Nullable
    private String ADR;

    @NonNull
    private Date CA;

    @Nullable
    private Date UA;

    
    public UserDTO(){
        super();
        this._id = _id;
        this.PW = PW;
        this.NM = NM;
        this.MN = MN;
        this.SX = SX;
        this.EA = EA;
        this.ADR = ADR;
        this.CA = CA;
        this.BT = BT;
    }



}
