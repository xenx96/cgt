package com.cgt.cgt_prj.domain;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@ToString
@Document(collection = "BoardConfig")
public class Board_Config {
    @Id
    @NonNull
    private String _id;
    @NonNull
    private String BN;
    @NonNull
    private String BC;
    @NonNull
    private Date CA;
    @Nullable
    private Date DA;

    public Board_Config(String _id, String BN, String BC, Date CA, Date DA) {
        this._id = _id;
        this.BN = BN;
        this.BC = BC;
        this.CA = CA;
        this.DA = DA;
    }
}