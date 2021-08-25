import React from 'react'
// key 값을 받아오지않으면 에러로그 뜸
//summoner = json 데이터를 받아옴
const SumInfo = (summoner,key) =>{
  console.log(summoner.summoner)
  return (
    <div>
    <li>큐타입: {summoner.summoner.queueType}</li>
    <li>티어: {summoner.summoner.tier}</li>
    <li>랭크: {summoner.summoner.rank}</li>
    <li>리그포인트: {summoner.summoner.leaguePoints}</li>
    <li>승: {summoner.summoner.wins}</li>
    <li>패: {summoner.summoner.losses}</li>
    <br/>
    </div>

  )
}

export default SumInfo;
