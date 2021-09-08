import React, { useState,Component } from 'react';
import Axios from "axios";
class Join extends React.Component{
    state = {ID:'', IDCheck:''};

  handleSubmit = async(e) => {
    const {ID, PW, SX, BT, NM, ADR, EA, MN, PW2} = e.target;
    const CA = new Date();
    try{  
       
    var userfrm = {
      _id:ID.value ,
      PW :PW.value ,
      SX: SX.value ,
      BT : BT.value ,
      NM : NM.value,
      ADR : ADR.value ,
      EA : EA.value,
      MN : MN.value,
      CA 
  }
    
    userfrm = JSON.stringify(userfrm);
    alert(userfrm);
    //alert(userfrm); 
 
      let res = await Axios.post('/api/user',userfrm, {
        headers: { "Content-Type": `application/json`}
          });
    }catch(err){
      console.log(err);
      alert('ertawehfl')
    }
    }

    handleChange = async(e)=>{
      if(e.target.value.length<6 | e.target.value.length>12){
       this.setState({IDCheck : "아이디는 6~12자이상, 영어,숫자,_,-만 사용가능합니다. "});    
      }
      else{
        try{
          await this.setState({ID:e.target.value});
          let res = await Axios.get('/api/user?id='+this.state.ID); 
          await this.setState({IDCheck : "해당아이디는"+res.data});
          console.log(res);
        }catch(err){
          console.error(err);
        }

      }

    };
    handlePasswordCheck = async(e)=>{
      try{

      }catch(err){
        console.error(err);
      }
    };

    render(){
  return (
    <form onSubmit = {this.handleSubmit} >
        <div>
            아이디 <input type = "text" name = "ID" onChange={this.handleChange} /> <span>아이디는 = {this.state.IDCheck}</span>
        </div>
        <div>
            이름 <input type = "text" name = "NM"/>
        </div>
        <div>
            비밀번호 <input type = "password" name = "PW" placeholder = '영문자+숫자+특수문자 조합'/>
        </div>
        <div>
            비밀번호 확인 <input type = "password" name = "PW2" onChange={this.handlePasswordCheck} />
        </div>
        <div>
            주소 <input type = "text" name = "ADR"/>
        </div>
        <div>
            이메일 <input type = "text" name = "EA"/>
        </div>
        <div>
            전화 번호<input type = 'text' name = 'MN'/>
        </div>
        <div>
            성별<select name = 'SX'>
              <option value = '1' >남자 </option>
              <option value = '2' >여자 </option>
            </select>
        </div>
        <div>
            생년월일<input type = 'date' name = 'BT'/>
        </div>
        <div>
            Mobile-Number<input type = 'number' name = 'MN'/>
        </div>
     <button>회원 가입</button>
    </form>

  )
    }
}

export default Join;