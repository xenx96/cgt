import React from 'react';
import '../../search.css';

function SummonerCard(props){
  return  (
    <div className = "top_content">
      <div className = "sum_card">
        <div className = "profile_icon" style={{      background: `url(img/${props.leaguedata[0].tier}.png)`,      }}>
          <img className = "sum_icon"  src={`http://ddragon.leagueoflegends.com/cdn/11.16.1/img/profileicon/${props.sumdata.profileIconId}.png`} alt=""/>
          <span  className = "level-box" style={{      background: `url(img/bg-levelbox.png)`,      }}>{props.sumdata.summonerLevel}</span>
        </div>
        <div className = "sum_info">
          <div className = "sum_profile">
          <span>{props.sumdata.name}</span> <button onClick = {''} className = "fav_btn btn">☆즐겨찾기</button>
          </div>
          <div className = "sum_ref_btn">
            <button onClick = {''}  type="button" className = "refresh_btn btn">전적 갱신</button>
            <button onClick = {''}  type="button" className = "teargraph_btn btn">티어그래프</button>
            <button onClick = {''}  type="button" className = "playtime_btn btn">롤 몇시간 했는지 궁금해?</button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SummonerCard;
