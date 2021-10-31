import React from 'react';
import '../../search.css';

function SeasonCard({leaguedata, leagueteam}){
  return(
    <div className = "season_card">
      <div className = "solo_card">
        <img src={(`img/tier_${leaguedata[0].tier}_${leaguedata[0].rank}.png`)} alt=""/>
        <div className ="tier_rank_info">
          <p className="queue_type">솔로랭크</p>
          <p className = "queue_tear">{leaguedata[0].tier}  {leaguedata[0].rank}</p>
          <p className = "queue_info"><span>{leaguedata[0].leaguePoints}</span>LP/ <span>{leaguedata[0].wins}</span>승 <span>{leaguedata[0].losses}</span>패</p>
          <p className = "queue_win">승률 <span>{Math.floor(leaguedata[0].wins /(leaguedata[0].wins+leaguedata[0].losses)*100)}</span>%</p>
          <p className = "league_name">{leagueteam.name}</p>
        </div>
      </div>
      <div className = "multi_card">
        <img src={(`img/tier_${leaguedata[1].tier}_${leaguedata[1].rank}.png`)} alt=""/>
        <div className ="tier_rank_info">
          <p className="queue_type">자유 5:5 랭크</p>
          <p className = "queue_tear">{leaguedata[1].tier}  {leaguedata[1].rank}</p>
          <p className = "queue_info"><span>{leaguedata[1].leaguePoints}</span>LP/ <span>{leaguedata[1].wins}</span>승 <span>{leaguedata[1].losses}</span>패</p>
          <p className = "queue_win">승률 <span>{Math.floor(leaguedata[1].wins /(leaguedata[1].wins+leaguedata[1].losses)*100)}</span>%</p>
        </div>
      </div>
      <div className = "playchamp_list"></div>
    </div>
  )
}

export default SeasonCard;
