package com.cgt.cgt_prj.domain;

import java.sql.Date;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;
/*@AllArgsConstructor
@Getter
@Setter
@ToString //exclude 로 제외시킬수 있음.*/
@ToString
@Document(collection = "User")
public class UserDTO {
     // private Boolean AH;
    @Id
    @NonNull
    private String _id;
    @NonNull
    private String NM;
    @NonNull
    private String PW;
    @NonNull
    private String EA;
    @Nullable
    private Number SX;
    @Nullable
    private Number MN;
    @Nullable
    private Date BT;
    @Nullable
    private String ADR;
    @NonNull
    private Date CA;
    //private Date UA;



    
    public UserDTO(String _id, String PW, String NM, String EA, Number MN, Number SX, String ADR,Date CA, Date BT){
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
