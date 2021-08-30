import React from 'react';
import '../search.css';

const Footer = () =>{

  return (
    <footer>
  <ul className= "foot_li">
    <li className = "foot_menu left_menu w600"><a href="#">About OP.GG</a></li>
    <li className = "foot_menu"><a href="#">로고 히스토리</a></li>
    <li className = "foot_menu w1000"><a href="#">개인정보 처리방침</a></li>
    <li className = "foot_menu"><a href="#">도움말</a></li>
    <li className = "foot_menu"><a href="#">제휴</a></li>
    <li className = "foot_menu"><a href="#">광고</a></li>
    <li className = "foot_menu"><a href="#">문의/피드백</a></li>
    <li className = "foot_menu  right_menu"><a href="#">제출</a></li>
  </ul>
  <p>© 2012-2021 OP.GG. OP.GG isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
</p>
</footer>
  )
}

export default Footer;
