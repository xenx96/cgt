import React from 'react';
import '../../search.css';

function SeasonCard(props){
  return(
    <div className = "season_card">
      <div className = "solo_card">
        <img src={(`img/tier_${props.leaguedata[0].tier}_${props.leaguedata[0].rank}.png`)} alt=""/>
        <div className ="tier_rank_info">
          <p className="queue_type">솔로랭크</p>
          <p className = "queue_tear">{props.leaguedata[0].tier}  {props.leaguedata[0].rank}</p>
          <p className = "queue_info"><span>{props.leaguedata[0].leaguePoints}</span>LP/ <span>{props.leaguedata[0].wins}</span>승 <span>{props.leaguedata[0].losses}</span>패</p>
          <p className = "queue_win">승률 <span>{Math.floor(props.leaguedata[0].wins /(props.leaguedata[0].wins+props.leaguedata[0].losses)*100)}</span>%</p>
          <p className = "league_name">{props.leaguename}</p>
        </div>
      </div>
      <div className = "multi_card">
        <img src={(`img/tier_${props.leaguedata[1].tier}_${props.leaguedata[1].rank}.png`)} alt=""/>
        <div className ="tier_rank_info">
          <p className="queue_type">자유 5:5 랭크</p>
          <p className = "queue_tear">{props.leaguedata[1].tier}  {props.leaguedata[1].rank}</p>
          <p className = "queue_info"><span>{props.leaguedata[1].leaguePoints}</span>LP/ <span>{props.leaguedata[1].wins}</span>승 <span>{props.leaguedata[1].losses}</span>패</p>
          <p className = "queue_win">승률 <span>{Math.floor(props.leaguedata[1].wins /(props.leaguedata[1].wins+props.leaguedata[1].losses)*100)}</span>%</p>
        </div>
      </div>
      <div className = "playchamp_list"></div>
    </div>
  )
}

export default SeasonCard;
