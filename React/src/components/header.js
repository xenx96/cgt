import React from 'react';
import '../search.css';
import'../img/search.svg'
import'.../components/img/logo.svg'

const Header = () =>{

  const handleSubmit = (event) => {// search 버튼 클릭시 함수
    console.log('submit!');   //제출 확인용 로그
    event.preventDefault();   //새로고침 방지
    const summoner = event.target.summoner.value; //from value 값 받아서 변수  저장
    window.location.href = `/${summoner}`; // router path 형식으로 주소이동 value 값을 넘겨 줌
  }

  return(

    <header>
    <nav className = "top_nav">
      <div className = "blue_menu">
        <span><a href="/"><img src="img/logo.svg" alt=""/></a></span>
        <span>리그오브레전드</span>
      </div>
      <div className = "black_menu">
        <span>한국어</span>
        <span><a href="#">로그인</a></span>
      </div>
    </nav>
    <nav className= "second_nav">
      <div>
        <span><a href="#">#집에있자</a></span>
        <span><a href="#">챔피언 분석</a></span>
        <span><a href="#">커뮤니티</a></span>
      </div>
      <div>
        <form onSubmit={handleSubmit}>
          <input type="text" name = "summoner" placeholder="  소환사명"/>
          <button><img src="img/search.svg" alt=".GG"/></button>
        </form>
        </div>
    </nav>
  </header>
  )
}

export default Header;
