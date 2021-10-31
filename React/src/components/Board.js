import React, {Component } from 'react';
import Axios from "axios";
import AuthService from '../service/AuthService';
class Board extends React.Component {

  constructor(props){
    super(props);
    this.state = {
    }
    this.Auth = new AuthService();
  }

  handleSubmit = async(e) => {
      e.preventDefault();
      const {CT, CS, RA} = e.target;
      const CA = new Date();
      if(this.Auth.isLoggedIn()&&!this.Auth.isTokenExpired()){
        try{

        var boardfrm = {
          BID: "1",
          UI: this.Auth.getProfile().id,
          CT: CT.value,
          CS : CS.value,
          RA : RA.value,
          CA
      }

        boardfrm = JSON.stringify(boardfrm);
        alert(boardfrm);
          let res = await Axios.post('/api/board',boardfrm, {
            headers: { "Content-Type": `application/json`}
              });
          alert(res.data?'게시글이 작성 되었습니다!': '다시 시도해 주세요!');
          console.log(res.data);
        }catch(err){
          console.log(err);
        }
      }
      else{
        alert("글쓰기는 로그인된 사용자만 가능합니다.");
          window.location.href = ('../login');
      }
    }
  render(){
    return(
      <form onSubmit={this.handleSubmit}>
        <div>
          글 제목 <input type="text" name = "CT"/>
        </div>
        <div>
          글 내용  <textarea name="CS" rows="8" cols="80"></textarea>
        </div>
        <div>
            댓/답글 가능여부<select name = 'RA'>
              <option value = '0' >모두불가 </option>
              <option value = '1' >댓글가능 </option>
              <option value = '2' >답글가능 </option>
              <option value = '3' >모두가능 </option>
            </select>
        </div>
        <button>게시글 작성</button>
      </form>
    )
  }
}

export default Board;
