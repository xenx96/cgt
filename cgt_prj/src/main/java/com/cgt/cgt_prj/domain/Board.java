package com.cgt.cgt_prj.domain;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@ToString
@Document(collection = "Board")
public class Board {
    /*
    private void selectPaging() {
        Pageable pageable = PageRequest.of(0, 10);
    
        //Repository 버전
        Page<TestCollections> page_1 = testCollectionsRepo.findAll(pageable);
    
        Query query = new Query().with(pageable);
        List<TestCollections> list = mongoTemplate.find(query, TestCollections.class);
        
        //mongoTemplate 버전
        Page<TestCollections> page_2 = PageableExecutionUtils.getPage(
            list,
            pageable,
            () -> mongoTemplate.count(new Query().limit(-1).skip(-1), TestCollections.class));
    }*/


    @Id
    @NonNull
    private String _id;
    @NonNull
    private String BID;
    @NonNull
    private String UI;
    @NonNull
    private String CT;
    @NonNull
    private String CS;
    @Nullable
    private String RCI ;
    @NonNull
    private short RA ;
    @NonNull
    private Date CA;
    @Nullable
    private Date UA;
    @Nullable
    private Date DA;

    public Board( String _id, String BID, String UI, String CT, String CS, String RCI, short RA, Date CA, Date UA, Date DA) {
        this._id = _id;
        this.BID = BID;
        this.UI = UI;
        this.CT = CT;
        this.CS = CS;
        this.RCI = RCI;
        this.RA = RA;
        this.CA = CA;
        this.UA = UA;
        this.DA = DA;
    }
}
