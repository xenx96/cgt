import React, {Component } from 'react';
import Axios from "axios";
class Board extends React.Component {
  state = {

  }

  handleSubmit = async(e) => {
      e.preventDefault();
      const {CT, CS, RA} = e.target;
      const CA = new Date();
      try{

      var boardfrm = {
        _id: CT.value,
        BID: "1",
        UI: "user",
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
      }catch(err){
        console.log(err);
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
