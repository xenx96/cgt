package com.cgt.cgt_prj.domain;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Null;
import java.sql.Date;

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
