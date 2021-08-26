import React, { useState, useEffect } from 'react';
import axios from 'axios' ; // get 데이터베이스 요청 시 사용
import SumInfo from './suminfo';
import {api_key} from '../config/api_key';
// 비동기 처리 중요 ** js는 동기 x 비동기 형식으로 작동한다. 신경써줘야 함.

function User({ match }){
  
  const [encryptedSummoner, setEncryptedSummoner] = useState('false');
  const [summonerState,setSummonerState] = useState(' ');
  const [datas,setDatas] = useState('');
  const [loading, setLoading] = useState(true);
  const summonerName = match.params.summoner;
//useState 형식 -> react는 변수를 마음대로 바꾸지 못하도록 권장한다
//그러므로 set 함수를 권장..
  const matchFirst = async()=>{ //Promise then으로 관리하던것을 async function으로 만듬
    let res;
    try{
      res = await axios.get(`https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/${summonerName}?api_key=${api_key}`) ;
      setEncryptedSummoner(res.data.id);

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
        res = await axios.get(`https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/${encryptedSummoner}?api_key=${api_key}`);
        await setDatas(res.data);
        await setLoading(false);

      }catch(err){
        console.error(err);

      }
    } 
      fetchData();  //데이터를 받아온 후 값을 리턴해야 하므로 로딩 변수를 설정하여 값을 받은 후 리턴값을 받아올수 있게 설정
    },[encryptedSummoner])

  if(loading) return <div>Loading..</div>
  /*데이터를 받아오지 못한경우 로딩 글씨 띄우기
  데이터를 받아오면 아래 리턴 값실행*/
  return(
    <div>
      <h1>{datas[0].summonerName}</h1>
      <h2>{summonerState}</h2>
      { datas.map((datas)=>
        <SumInfo
          key = {datas.leagueId}
          summoner = {datas}
        />
    )}
    </div>
  );
}

export default User;