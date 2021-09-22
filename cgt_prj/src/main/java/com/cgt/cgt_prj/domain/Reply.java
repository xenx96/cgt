package com.cgt.cgt_prj.domain;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Null;
import java.sql.Date;

@Data
@ToString
@Document(collection = "Reply")
public class Reply {
    @Id
    @NonNull
    private String _id;
    @NonNull
    private String UI;
    @NonNull
    private String CID;
    @NonNull
    private String CS;
    @Nullable
    private Number RCI;
    @NonNull
    private Number RA;
    @NonNull
    private Date CA;
    @Nullable
    private String UA;
    @Nullable
    private Date DA;

    public Reply(String _id, String UI, String CID, String CS, Number RCI, Number RA, Date CA, String UA, Date DA) {
        this._id = _id;
        this.UI = UI;
        this.CID = CID;
        this.CS = CS;
        this.RCI = RCI;
        this.RA = RA;
        this.CA = CA;
        this.UA = UA;
        this.DA = DA;
    }
}
