import React from 'react';

const Search = () =>{

  const handleSubmit = (event) => {// search 버튼 클릭시 함수
    console.log('submit!');   //제출 확인용 로그
    event.preventDefault();   //새로고침 방지
    const summoner = event.target.summoner.value; //from value 값 받아서 변수  저장
    window.location.href = `/${summoner}`; // router path 형식으로 주소이동 value 값을 넘겨 줌
    }

  return (

    <form onSubmit = {handleSubmit}>
     <input type = "text" name = "summoner"/>
     <button>search</button>
    </form>
  )
}

export default Search;
