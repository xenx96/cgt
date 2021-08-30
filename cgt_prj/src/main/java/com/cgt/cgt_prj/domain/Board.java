package com.cgt.cgt_prj.domain;

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
    
}
