import React, { useState, useEffect } from 'react';
import '../search.css';
import SeasonCard from './search/seasoncard'
import SummonerCard from './search/summonercard';
import axios from 'axios' ; // get 데이터베이스 요청 시 사용
import {api_key} from '../config/api_key';//api_key 매일 갱신해줘야 함.
// 비동기 처리 중요 ** js는 동기 x 비동기 형식으로 작동한다. 신경써줘야 함.


function Contents({ match }){

  const [encryptedSummoner, setEncryptedSummoner] = useState('false');
  const [summonerState,setSummonerState] = useState(' ');
  const [datas,setDatas] = useState('');
  const [leagueName,setLeagueName] = useState('');
  const [loading, setLoading] = useState(true);
  const summonerName = match.params.summoner;
//useState 형식 -> react는 변수를 마음대로 바꾸지 못하도록 권장한다
//그러므로 set 함수를 권장..

  const matchFirst = async()=>{ //Promise then으로 관리하던것을 async function으로 만듬
    let res;
    try{
      res = await axios.get(`https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/${summonerName}?api_key=${api_key}`) ;
      setEncryptedSummoner(res.data);

    }catch(err){
      console.error('에러 ' + err.message);
      setSummonerState('사용자를 찾을 수 없습니다.');
    }
  }
  matchFirst();
// useEffect 소환사의 해쉬값을 받아온후 진행해야 되므로 동기적으로 진행시키기 위해 useEffect사용
// encryptedSummoner값이 변하면 함수 실행
// useEffect까지 한번에 async로 묶으려 했으나, UseEffect Function은 asyncFunction안에서 제대로 동작하지 않아 분리하여 작동시키고,
// 그안에 async를 새로 하여 promise then을 변경시킴.
  useEffect(()=>{
    const fetchData = async()=>{
      let res;
      try{
        res = await axios.get(`https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/${encryptedSummoner.id}?api_key=${api_key}`);
        await setDatas(res.data);
        await setLoading(false);

      }catch(err){
        console.error(err);

      }
    }
      fetchData();  //데이터를 받아온 후 값을 리턴해야 하므로 로딩 변수를 설정하여 값을 받은 후 리턴값을 받아올수 있게 설정
    },[encryptedSummoner])

    useEffect(()=>{
      const fetchData = async()=>{
        let res;
        try{
          res = await axios.get(`https://kr.api.riotgames.com/lol/league/v4/leagues/${datas[0].leagueId}?api_key=${api_key}`);
          await setLeagueName(res.data.name);
          await setLoading(false);

        }catch(err){
          console.error(err);

        }
      }
        fetchData();  //데이터를 받아온 후 값을 리턴해야 하므로 로딩 변수를 설정하여 값을 받은 후 리턴값을 받아올수 있게 설정
      },[datas])

  if(loading) return <div>Loading..</div>
  /*데이터를 받아오지 못한경우 로딩 글씨 띄우기
  데이터를 받아오면 아래 리턴 값실행*/
  return(
    <content>

    <nav className = "menu">
      <SummonerCard leaguedata={datas} sumdata={encryptedSummoner} leaguename = {leagueName} />
      <dl className="menu_buttons">
        <dd>
          <a href = "#" className = "menu_btn all_btn">종합</a>
        </dd>
        <dd>
        <a href = "#" className = "menu_btn champ_btn">챔피언</a>
        </dd>
        <dd>
          <a href = "#" className = "menu_btn ingame_btn">🔍인게임 정보</a>
        </dd>
      </dl>
    </nav>
    <div className = "main_contents">
      <SeasonCard leaguedata={datas} />
      <div className = "all_game_infocard">
        <div className = "sum_gameinfo">
          <div className = "info_nav">
            <a href="#">전체</a>
          </div>
          <div className="detail_info">
            <div className= "losewin_rate">
              <div className="first_box win_graph">
                <span className = "win_ratio_title"><span>0</span>전<span>0</span>승<span>0</span>패</span>
                <div className="pie-chart2"><span className="center"><span>50%</span></span></div>
              </div>
              <div className ="first_box kda_info">
                <span className="kda"><span>0</span>/<span className="f_red">0</span>/<span>0</span></span>
                <span className="kda_ratio"><span>0</span>:<span>0</span> <span className = "f_red">(0%)</span></span>

              </div>
            </div>
            <div className= "champs_rate">
              <div className= "champ_rate">
                <div>
                  <img src="https://via.placeholder.com/46x46" alt=""/>
                  <span className = "cmp_name">챔피언</span>
                </div>
                <span><span>0.0</span> 평점</span>
              </div>
              <div className= "champ_rate">
                <div>
                  <img src="https://via.placeholder.com/46x46" alt=""/>
                  <span className = "cmp_name">챔피언</span>
                </div>
                <span><span>0.0</span> 평점</span>
              </div>
              <div className= "champ_rate">
                <div>
                  <img src="https://via.placeholder.com/46x46" alt=""/>
                  <span className = "cmp_name">챔피언</span>
                </div>
                <span><span>0.0</span> 평점</span>
              </div>
            </div>
            <div className= "fav_position">
              <span className = "fnt_15">선호포지션(랭크)</span>
              <div className= "fav_line">
                <img src="https://via.placeholder.com/28x28" alt=""/>
                <span className = "cmp_name">라인</span>
                <span className = "fav_rate">승률 0%</span>
              </div>
              <div className= "fav_line">
                <img src="https://via.placeholder.com/28x28" alt=""/>
                <span className = "cmp_name">라인</span>
                <span className = "fav_rate">승률 0%</span>
              </div>
            </div>
          </div>
        </div>
        <div className = "game_card">
          <div className = "game_detail">
            <span className = "queue_type">큐타입</span>
            <span className = "game_day">날짜</span>
            <div className= "bar"></div>
            <span className = "game_result">승/패</span>
            <span >게임시간</span>
          </div>
          <img src="https://via.placeholder.com/66x66" alt=""/>
          <div className = "detail_kda">
            <span className ="kda_stat fnt_15">0/<span className="f_red">0</span>/0</span>
            <span className = "kda_score">0:0 평점</span>
          </div>
          <div className = "ingame_stat">
            <span className="stat_level">레벨 1</span>
            <span className="stat_cs">0 CS</span>
            <span className="stat_kill_ratio f_red">킬 관여 0 %</span>
          </div>
          <div className = "game_players">
            <div className="team_ally">
              <div>
                <img src="https://via.placeholder.com/16x16" alt=""/>
                <span className="summoner_name">소환사 이름</span>
              </div>
            </div>
            <div className="team_enemy">
              <div>
                <img src="https://via.placeholder.com/16x16" alt=""/>
                <span className="summoner_name">소환사 이름</span>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    </content>
  );
}

export default Contents;
