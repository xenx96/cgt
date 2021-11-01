package com.cgt.cgt_prj.domain;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
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

    @Transient
    public static final String SEQUENCE_NAME = "Board_sequence";

    @Id
    private Long _id; // 고유 id
    @NonNull
    private String BID; // 게시판 아이디
    @NonNull
    private String UI; // 유저 아이디
    @NonNull
    private String CT; //컨텐츠 제목
    @NonNull
    private String CS; // 내용
    @Nullable
    private String RCI; // 답글한 게시물
    @NonNull
    private short RA; // 댓글 및 답글여부
    @NonNull
    private Date CA; // 생성일자
    @Nullable
    private Date UA; // 수정일자
    @Nullable
    private Date DA; // 삭제일자

    public Board(Long _id, String BID, String UI, String CT, String CS, String RCI, short RA,
        Date CA, Date UA, Date DA) {
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
